package com.example.rabbitmq.Repository;

import com.example.rabbitmq.Entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarefaInterfaceRepository extends JpaRepository<TarefaEntity, Long> {
    List<TarefaEntity> findAll();
    Optional<TarefaEntity> findById(Long id);
}
