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
        Optional<Veiculo> veiculo = this.veiculoRepository.findById(id);
        return veiculo.orElseThrow(()-> new RuntimeException(
                        "Obejto encontrado:" + Veiculo.class.getName()
                )
        );
    }
    public List<Veiculo> findAll(){
        return this.veiculoRepository.findAll();
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
