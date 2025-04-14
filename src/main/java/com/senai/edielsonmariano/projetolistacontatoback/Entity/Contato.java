package com.senai.edielsonmariano.projetolistacontatoback.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome", nullable = false ,length = 100)
    private String nome;

    @Column(name = "telefone", nullable = true ,length = 11)
    private String telefone;

    @Column(name = "email", nullable = true ,length = 100)
    private String email;

    public Contato() {}

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
