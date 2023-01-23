package br.com.mesttra.helpdeskangular.controller;

import br.com.mesttra.helpdeskangular.dto.SuporteDTO;
import br.com.mesttra.helpdeskangular.dto.TicketDTO;
import br.com.mesttra.helpdeskangular.entity.Suporte;
import br.com.mesttra.helpdeskangular.entity.Ticket;
import br.com.mesttra.helpdeskangular.services.SuporteService;
import br.com.mesttra.helpdeskangular.services.TicketService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/suporte")
public class SuporteController {

    @Autowired
    private SuporteService suporteService;

    @Autowired
    private TicketService ticketService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SuporteDTO> findById(@PathVariable Integer id) {
        Suporte objeto = suporteService.findById(id);
        return ResponseEntity.ok().body(new SuporteDTO(objeto));
    }

    @GetMapping(value = "/ticket/{id}")
    public ResponseEntity<TicketDTO> findByIdTick(@PathVariable Integer id) {
        Ticket obj = ticketService.findById(id);
        return ResponseEntity.ok().body(new TicketDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<SuporteDTO>> findAll() {
        List<Suporte> list = suporteService.findAll();
        List<SuporteDTO> listDTO = list.stream().map(obj -> new SuporteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PreAuthorize("hasAnyRole('GERENTE')")
    @PostMapping
    public ResponseEntity<SuporteDTO> create(@Valid @RequestBody SuporteDTO objetoDTO) {
        Suporte objeto = suporteService.create(objetoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objeto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PreAuthorize("hasAnyRole('GERENTE')")

    @PutMapping(value = "/{id}")
    public ResponseEntity<SuporteDTO> update(@PathVariable Integer id, @Valid @RequestBody SuporteDTO objetoDTO) {
        Suporte objeto = suporteService.update(id, objetoDTO);
        return ResponseEntity.ok().body(new SuporteDTO(objeto));
    }

    @PreAuthorize("hasAnyRole('GERENTE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SuporteDTO> delete(@PathVariable Integer id) {
        suporteService.delete(id);
        return ResponseEntity.noContent().build();
    }



}