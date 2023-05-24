package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;
    public Veiculo findById(Long id){
        if(id == 0){
            throw new RuntimeException(", Id informado não localizado!");

        }   else if(veiculoRepository.findById(id).isEmpty()){
            throw new RuntimeException((", não foi possivel localizar marca informado!"));

        }else {
            return veiculoRepository.findById(id).orElse(null);
        }

    }
    public List<Veiculo> findAll(){
        if (veiculoRepository.findAll().isEmpty()){
            throw new RuntimeException(", banco de dados nao possui condutor cadastrado");
        }else{
            return veiculoRepository.findAll();
        }
    }
    @Transactional
    public void cadastrar (Veiculo veiculo){
        this.veiculoRepository.save(veiculo);
    }
    @Transactional
    public void deletar (Veiculo veiculo){
        this.veiculoRepository.delete(veiculo);
    }
    @Transactional
    public void atualizar (Veiculo veiculo){
        this.veiculoRepository.save(veiculo);
    }
}
