package com.senai.edielsonmariano.projetolistacontatoback.service;

import com.senai.edielsonmariano.projetolistacontatoback.Entity.Grupo;
import com.senai.edielsonmariano.projetolistacontatoback.Repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> listarGrupos() {
        return grupoRepository.findAll();
    }

    public Grupo buscarGrupoPorId(Integer id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado com o ID: " + id));
    }

    public Grupo adicionarGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public Grupo editarGrupo(Grupo grupo) {
        if (!grupoRepository.existsById(grupo.getId())) {
            throw new RuntimeException("Grupo não encontrado para edição com o ID: " + grupo.getId());
        }
        return grupoRepository.save(grupo);
    }

    public void deletarGrupo(Integer id) {
        if (!grupoRepository.existsById(id)) {
            throw new RuntimeException("Grupo não encontrado para exclusão com o ID: " + id);
        }
        grupoRepository.deleteById(id);
    }
}
