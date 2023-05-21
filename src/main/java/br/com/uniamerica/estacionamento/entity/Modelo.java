package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
@Table(name="tb_modelo", schema = "public")
@Entity
@Audited
@AuditTable(value="modelo_audit", schema="audit")
@NoArgsConstructor
public class Modelo extends AbstratEntity {
    @Getter
    @Setter
    @Column(name = "nome", nullable = false, length = 50, unique = true)
    private String nome;
    @Getter
    @Setter
    @ManyToOne
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;



}
