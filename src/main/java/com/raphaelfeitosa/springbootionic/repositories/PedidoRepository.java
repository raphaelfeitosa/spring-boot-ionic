package com.raphaelfeitosa.springbootionic.repositories;

import com.raphaelfeitosa.springbootionic.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
