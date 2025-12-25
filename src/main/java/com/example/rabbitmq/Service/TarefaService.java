package com.example.rabbitmq.Service;

import com.example.rabbitmq.Dto.TarefaDtoRequest;
import com.example.rabbitmq.Dto.TarefaDtoResponse;
import com.example.rabbitmq.Interface.TarefaServiceInterface;
import com.example.rabbitmq.Mapper.MapperTarefa;
import com.example.rabbitmq.Repository.TarefaInterfaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TarefaService implements TarefaServiceInterface {

    private final MapperTarefa mapperTarefa;

    private final TarefaInterfaceRepository tarefaInterfaceRepository;

    private final RabbitTemplate rabbitTemplate;

    @Override
    public TarefaDtoResponse criarTarefa(TarefaDtoRequest tarefaDtoRequest) {
        var paraTarefaEntity = mapperTarefa.paraTarefaEntity(tarefaDtoRequest);
        var tarefa = tarefaInterfaceRepository.save(paraTarefaEntity);
        return mapperTarefa.paraTarefaDtoResponse(tarefa);
    }

    @Override
    public TarefaDtoResponse buscarUmaTarefa(Long id) {
        var tarefa = tarefaInterfaceRepository.findById(id).orElseThrow();
        return mapperTarefa.paraTarefaDtoResponse(tarefa);
    }

    @Override
    public List<TarefaDtoResponse> listaTarefas() {
        return tarefaInterfaceRepository
                .findAll()
                .stream()
                .map(
                        tarefaEntity -> mapperTarefa.paraTarefaDtoResponse(tarefaEntity)
                )
                .toList();
    }

    @Override
    public void processaTarefa(TarefaDtoRequest tarefaDtoRequest) {
        System.out.println("Processando mensagem");
        rabbitTemplate.convertAndSend("exchange-exemplo.ex", "", tarefaDtoRequest);

    }
}
