package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Configuracao;
import br.com.uniamerica.estacionamento.repository.ConfiguracaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfiguracaoService {
    @Autowired
    private ConfiguracaoRepository configuracaoRepository;
    public Configuracao findById(Long id){
        Optional<Configuracao> configuracao = this.configuracaoRepository.findById(id);
        return  configuracao.orElseThrow(()-> new RuntimeException(
                "Objeto Encontrado :" + Configuracao.class.getName()
        )
        );

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
