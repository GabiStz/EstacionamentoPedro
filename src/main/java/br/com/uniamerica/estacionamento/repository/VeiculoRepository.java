package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    @Modifying
    @Query("UPDATE Veiculo veiculo SET veiculo.ativo = false WHERE veiculo.id = :idVeiculo")
    public void desativar(@Param("idVeiculo") Long id);
}
