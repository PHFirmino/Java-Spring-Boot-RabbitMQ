package com.example.rabbitmq.Dto;

import com.example.rabbitmq.Entity.TarefaEntity;
import org.springframework.stereotype.Component;

public record TarefaDtoRequest(String descricao, Boolean status) {
}
