package com.senai.edielsonmariano.projetolistacontatoback.Repository;

import com.senai.edielsonmariano.projetolistacontatoback.Entity.Agenda;
import com.senai.edielsonmariano.projetolistacontatoback.enums.StatusAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Integer> {
    @Query("SELECT a FROM Agenda a JOIN a.contatos c WHERE c.id IN :idsContatos AND a.dataHora BETWEEN :inicio AND :fim")
    List<Agenda> findConflitosAgendamento(@Param("idsContatos") List<Integer> idsContatos, @Param("inicio") LocalDateTime inicio, @Param("fim") LocalDateTime fim);

    @Query("SELECT a FROM Agenda a WHERE a.status = :status")
    List<Agenda> buscarPorStatus(@Param("status") StatusAgendamento status);
}
