package com.gabriel.novo_gerenciador_tarefas.dtos;

import java.time.LocalDateTime;

public record TarefaResponseDTO(Long id, String titulo, String descricao, String status, LocalDateTime dataCriacao) {
}
