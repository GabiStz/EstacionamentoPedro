package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import br.com.uniamerica.estacionamento.repository.MovimentacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacoRepository movimentacoRepository;
    public Movimentacao findById(Long id){
        Optional<Movimentacao> movimentacao = this.movimentacoRepository.findById(id);
        return movimentacao.orElseThrow(()-> new RuntimeException(
                "Obejto encontrado:" + Movimentacao.class.getName()
        )
        );
    }
    public List<Movimentacao>findAll(){
        return this.movimentacoRepository.findAll();
    }
    @Transactional
    public void cadastrar (Movimentacao movimentacao){
        this.movimentacoRepository.save(movimentacao);
    }
    @Transactional
    public void delete (Movimentacao movimentacao){
        this.movimentacoRepository.delete(movimentacao);
    }
    @Transactional
    public void atualizar (Movimentacao movimentacao){
        this.movimentacoRepository.save(movimentacao);
    }

}
