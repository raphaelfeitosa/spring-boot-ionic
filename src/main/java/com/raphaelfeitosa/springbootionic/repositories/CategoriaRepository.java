package com.raphaelfeitosa.springbootionic.repositories;

import com.raphaelfeitosa.springbootionic.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
