package br.com.mesttra.helpdeskangular.services;

import br.com.mesttra.helpdeskangular.dto.ClienteDTO;
import br.com.mesttra.helpdeskangular.dto.SuporteDTO;
import br.com.mesttra.helpdeskangular.entity.Cliente;
import br.com.mesttra.helpdeskangular.entity.Pessoa;
import br.com.mesttra.helpdeskangular.entity.Suporte;
import br.com.mesttra.helpdeskangular.exception.DataIntegrityViolationException;
import br.com.mesttra.helpdeskangular.exception.ObjectNotFoundException;
import br.com.mesttra.helpdeskangular.repository.ClienteRepository;
import br.com.mesttra.helpdeskangular.repository.PessoaRepository;
import br.com.mesttra.helpdeskangular.repository.SuporteRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public Cliente findById(Integer id) {
        Optional<Cliente> objeto = clienteRepository.findById(id);
        return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO objeto) {
        objeto.setSenha(passwordEncoder.encode(objeto.getSenha()));
        validaCpf(objeto);
        objeto.setId(null);
        Cliente newObj = new Cliente(objeto);
        return clienteRepository.save(newObj);
    }

    public Cliente update(Integer id, @Valid ClienteDTO objeto) {
        objeto.setId(id);
        Cliente newObj = findById(id);
        validaCpf(objeto);
        newObj = new Cliente(objeto);
        return clienteRepository.save(newObj);


    }

    public void delete(Integer id) {
        Cliente objeto = findById(id);
        if(objeto.getTickets().size() > 0) {
            throw new DataIntegrityViolationException("Não é possível excluir um cliente que possui tickets abertos");
        }

        clienteRepository.deleteById(id);
    }

    private void validaCpf(ClienteDTO objeto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objeto.getCpf());
        if (obj.isPresent()) {
            throw new DataIntegrityViolationException("CPF já cadastrado!");
        }

    }



}
