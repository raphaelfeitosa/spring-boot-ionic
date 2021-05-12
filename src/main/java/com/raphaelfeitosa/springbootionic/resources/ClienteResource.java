package com.raphaelfeitosa.springbootionic.resources;

import com.raphaelfeitosa.springbootionic.domain.Cliente;
import com.raphaelfeitosa.springbootionic.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find(@PathVariable Long id){

        Cliente cliente = clienteService.find(id);
        return ResponseEntity.ok().body(cliente);

    }

}
