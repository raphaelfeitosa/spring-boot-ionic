package com.raphaelfeitosa.springbootionic.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.raphaelfeitosa.springbootionic.enums.EstadoPagamento;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamento_com_boleto")
public class PagamentoComBoleto  extends Pagamento{

    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDateTime dataVencimento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDate dataPamento;

    public PagamentoComBoleto(){}

    public PagamentoComBoleto(Long id, EstadoPagamento estado, Pedido pedido, LocalDateTime dataVencimento, LocalDate dataPamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPamento = dataPamento;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataPamento() {
        return dataPamento;
    }

    public void setDataPamento(LocalDate dataPamento) {
        this.dataPamento = dataPamento;
    }
}
