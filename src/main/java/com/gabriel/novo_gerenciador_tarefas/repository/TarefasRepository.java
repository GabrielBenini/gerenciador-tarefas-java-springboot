package com.gabriel.novo_gerenciador_tarefas.repository;

import com.gabriel.novo_gerenciador_tarefas.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}
