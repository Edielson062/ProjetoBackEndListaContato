package com.senai.edielsonmariano.projetolistacontatoback.service;

import com.senai.edielsonmariano.projetolistacontatoback.Entity.Contato;
import com.senai.edielsonmariano.projetolistacontatoback.Repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    public List<Contato> listarContatos() {
        return contatoRepository.findAll();
    }

    public Contato listarContatosPorId(Integer id) {
        return contatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrado"));
    }

    public Contato adicionarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    public Contato editarContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    public void deletarContato(Integer id) {
        contatoRepository.deleteById(id);
    }
}
