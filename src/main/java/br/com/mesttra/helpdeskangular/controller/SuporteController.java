package br.com.mesttra.helpdeskangular.controller;

import br.com.mesttra.helpdeskangular.entity.Suporte;
import br.com.mesttra.helpdeskangular.services.SuporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/suporte")
public class SuporteController {

    @Autowired
    private SuporteService suporteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Suporte> findById(@PathVariable Integer id) {
        Suporte objeto = suporteService.findById(id);
        return ResponseEntity.ok().body(objeto);
    }



}
