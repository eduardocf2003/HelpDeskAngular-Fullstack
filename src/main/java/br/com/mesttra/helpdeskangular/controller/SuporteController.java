package br.com.mesttra.helpdeskangular.controller;

import br.com.mesttra.helpdeskangular.dto.SuporteDTO;
import br.com.mesttra.helpdeskangular.entity.Suporte;
import br.com.mesttra.helpdeskangular.services.SuporteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<SuporteDTO> findById(@PathVariable Integer id) {
        Suporte objeto = suporteService.findById(id);
        return ResponseEntity.ok().body(new SuporteDTO(objeto));
    }

    @GetMapping
    public ResponseEntity<List<SuporteDTO>> findAll() {
        List<Suporte> list = suporteService.findAll();
        List<SuporteDTO> listDTO = list.stream().map(obj -> new SuporteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<SuporteDTO> create(@Valid @RequestBody SuporteDTO objetoDTO) {
        Suporte objeto = suporteService.create(objetoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objeto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SuporteDTO> update(@PathVariable Integer id, @Valid @RequestBody SuporteDTO objetoDTO) {
        Suporte objeto = suporteService.update(id, objetoDTO);
        return ResponseEntity.ok().body(new SuporteDTO(objeto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<SuporteDTO> delete(@PathVariable Integer id) {
        suporteService.delete(id);
        return ResponseEntity.noContent().build();
    }



}