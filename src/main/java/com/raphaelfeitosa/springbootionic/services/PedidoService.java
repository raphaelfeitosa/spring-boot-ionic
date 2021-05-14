package com.raphaelfeitosa.springbootionic.services;

import com.raphaelfeitosa.springbootionic.domain.ItemPedido;
import com.raphaelfeitosa.springbootionic.domain.PagamentoComBoleto;
import com.raphaelfeitosa.springbootionic.domain.Pedido;
import com.raphaelfeitosa.springbootionic.enums.EstadoPagamento;
import com.raphaelfeitosa.springbootionic.repositories.ItemPedidoRepository;
import com.raphaelfeitosa.springbootionic.repositories.PagamentoRepository;
import com.raphaelfeitosa.springbootionic.repositories.PedidoRepository;
import com.raphaelfeitosa.springbootionic.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    protected PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public Pedido find(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    @Transactional
    public Pedido insert(Pedido pedido) {
        pedido.setId(null);
        pedido.setInstante(new Date());
        pedido.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        pedido.getPagamento().setPedido(pedido);
        if(pedido.getPagamento() instanceof PagamentoComBoleto){
            PagamentoComBoleto pagto = (PagamentoComBoleto) pedido.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, pedido.getInstante());
        }

        pedido = pedidoRepository.save(pedido);
        pagamentoRepository.save(pedido.getPagamento());
        for(ItemPedido itemPedido : pedido.getItens()){
            itemPedido.setDesconto(0.0);
            itemPedido.setPreco(produtoService.find(itemPedido.getProduto().getId()).getPreco());
            itemPedido.setPedido(pedido);
        }
        itemPedidoRepository.saveAll(pedido.getItens());

        return pedido;

    }
}
