package com.senai.edielsonmariano.projetolistacontatoback.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @ManyToMany(mappedBy = "grupos")
    private List<Contato> contatos;

    public Grupo() {}

    public Grupo(String nome) {
        this.nome = nome;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Contato> getContatos() { return contatos; }
    public void setContatos(List<Contato> contatos) { this.contatos = contatos; }
}
