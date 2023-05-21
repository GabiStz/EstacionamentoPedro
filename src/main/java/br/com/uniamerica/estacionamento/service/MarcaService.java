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
        Optional<Marca> marca = this.marcaRepository.findById(id);
        return marca.orElseThrow(()-> new RuntimeException(
                "Marca encontrada:" + Marca.class.getName()
        )
        );
    }
    public List<Marca>findAll(){
        return this.marcaRepository.findAll();
    }
    @Transactional
    public void cadastra (Marca marca){
        this.marcaRepository.save(marca);
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
