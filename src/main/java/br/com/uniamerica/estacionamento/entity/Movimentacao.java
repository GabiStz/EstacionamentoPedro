package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Table(name = "tb_movimentacao", schema = "public")
@Entity
@NoArgsConstructor
public class Movimentacao extends AbstratEntity {
    @Getter
    @Setter
    @ManyToOne
    @NotNull(message = "Campo precisa ser preenchido")
    @JoinColumn(name = "veiculo_id",nullable = false)
    private Veiculo veiculo;
    @Getter
    @Setter
    @ManyToOne
    @NotNull(message = "Campo precisa ser preenchido")
    @JoinColumn(name = "condutor_id",nullable = false)
    private Condutor condutor;
    @Getter
    @Setter
    @NotNull(message = "Campo precisa ser preenchido")
    @Column(name = "entrada", nullable = false)

    private LocalDateTime entrada;
    @Getter
    @Setter
    @Column(name = "saida")
    private LocalDateTime saida;

    @Getter
    @Setter
    @Column(name = "tempo")
    private LocalTime tempo;

    @Getter
    @Setter
    @Column(name = "tempoDesconto")
    private LocalTime tempoDesconto;

    @Getter
    @Setter
    @Column(name = "tempoMulta")
    private LocalTime tempoMulta;

    @Getter
    @Setter
    @Column(name = "valordesconto")
    private BigDecimal valorDesconto;
    @Getter
    @Setter
    @Column(name = "valordamulta")
    private BigDecimal valorMulta;
    @Getter
    @Setter
    @Column(name = "valortotal")
    private BigDecimal valorTotal;
    @Getter
    @Setter
    @Column(name = "valorhora")
    private BigDecimal valorHora;
    @Getter
    @Setter
    @Column(name = "valorhoramulta")
    private BigDecimal valorHoraMulta;


}


