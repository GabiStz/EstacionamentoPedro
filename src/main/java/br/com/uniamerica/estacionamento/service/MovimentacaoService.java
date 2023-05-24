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
        if(id == 0){
            throw new RuntimeException(", Id informado não localizado!");

        }   else if(movimentacoRepository.findById(id).isEmpty()){
            throw new RuntimeException((", não foi possivel localizar marca informado!"));

        }else {
            return movimentacoRepository.findById(id).orElse(null);
        }

    }
    public List<Movimentacao>findAll(){
        if (movimentacoRepository.findAll().isEmpty()){
            throw new RuntimeException(", banco de dados nao possui condutor cadastrado");
        }else{
            return movimentacoRepository.findAll();
        }
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
