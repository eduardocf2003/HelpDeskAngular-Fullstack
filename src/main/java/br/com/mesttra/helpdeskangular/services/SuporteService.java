package br.com.mesttra.helpdeskangular.services;

import br.com.mesttra.helpdeskangular.entity.Suporte;
import br.com.mesttra.helpdeskangular.repository.SuporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class SuporteService {

    @Autowired
    private SuporteRepository suporteRepository;

    public Suporte findById(Integer id) {
        Optional<Suporte> objeto = suporteRepository.findById(id);
        return objeto.orElse(null);
    }

}
