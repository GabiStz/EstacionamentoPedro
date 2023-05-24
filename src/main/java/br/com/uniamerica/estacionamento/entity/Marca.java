package br.com.uniamerica.estacionamento.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Campo precisa ser preenchido")
    @Size(min=3, max=25, message = "Preencha o campo com no minimo 3 caracteres e maximo 25")
    @Column(name = "nome", nullable = false, unique = true, length = 50)
    private String nome;

}
