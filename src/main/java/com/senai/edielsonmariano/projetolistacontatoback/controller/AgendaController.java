package com.senai.edielsonmariano.projetolistacontatoback.controller;

import com.senai.edielsonmariano.projetolistacontatoback.Entity.Agenda;
import com.senai.edielsonmariano.projetolistacontatoback.enums.StatusAgendamento;
import com.senai.edielsonmariano.projetolistacontatoback.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agenda")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public List<Agenda> listar() { return agendaService.listarAgendas();}

    @GetMapping("/{id}")
    public Agenda buscar(@PathVariable int id) {return agendaService.buscarAgendaPorId(id);}

    @GetMapping("/status/{status}")
    public List<Agenda> buscarPorStatus(@PathVariable StatusAgendamento status) {
        return agendaService.buscarPorStatus(status);
    }

    @PostMapping
    public Agenda adicionar(@RequestBody Agenda agenda) { return agendaService.adicionarAgenda(agenda);}

    @PutMapping
    public Agenda atualizar(@RequestBody Agenda agenda) { return agendaService.editarAgenda(agenda);}

    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id) { agendaService.deletarAgenda(id);}

}
