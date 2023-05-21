package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@MappedSuperclass
public abstract class AbstratEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Getter
    @Setter
    @Column(name = "cadastro", nullable = false)
    private LocalDateTime cadastro;
    @Getter
    @Setter
    @Column(name = "edicao", nullable = false)
    private LocalDateTime edicao;
    @Getter
    @Setter
    @Column(name = "ativo", nullable = false)
    private boolean ativo;



}
