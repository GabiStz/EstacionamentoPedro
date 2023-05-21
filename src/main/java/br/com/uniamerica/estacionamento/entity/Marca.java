package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "tb_marca", schema = "public")
@Entity
@Audited
@AuditTable(value = "marca_audit", schema = "audit")
@NoArgsConstructor
public class Marca extends AbstratEntity {
    @Getter
    @Setter
    @Column(name = "nome", nullable = false, unique = true, length = 50)
    private String nome;

}
