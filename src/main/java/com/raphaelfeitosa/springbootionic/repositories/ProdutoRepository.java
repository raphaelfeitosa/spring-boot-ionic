package com.raphaelfeitosa.springbootionic.repositories;

import com.raphaelfeitosa.springbootionic.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
