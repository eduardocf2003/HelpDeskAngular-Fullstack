package br.com.mesttra.helpdeskangular.services;

import br.com.mesttra.helpdeskangular.entity.Cliente;
import br.com.mesttra.helpdeskangular.entity.Suporte;
import br.com.mesttra.helpdeskangular.entity.Ticket;
import br.com.mesttra.helpdeskangular.enums.PrioridadeTicket;
import br.com.mesttra.helpdeskangular.enums.StatusTickets;
import br.com.mesttra.helpdeskangular.enums.TiposPerfil;
import br.com.mesttra.helpdeskangular.repository.ClienteRepository;
import br.com.mesttra.helpdeskangular.repository.SuporteRepository;
import br.com.mesttra.helpdeskangular.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private SuporteRepository suporteRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public void instanciaDB() {
        Suporte s1 = new Suporte(null, "Eduardo", "52201693862", "askdsah@gmail.com", "123456", "123456");
        s1.addPerfis(TiposPerfil.GERENTE);

        Cliente cl1 = new Cliente(null, "Eduardo", "32428775863", "adshj@gmail.com", "123456", "123456");

        Ticket t1 = new Ticket(1, PrioridadeTicket.MEDIA, StatusTickets.ABERTO, "Problema com o computador", "Computador não liga", cl1, s1);

        suporteRepository.saveAll(Arrays.asList(s1));
        clienteRepository.saveAll(Arrays.asList(cl1));
        ticketRepository.saveAll(Arrays.asList(t1));
    }

}
