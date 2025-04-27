package com.senai.edielsonmariano.projetolistacontatoback.controller;

import com.senai.edielsonmariano.projetolistacontatoback.Entity.Grupo;
import com.senai.edielsonmariano.projetolistacontatoback.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public List<Grupo> listarGrupos() {
        return grupoService.listarGrupos();
    }

    @GetMapping("/{id}")
    public Grupo buscarGrupo(@PathVariable Integer id) {
        return grupoService.buscarGrupoPorId(id);
    }

    @PostMapping
    public Grupo adicionarGrupo(@RequestBody Grupo grupo) {
        return grupoService.adicionarGrupo(grupo);
    }

    @PutMapping
    public Grupo editarGrupo(@RequestBody Grupo grupo) {
        return grupoService.editarGrupo(grupo);
    }

    @DeleteMapping("/{id}")
    public void deletarGrupo(@PathVariable Integer id) {
        grupoService.deletarGrupo(id);
    }
}
