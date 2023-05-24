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
        if(id == 0){
            throw new RuntimeException(", Id informado não localizado!");

        }   else if(modeloRepository.findById(id).isEmpty()){
            throw new RuntimeException((", não foi possivel localizar modelo informado!"));

        }else {
            return modeloRepository.findById(id).orElse(null);
        }
    }
    public List<Modelo> findAll(){
        if (modeloRepository.findAll().isEmpty()){
            throw new RuntimeException(", banco de dados nao possui condutor cadastrado");
        }else{
            return modeloRepository.findAll();
        }
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
