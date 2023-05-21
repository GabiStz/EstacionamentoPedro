package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.LocalTime;
@Table(name = "tb_condutor", schema = "public")
@Entity
@Audited
@NoArgsConstructor
@AuditTable(value="condutores_audit", schema="audit")
public class Condutor extends AbstratEntity{
    @Getter
    @Setter
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Getter
    @Setter
    @Column(name = "cpf", nullable = false, unique = true, length = 20)
    private String cpf;
    @Getter
    @Setter
    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;

    @Getter
    @Setter
    @Column(name = "tempoPago", nullable = false)
    private LocalTime tempoPago;
    @Getter
    @Setter
    @Column(name = "tempoDesconto", nullable = false)
    private LocalTime tempoDesconto;



}



