package com.gabriel.novo_gerenciador_tarefas.controller;


import com.gabriel.novo_gerenciador_tarefas.dtos.TarefaRequestDTO;
import com.gabriel.novo_gerenciador_tarefas.dtos.TarefaResponseDTO;
import com.gabriel.novo_gerenciador_tarefas.service.TarefasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefasService service;

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criarTarefa(@RequestBody TarefaRequestDTO tarefaRequestDTO){
        TarefaResponseDTO tarefaCriada = service.criarTarefa(tarefaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTarefas(){

        List<TarefaResponseDTO> listagem = service.listarTarefas();

        return ResponseEntity.status(HttpStatus.OK).body(listagem);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscarPorId(@PathVariable("id") Long id){
        TarefaResponseDTO listagem = service.buscarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(listagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(@PathVariable("id") Long id, @RequestBody TarefaRequestDTO tarefaRequestDTO){

        TarefaResponseDTO tarefaAtualizada = service.atualizar(id, tarefaRequestDTO);
        return ResponseEntity.ok(tarefaAtualizada);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }



}
