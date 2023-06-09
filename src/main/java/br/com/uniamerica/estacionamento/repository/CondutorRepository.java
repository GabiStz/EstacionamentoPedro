package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CondutorRepository extends JpaRepository<Condutor, Long> {
    @Query("SELECT condutor FROM Condutor condutor WHERE condutor.ativo = true")
    public  List<Condutor> listarPorAtivo();

    @Query("SELECT movimentacao FROM Movimentacao movimentacao WHERE movimentacao.condutor.id = :id")
    public List<Movimentacao> buscarMovimentacaoPorCondutor(@Param("id") final Long condutorId);

    @Query("SELECT condutor FROM Condutor condutor WHERE condutor.cpf = :cpf")
    public List<Condutor> verificarCPF(@Param("cpf") String cpf);

    @Query("SELECT condutor FROM Condutor condutor WHERE condutor.telefone = :telefone")
    public List<Condutor> verificarTelefone(@Param("telefone")String telefone);


    @Modifying
    @Query("UPDATE Condutor condutor SET condutor.ativo = false WHERE condutor.id = :id")
    public void desativar(@Param("id")Long id);


    @Modifying
    @Query("UPDATE Condutor condutor SET condutor.ativo = true WHERE condutor.id = :id")
    public void ativar(@Param("id")Long id);
}
