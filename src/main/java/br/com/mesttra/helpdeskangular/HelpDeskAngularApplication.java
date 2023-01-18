package br.com.mesttra.helpdeskangular;

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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpDeskAngularApplication {



    public static void main(String[] args) {
        SpringApplication.run(HelpDeskAngularApplication.class, args);
    }


}
