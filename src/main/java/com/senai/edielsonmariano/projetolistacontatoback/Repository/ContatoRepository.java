package com.senai.edielsonmariano.projetolistacontatoback.Repository;

import com.senai.edielsonmariano.projetolistacontatoback.Entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
