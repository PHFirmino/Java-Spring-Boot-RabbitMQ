package com.example.rabbitmq.Listener;

import com.example.rabbitmq.Dto.TarefaDtoRequest;
import com.example.rabbitmq.Service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TarefaOuvir {
    private  final TarefaService tarefaService;

    @RabbitListener(queues = "fila-exemplo.queue")
    public void ouvirMensagemCriarTarefa(TarefaDtoRequest tarefaDtoRequest) {
        System.out.println("Tarefa recebida: " + tarefaDtoRequest);
        tarefaService.criarTarefa(tarefaDtoRequest);
    }
}
