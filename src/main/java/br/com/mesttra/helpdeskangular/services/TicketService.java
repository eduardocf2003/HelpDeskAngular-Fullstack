package br.com.mesttra.helpdeskangular.services;

import br.com.mesttra.helpdeskangular.dto.TicketDTO;
import br.com.mesttra.helpdeskangular.entity.Cliente;
import br.com.mesttra.helpdeskangular.entity.Suporte;
import br.com.mesttra.helpdeskangular.entity.Ticket;
import br.com.mesttra.helpdeskangular.enums.PrioridadeTicket;
import br.com.mesttra.helpdeskangular.enums.StatusTickets;
import br.com.mesttra.helpdeskangular.exception.ObjectNotFoundException;
import br.com.mesttra.helpdeskangular.repository.TicketRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private SuporteService suporteService;

    public Ticket findById(Integer id) {
        Optional<Ticket> objeto = ticketRepository.findById(id);
        return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket create(TicketDTO ticket) {
        return ticketRepository.save(newChamado(ticket));
    }

    public Ticket update(Integer id, @Valid TicketDTO ticket) {
        ticket.setId(id);
        Ticket oldObj = findById(id);
        oldObj = newChamado(ticket);
        return ticketRepository.save(oldObj);
    }

    private Ticket newChamado(TicketDTO obj) {
        Suporte sup = suporteService.findById(obj.getSuporte());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Ticket chamado = new Ticket();
        if(obj.getId() != null) {
            chamado.setId(obj.getId());
        }

        if(obj.getStatus().equals(2)) {
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setSuporte(sup);
        chamado.setCliente(cliente);
        chamado.setPrioridade(PrioridadeTicket.toEnum(obj.getPrioridade()));
        chamado.setStatus(StatusTickets.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());
        return chamado;
    }





}
