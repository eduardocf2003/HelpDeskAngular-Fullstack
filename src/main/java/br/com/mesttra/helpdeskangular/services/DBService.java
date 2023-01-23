//package br.com.mesttra.helpdeskangular.services;
//
//import br.com.mesttra.helpdeskangular.entity.Cliente;
//import br.com.mesttra.helpdeskangular.entity.Suporte;
//import br.com.mesttra.helpdeskangular.entity.Ticket;
//import br.com.mesttra.helpdeskangular.enums.PrioridadeTicket;
//import br.com.mesttra.helpdeskangular.enums.PrioridadeTicket;
//import br.com.mesttra.helpdeskangular.enums.StatusTickets;
//import br.com.mesttra.helpdeskangular.enums.StatusTickets;
//import br.com.mesttra.helpdeskangular.enums.TiposPerfil;
//import br.com.mesttra.helpdeskangular.repository.ClienteRepository;
//import br.com.mesttra.helpdeskangular.repository.PessoaRepository;
//import br.com.mesttra.helpdeskangular.repository.SuporteRepository;
//import br.com.mesttra.helpdeskangular.repository.TicketRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.parameters.P;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//
//@Service
//public class DBService {
//
//    @Autowired
//    private TicketRepository ticketRepository;
//
//    @Autowired
//    private PessoaRepository pessoaRepository;
//
//    public void instanciaDB() {
//
//        Suporte tec1 = new Suporte(null, "Valdir Cezar", "550.482.150-95", "valdir@mail.com", "123");
//        tec1.addPerfis(TiposPerfil.GERENTE);
//        Suporte tec2 = new Suporte(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", "123");
//        Suporte tec3 = new Suporte(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", "123");
//        Suporte tec4 = new Suporte(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", "123");
//        Suporte tec5 = new Suporte(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", "123");
//
//        Cliente cli1 = new Cliente(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", "123");
//        Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", "123");
//        Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", "123");
//        Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", "123");
//        Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", "123");
//
//
//        Ticket c1 = new Ticket(null, PrioridadeTicket.MEDIA, StatusTickets.ANDAMENTO, "Ticket 1", "Teste chamado 1", cli1, tec1);
//        Ticket c2 = new Ticket(null, PrioridadeTicket.ALTA, StatusTickets.ABERTO, "Ticket 2", "Teste chamado 2", cli1, tec2);
//        Ticket c3 = new Ticket(null, PrioridadeTicket.BAIXA, StatusTickets.FINALIZADO, "Ticket 3", "Teste chamado 3", cli2, tec3);
//        Ticket c4 = new Ticket(null, PrioridadeTicket.ALTA, StatusTickets.ABERTO, "Ticket 4", "Teste chamado 4", cli3, tec3);
//        Ticket c5 = new Ticket(null, PrioridadeTicket.MEDIA, StatusTickets.ANDAMENTO, "Ticket 5", "Teste chamado 5", cli2, tec1);
//        Ticket c6 = new Ticket(null, PrioridadeTicket.BAIXA, StatusTickets.FINALIZADO, "Ticket 7", "Teste chamado 6", cli1, tec5);
//
//        pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
//        ticketRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
//    }
//
//}
