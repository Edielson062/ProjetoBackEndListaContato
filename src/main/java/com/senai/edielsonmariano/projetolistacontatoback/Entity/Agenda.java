package com.senai.edielsonmariano.projetolistacontatoback.Entity;

import com.senai.edielsonmariano.projetolistacontatoback.enums.StatusAgendamento;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "agenda")
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private LocalDateTime dataHora;

    @Column
    private String local;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento status;

    @ManyToMany
    private List<Contato> contatos;

    public Agenda (){}

    public Agenda(String titulo, String descricao, LocalDateTime dataHora, String local) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.local = local;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    public List<Contato> getContatos() { return contatos; }
    public void setContatos(List<Contato> contatos) { this.contatos = contatos; }
}
