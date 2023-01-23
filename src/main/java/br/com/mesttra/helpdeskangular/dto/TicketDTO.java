package br.com.mesttra.helpdeskangular.dto;

import br.com.mesttra.helpdeskangular.entity.Cliente;
import br.com.mesttra.helpdeskangular.entity.Suporte;
import br.com.mesttra.helpdeskangular.entity.Ticket;
import br.com.mesttra.helpdeskangular.enums.PrioridadeTicket;
import br.com.mesttra.helpdeskangular.enums.StatusTickets;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.io.Serializable;
import java.time.LocalDate;

public class TicketDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private Integer prioridade;
    private Integer status;
    private String titulo;
    private String observacoes;
    private Integer cliente;
    private Integer suporte;
    private String nomeTec;
    private String nomeCli;

    public TicketDTO() {
        super();
    }

    public TicketDTO(Ticket obj) {
        this.id = obj.getId();
        this.dataAbertura = obj.getDataAbertura();
        this.dataFechamento = obj.getDataFechamento();
        this.prioridade = obj.getPrioridade().getCod();
        this.status = obj.getStatus().getCod();
        this.titulo = obj.getTitulo();
        this.observacoes = obj.getObservacoes();
        this.suporte = obj.getSuporte().getId();
        this.cliente = obj.getCliente().getId();
        this.nomeCli = obj.getCliente().getNome();
        this.nomeTec = obj.getSuporte().getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getSuporte() {
        return suporte;
    }

    public void setSuporte(Integer suporte) {
        this.suporte = suporte;
    }

    public String getNomeTec() {
        return nomeTec;
    }

    public void setNomeTec(String nomeTec) {
        this.nomeTec = nomeTec;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }
}
