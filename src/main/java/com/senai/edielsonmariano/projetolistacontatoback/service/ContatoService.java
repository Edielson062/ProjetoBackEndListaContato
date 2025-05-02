package com.senai.edielsonmariano.projetolistacontatoback.service;

import com.senai.edielsonmariano.projetolistacontatoback.Entity.Contato;
import com.senai.edielsonmariano.projetolistacontatoback.Entity.Grupo;
import com.senai.edielsonmariano.projetolistacontatoback.Repository.ContatoRepository;
import com.senai.edielsonmariano.projetolistacontatoback.Repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Contato> listarContatos() {
        return contatoRepository.findAll();
    }

    public Contato listarContatosPorId(Integer id) {
        return contatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Contato não encontrado"));
    }

    public List<Contato> listarContatosPorGrupo(int grupoId) {
        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
        return grupo.getContatos();
    }

    public Contato adicionarContato(Contato contato) {
        if (contato.getGrupos() != null) {
            List<Grupo> grupos = grupoRepository.findAllById(
                    contato.getGrupos().stream()
                            .map(Grupo::getId)
                            .toList()
            );
            contato.setGrupos(grupos);
        }
        return contatoRepository.save(contato);
    }

    public Contato editarContato(Contato contato) {
        if (contato.getGrupos() != null) {
            List<Grupo> grupos = grupoRepository.findAllById(
                    contato.getGrupos().stream()
                            .map(Grupo::getId)
                            .toList()
            );
            contato.setGrupos(grupos);
        }
        return contatoRepository.save(contato);
    }

    public void deletarContato(Integer id) {
        contatoRepository.deleteById(id);
    }
}
