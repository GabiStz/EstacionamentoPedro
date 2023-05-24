package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Configuracao;
import br.com.uniamerica.estacionamento.repository.ConfiguracaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiguracaoService {
    @Autowired
    private ConfiguracaoRepository configuracaoRepository;
    public Configuracao findById(Long id){
        if(id == 0){
            throw new RuntimeException(", Id informado não localizado!");

        }   else if(configuracaoRepository.findById(id).isEmpty()){
            throw new RuntimeException((", não foi possivel localizar configuracao informado!"));

        }else {
            return configuracaoRepository.findById(id).orElse(null);
        }


    }
    public List<Configuracao> findAll(){
        if (configuracaoRepository.findAll().isEmpty()){
            throw new RuntimeException(", banco de dados nao possui condutor cadastrado");
        }else{
            return configuracaoRepository.findAll();
        }
    }
    @Transactional
    public void cadastar(Configuracao configuracao){
        this.configuracaoRepository.save(configuracao);
    }
    @Transactional
    public void atualizar (Configuracao configuracao){
        this.configuracaoRepository.save(configuracao);
    }
}
