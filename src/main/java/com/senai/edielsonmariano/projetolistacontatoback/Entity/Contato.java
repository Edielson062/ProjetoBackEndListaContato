package com.senai.edielsonmariano.projetolistacontatoback.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "telefone", length = 11)
    private String telefone;

    @Column(name = "email", length = 100)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "contato_grupo",
            joinColumns = @JoinColumn(name = "contato_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id")
    )
    private List<Grupo> grupos;

    @OneToMany
    private List<Agenda> agendamentos;

    public Contato() {}

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Grupo> getGrupos() { return grupos; }
    public void setGrupos(List<Grupo> grupos) { this.grupos = grupos; }

    public List<Agenda> getAgendamentos() { return agendamentos; }
    public void setAgendamentos(List<Agenda> agendamentos) { this.agendamentos = agendamentos; }
}
