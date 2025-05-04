package com.senai.edielsonmariano.projetolistacontatoback.service;

import com.senai.edielsonmariano.projetolistacontatoback.Entity.Agenda;
import com.senai.edielsonmariano.projetolistacontatoback.Entity.Contato;
import com.senai.edielsonmariano.projetolistacontatoback.Entity.Grupo;
import com.senai.edielsonmariano.projetolistacontatoback.Repository.AgendaRepository;
import com.senai.edielsonmariano.projetolistacontatoback.Repository.ContatoRepository;
import com.senai.edielsonmariano.projetolistacontatoback.enums.StatusAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaService {
    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private ContatoRepository contatoRepository;

    public List<Agenda> listarAgendas() {
        return this.agendaRepository.findAll();
    }

    public Agenda buscarAgendaPorId(Integer id) {
        return this.agendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + id));
    }

    public List<Agenda> buscarPorStatus(StatusAgendamento status) {
        return agendaRepository.buscarPorStatus(status);
    }

    public Agenda adicionarAgenda(Agenda agenda) {
        if (agenda.getContatos() != null && agenda.getDataHora() != null) {
            List<Integer> idsContatos = agenda.getContatos().stream()
                    .map(Contato::getId)
                    .toList();

            LocalDateTime inicio = agenda.getDataHora().minusHours(1);
            LocalDateTime fim = agenda.getDataHora().plusHours(1);

            List<Agenda> conflitos = agendaRepository.findConflitosAgendamento(idsContatos, inicio, fim);

            if (!conflitos.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Um ou mais contatos já possuem agendamentos nesse intervalo de 1 hora.");
            }

            List<Contato> contatos = contatoRepository.findAllById(idsContatos);
            agenda.setContatos(contatos);
        }

        return this.agendaRepository.save(agenda);
    }


    public Agenda editarAgenda(Agenda agenda) {
        if (!agendaRepository.existsById(agenda.getId())) {
            throw new RuntimeException("Agendamento não encontrado para edição com o ID: " + agenda.getId());
        }

        if (agenda.getContatos() != null && agenda.getDataHora() != null) {
            List<Integer> idsContatos = agenda.getContatos().stream()
                    .map(Contato::getId)
                    .toList();

            LocalDateTime inicio = agenda.getDataHora().minusHours(1);
            LocalDateTime fim = agenda.getDataHora().plusHours(1);

            List<Agenda> conflitos = agendaRepository.findConflitosAgendamento(idsContatos, inicio, fim).stream()
                    .filter(a -> !a.getId().equals(agenda.getId())) // ignorar o próprio agendamento
                    .toList();

            if (!conflitos.isEmpty()) {
                throw new RuntimeException("Um ou mais contatos já possuem agendamentos nesse intervalo de 1 hora.");
            }

            List<Contato> contatos = contatoRepository.findAllById(idsContatos);
            agenda.setContatos(contatos);
        }

        return this.agendaRepository.save(agenda);
    }

    public void deletarAgenda(Integer id) {
        if (!this.agendaRepository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado para exclusão com o ID: " + id);
        }
        this.agendaRepository.deleteById(id);
    }
}
