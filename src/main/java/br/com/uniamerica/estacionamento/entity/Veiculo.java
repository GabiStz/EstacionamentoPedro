package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "tb_veiculo", schema = "public")
@Entity
@NoArgsConstructor
public class Veiculo extends AbstratEntity{
    @Getter
    @Setter
    @Column(name = "placa", nullable = false, unique = true, length = 10)
    private String placa;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "modelo_id",nullable = false)
    private  Modelo modelo;
    @Getter
    @Setter
    @Column(name = "cor", nullable = false)
    @Enumerated(EnumType.STRING)
    private Cor cor;
    @Getter
    @Setter
    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Getter
    @Setter
    @Column(name = "ano", nullable = false)
    private int ano;




}
