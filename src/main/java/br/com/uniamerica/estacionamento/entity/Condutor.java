package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

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
    @Size(min=10, max=30, message = "Preencha o campo com no minimo 10 caracteres e maximo 30")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;
    @Getter
    @Setter
    @NotNull(message = "Campo precisa ser preenchido")
    @Size(min=11, max=11, message = "Preencha o campo com no minimo 11 caracteres e maximo 11")
    @Column(name = "cpf", nullable = false, unique = true, length = 20)
    private String cpf;
    @Getter
    @Setter
    @NotNull(message = "Campo precisa ser preenchido")
    @Size(min=20, max=20, message = "Preencha o campo com no minimo 20 caracteres e maximo 20")
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



