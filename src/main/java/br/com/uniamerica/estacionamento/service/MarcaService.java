package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Marca;
import br.com.uniamerica.estacionamento.repository.MarcaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;
    public Marca findById(Long id){

        if(id == 0){
            throw new RuntimeException(", Id informado não localizado!");

        }   else if(marcaRepository.findById(id).isEmpty()){
            throw new RuntimeException((", não foi possivel localizar marca informado!"));

        }else {
            return marcaRepository.findById(id).orElse(null);
        }




    }
    public List<Marca>findAll(){
        if (marcaRepository.findAll().isEmpty()){
            throw new RuntimeException(", banco de dados nao possui marca cadastrada");
        }else{
            return marcaRepository.findAll();
        }
    }
    @Transactional
    public void cadastra (Marca marca){


    }
    @Transactional
    public void delete(Marca marca){
        this.marcaRepository.save(marca);
    }
    @Transactional
    public void atualizar(Marca marca){
        this.marcaRepository.save(marca);
    }
}
