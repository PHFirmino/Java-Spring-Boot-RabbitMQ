package com.example.rabbitmq.Dto;

import org.springframework.stereotype.Component;

public record TarefaDtoResponse(Long id, String descricao, Boolean status) {
}
