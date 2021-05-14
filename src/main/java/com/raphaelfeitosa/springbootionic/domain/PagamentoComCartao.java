package com.raphaelfeitosa.springbootionic.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.raphaelfeitosa.springbootionic.enums.EstadoPagamento;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento_com_cartao")
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento{

    private static final long serialVersionUID = 1L;
    private Integer numeroParcelas;

    public PagamentoComCartao(){}

    public PagamentoComCartao(Long id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
        super(id, estado, pedido);
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
