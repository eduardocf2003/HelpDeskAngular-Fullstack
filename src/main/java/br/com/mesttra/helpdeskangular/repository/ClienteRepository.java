package br.com.mesttra.helpdeskangular.repository;

import br.com.mesttra.helpdeskangular.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

