package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalTime;
@Table(name = "tb_configuracao", schema = "public")
@Entity
@NoArgsConstructor
public class Configuracao extends AbstratEntity{
    @Getter
    @Setter
    @Column(name = "valorHora")
    private BigDecimal valorHora;
    @Getter
    @Setter
    @Column(name = "valorMinutoMulta")
    private BigDecimal valorMinutoMulta;
    @Getter
    @Setter
    @Column(name = "fimExpediente")
    private LocalTime fimExpediente;
    @Getter
    @Setter
    @Column(name = "tempoParaDesconto")
    private LocalTime tempoParaDesconto;
    @Getter
    @Setter
    @Column(name = "tempoDeDesconto")
    private LocalTime tempoDeDesconto;
    @Getter
    @Setter
    @Column(name = "gerarDesconto")
    private boolean gerarDesconto;
    @Getter
    @Setter
    @Column(name = "vagasMotos")
    private int vagasMoto;
    @Getter
    @Setter
    @Column(name = "vagasVan")
    private int vagasVan;
    @Getter
    @Setter
    @Column(name = "vagasCarro")
    private int vagasCarro;



}
