package br.com.mesttra.helpdeskangular.repository;

import br.com.mesttra.helpdeskangular.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}

