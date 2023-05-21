package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {
    private ModeloRepository modeloRepository;
    public Modelo findByid(final Long id){
        Optional<Modelo> modelo = this.modeloRepository.findById(id);
        return modelo.orElseThrow(()-> new RuntimeException(
                "Modelo encontrado:" + Modelo.class.getName()
        )
        );
    }
    public List<Modelo> findAll(){
        return this.modeloRepository.findAll();
    }
 @Transactional
 public void cadastrar(Modelo modelo){
        this.modeloRepository.save(modelo);
 }
@Transactional
    public void delete(Modelo modelo){
        this.modeloRepository.save(modelo);
    }
    @Transactional
    public void atualizar (Modelo modelo){
        this.modeloRepository.save(modelo);
    }



}
