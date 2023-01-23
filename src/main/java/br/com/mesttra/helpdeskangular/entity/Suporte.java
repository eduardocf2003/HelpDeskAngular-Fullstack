package br.com.mesttra.helpdeskangular.entity;

import br.com.mesttra.helpdeskangular.dto.SuporteDTO;
import br.com.mesttra.helpdeskangular.enums.TiposPerfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Suporte extends Pessoa {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "suporte")
    private List<Ticket> tickets = new ArrayList<>();

    public Suporte() {
        super();
    }

    public Suporte(Integer id, String nome, String cpf, String email, String senha, String telefone) {
        super(id, nome, cpf, email, senha, telefone);
        addPerfis(TiposPerfil.CLIENTE);
    }

    public Suporte(SuporteDTO obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.telefone = obj.getTelefone();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCod()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }



}
