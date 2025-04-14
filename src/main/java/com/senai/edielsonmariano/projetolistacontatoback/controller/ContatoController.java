package com.senai.edielsonmariano.projetolistacontatoback.controller;

import com.senai.edielsonmariano.projetolistacontatoback.Entity.Contato;
import com.senai.edielsonmariano.projetolistacontatoback.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> listarContatos() {
        return contatoService.listarContatos();
    }

    @GetMapping("/{id}")
    public Contato listarContatosPorId(@PathVariable int id) {
        return contatoService.listarContatosPorId(id);
    }

    @PostMapping
    public Contato adicionarContato(@RequestBody Contato contato) {
        return contatoService.adicionarContato(contato);
    }

    @PutMapping
    public Contato editarContato(@RequestBody Contato contato) {
        return contatoService.editarContato(contato);
    }

    @DeleteMapping("/{id}")
    public void deletarContato(@PathVariable Integer id) {
        this.contatoService.deletarContato(id);
    }
}
