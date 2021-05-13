package com.raphaelfeitosa.springbootionic.resources;

import com.raphaelfeitosa.springbootionic.domain.Cliente;
import com.raphaelfeitosa.springbootionic.dto.ClienteDTO;
import com.raphaelfeitosa.springbootionic.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteDTO clienteDTO){
//        Cliente cliente = clienteService.fromDTO(clienteDTO);
//        cliente = clienteService.insert(cliente);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
//                .path("/{id}").buildAndExpand(cliente.getId()).toUri();
//        return ResponseEntity.created(uri).build();
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Long id){
        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente.setId(id);
        clienteService.update(cliente);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAll(){
        List<Cliente> listcliente = clienteService.findAll();
        List<ClienteDTO> listclienteDTO = listcliente.stream().map(listDTO-> new ClienteDTO(listDTO)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listclienteDTO);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction){
        Page<Cliente> listcliente = clienteService.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listclienteDTO = listcliente.map(listDTO-> new ClienteDTO(listDTO));
        return ResponseEntity.ok().body(listclienteDTO);
    }


}
