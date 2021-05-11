package com.raphaelfeitosa.springbootionic.repositories;

import com.raphaelfeitosa.springbootionic.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
