package br.com.mesttra.helpdeskangular.entity;

import br.com.mesttra.helpdeskangular.enums.TiposPerfil;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Suporte extends Pessoa {

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "suporte")
    private List<Ticket> tickets = new ArrayList<>();

    public Suporte() {
        super();
    }

    public Suporte(Integer id, String nome, String cpf, String email, String senha, String telefone) {
        super(id, nome, cpf, email, senha, telefone);
        addPerfis(TiposPerfil.SUPORTE);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

}
