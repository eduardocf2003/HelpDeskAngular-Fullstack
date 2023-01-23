package br.com.mesttra.helpdeskangular.controller;

import br.com.mesttra.helpdeskangular.dto.ClienteDTO;
import br.com.mesttra.helpdeskangular.dto.SuporteDTO;
import br.com.mesttra.helpdeskangular.entity.Cliente;
import br.com.mesttra.helpdeskangular.entity.Suporte;
import br.com.mesttra.helpdeskangular.services.ClienteService;
import br.com.mesttra.helpdeskangular.services.SuporteService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
        Cliente objeto = clienteService.findById(id);
        return ResponseEntity.ok().body(new ClienteDTO(objeto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> list = clienteService.findAll();
        List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO objetoDTO) {
        Cliente objeto = clienteService.create(objetoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objeto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO objetoDTO) {
        Cliente objeto = clienteService.update(id, objetoDTO);
        return ResponseEntity.ok().body(new ClienteDTO(objeto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }



}