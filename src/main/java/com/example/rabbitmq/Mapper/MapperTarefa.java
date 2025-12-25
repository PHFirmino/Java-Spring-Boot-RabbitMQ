package com.example.rabbitmq.Mapper;

import com.example.rabbitmq.Dto.TarefaDtoRequest;
import com.example.rabbitmq.Dto.TarefaDtoResponse;
import com.example.rabbitmq.Entity.TarefaEntity;
import org.springframework.stereotype.Component;

@Component
public class MapperTarefa {

    public TarefaEntity paraTarefaEntity(TarefaDtoRequest tarefaDtoRequest){
        return new TarefaEntity(tarefaDtoRequest.descricao(), tarefaDtoRequest.status());
    }

    public TarefaDtoResponse paraTarefaDtoResponse(TarefaEntity tarefaEntity){
        return new TarefaDtoResponse(tarefaEntity.getId(), tarefaEntity.getDescricao(), tarefaEntity.getStatus());
    }
}
