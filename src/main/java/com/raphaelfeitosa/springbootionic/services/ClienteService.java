package com.raphaelfeitosa.springbootionic.services;

import com.raphaelfeitosa.springbootionic.domain.Cliente;
import com.raphaelfeitosa.springbootionic.repositories.ClienteRepository;
import com.raphaelfeitosa.springbootionic.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
