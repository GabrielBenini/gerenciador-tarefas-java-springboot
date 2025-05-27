package com.gabriel.novo_gerenciador_tarefas.service;


import com.gabriel.novo_gerenciador_tarefas.dtos.TarefaRequestDTO;
import com.gabriel.novo_gerenciador_tarefas.dtos.TarefaResponseDTO;
import com.gabriel.novo_gerenciador_tarefas.model.StatusEnum;
import com.gabriel.novo_gerenciador_tarefas.model.Tarefas;
import com.gabriel.novo_gerenciador_tarefas.repository.TarefasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;

    public TarefaResponseDTO criarTarefa(TarefaRequestDTO tarefaRequestDTO){

        // Converter o status de String para StatusEnum

        StatusEnum status = StatusEnum.valueOf(tarefaRequestDTO.status().toUpperCase());

        // Criar a entidade Tarefas a partir do DTO

        Tarefas tarefa = new Tarefas();
        tarefa.setTitulo(tarefaRequestDTO.titulo());
        tarefa.setDescricao(tarefaRequestDTO.descricao());
        tarefa.setStatus(status);

        // dataCriacao será setada automaticamente na entidade com @PrePersist, então não precisa aqui

        // Salvar a entidade no banco
        Tarefas tarefaSalva = tarefasRepository.save(tarefa);

        // Converter a entidade salva para DTO de resposta

        return new TarefaResponseDTO(
                tarefaSalva.getId(),
                tarefaSalva.getTitulo(),
                tarefaSalva.getDescricao(),
                tarefaSalva.getStatus().name(),
                tarefaSalva.getDataCriacao()
        );
    }

    public List<TarefaResponseDTO> listarTarefas(){

        return tarefasRepository.findAll()
                .stream() // Transforma a lista em um fluxo de dados
                .map(tarefa -> new TarefaResponseDTO(
                        tarefa.getId(),
                        tarefa.getTitulo(),
                        tarefa.getDescricao(),
                        tarefa.getStatus().name(),
                        tarefa.getDataCriacao()
                )) // Converte cada tarefa em um tarefaResponseDTO
                .toList(); // coleta tudo de volta em uma lista
    }

    public TarefaResponseDTO buscarPorId(Long id){
        Tarefas tarefa = tarefasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa nao encontrada com o id: " + id));

        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus().name(),
                tarefa.getDataCriacao()
        );

    }

    public TarefaResponseDTO atualizar(Long id, TarefaRequestDTO tarefaRequestDTO){

        Tarefas tarefa = tarefasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa nao encontrada com o id: " + id));

        tarefa.setTitulo(tarefaRequestDTO.titulo());
        tarefa.setDescricao(tarefaRequestDTO.descricao());
        tarefa.setStatus(StatusEnum.valueOf(tarefaRequestDTO.status().toUpperCase()));

        Tarefas tarefaAtualizada = tarefasRepository.save(tarefa);

        return new TarefaResponseDTO(
                tarefaAtualizada.getId(),
                tarefaAtualizada.getTitulo(),
                tarefaAtualizada.getDescricao(),
                tarefaAtualizada.getStatus().name(),
                tarefaAtualizada.getDataCriacao()
        );
    }

    public void deletarPorId(Long id){
        Tarefas tarefa = tarefasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa nao encontrada com o id: " + id));
        tarefasRepository.delete(tarefa);
    }

}
