package com.example.rabbitmq.Controller;

import com.example.rabbitmq.Dto.TarefaDtoRequest;
import com.example.rabbitmq.Dto.TarefaDtoResponse;
import com.example.rabbitmq.Interface.TarefaServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaServiceInterface tarefaServiceInterface;

    @GetMapping("/todas")
    public ResponseEntity<List<TarefaDtoResponse>> listaTarefas() {
        var listaTarefas = tarefaServiceInterface.listaTarefas();
        return ResponseEntity.ok(listaTarefas);
    }

    @GetMapping("/buscaporumatarefa/{id}")
    public ResponseEntity<TarefaDtoResponse> buscarPorUmaTarefa(@PathVariable Long id){
        var tarefa = tarefaServiceInterface.buscarUmaTarefa(id);
        return ResponseEntity.ok(tarefa);
    }

    @PostMapping("/criartarefa")
    public ResponseEntity<Void> criarTarefa(@RequestBody TarefaDtoRequest tarefaDtoRequest){
        tarefaServiceInterface.processaTarefa(tarefaDtoRequest);
        return ResponseEntity.ok().build();
    }
}
