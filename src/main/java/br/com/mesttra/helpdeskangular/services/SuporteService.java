package br.com.mesttra.helpdeskangular.services;

import br.com.mesttra.helpdeskangular.dto.SuporteDTO;
import br.com.mesttra.helpdeskangular.entity.Pessoa;
import br.com.mesttra.helpdeskangular.entity.Suporte;
import br.com.mesttra.helpdeskangular.exception.DataIntegrityViolationException;
import br.com.mesttra.helpdeskangular.exception.ObjectNotFoundException;
import br.com.mesttra.helpdeskangular.repository.PessoaRepository;
import br.com.mesttra.helpdeskangular.repository.SuporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class SuporteService {

    @Autowired
    private SuporteRepository suporteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public Suporte findById(Integer id) {
        Optional<Suporte> objeto = suporteRepository.findById(id);
        return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Suporte.class.getName()));
    }

    public List<Suporte> findAll() {
        return suporteRepository.findAll();
    }

    public Suporte create(SuporteDTO objeto) {
        objeto.setId(null);
        objeto.setSenha(passwordEncoder.encode(objeto.getSenha()));
        validaCpf(objeto);
        Suporte newObj = new Suporte(objeto);
        return suporteRepository.save(newObj);
    }

    public Suporte update(Integer id, @Valid SuporteDTO objeto) {
        objeto.setId(id);
        Suporte newObj = findById(id);
        newObj = new Suporte(objeto);
        return suporteRepository.save(newObj);


    }

    public void delete(Integer id) {
        Suporte objeto = findById(id);
        if(objeto.getTickets().size() > 0) {
            throw new DataIntegrityViolationException("Não é possível excluir um funcionário que possui tickets");
        }

        suporteRepository.deleteById(id);
    }

    private void validaCpf(SuporteDTO objeto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objeto.getCpf());
        if (obj.isPresent()) {
            throw new DataIntegrityViolationException("CPF já cadastrado!");
        }

    }



}
