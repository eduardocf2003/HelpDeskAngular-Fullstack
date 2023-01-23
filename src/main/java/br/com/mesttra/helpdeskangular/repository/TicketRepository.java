package br.com.mesttra.helpdeskangular.repository;

import br.com.mesttra.helpdeskangular.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}

