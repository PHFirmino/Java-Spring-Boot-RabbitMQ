package com.example.rabbitmq.Interface;

import com.example.rabbitmq.Dto.TarefaDtoRequest;
import com.example.rabbitmq.Dto.TarefaDtoResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TarefaServiceInterface {
    TarefaDtoResponse criarTarefa(TarefaDtoRequest tarefaDtoRequest);
    TarefaDtoResponse buscarUmaTarefa(Long id);
    List<TarefaDtoResponse> listaTarefas();
    void processaTarefa(TarefaDtoRequest tarefaDtoRequest);
}
