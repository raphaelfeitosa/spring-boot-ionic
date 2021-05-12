package com.raphaelfeitosa.springbootionic.services;

import com.raphaelfeitosa.springbootionic.domain.Categoria;
import com.raphaelfeitosa.springbootionic.repositories.CategoriaRepository;
import com.raphaelfeitosa.springbootionic.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria categoria) {
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        find(categoria.getId());
        return categoriaRepository.save(categoria);
    }
}
