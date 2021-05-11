package com.raphaelfeitosa.springbootionic.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ItemPedidoPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedidoPK)) return false;

        ItemPedidoPK that = (ItemPedidoPK) o;

        if (!getPedido().equals(that.getPedido())) return false;
        return getProduto().equals(that.getProduto());
    }

    @Override
    public int hashCode() {
        int result = getPedido().hashCode();
        result = 31 * result + getProduto().hashCode();
        return result;
    }
}
