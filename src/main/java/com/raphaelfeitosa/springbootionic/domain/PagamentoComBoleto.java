package com.raphaelfeitosa.springbootionic.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.raphaelfeitosa.springbootionic.enums.EstadoPagamento;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "pagamento_com_boleto")
@JsonTypeName("pagamentoComBoleto")
public class PagamentoComBoleto  extends Pagamento{

    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private Date dataVencimento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private Date dataPamento;

    public PagamentoComBoleto(){}

    public PagamentoComBoleto(Long id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPamento = dataPamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPamento() {
        return dataPamento;
    }

    public void setDataPamento(Date dataPamento) {
        this.dataPamento = dataPamento;
    }
}
