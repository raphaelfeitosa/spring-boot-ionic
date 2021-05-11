package com.raphaelfeitosa.springbootionic.repositories;

import com.raphaelfeitosa.springbootionic.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
