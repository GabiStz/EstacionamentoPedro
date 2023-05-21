package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Configuracao;
import br.com.uniamerica.estacionamento.repository.ConfiguracaoRepository;
import br.com.uniamerica.estacionamento.service.ConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/configuracao")
public class ConfiguracaoController {
    @Autowired
     private ConfiguracaoRepository configuracaoRepository;
    @Autowired
     private ConfiguracaoService configuracaoService;

    @GetMapping("/{id}")
    public ResponseEntity<?>findByIdPath(@PathVariable("id") final Long id){
        try {
           final Configuracao configuracao = this.configuracaoService.findById(id);
           return ResponseEntity.ok().body(configuracao);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Nenhum valor encontrado");
        }
    }
    @PostMapping
    public ResponseEntity<?>cadastrar(@RequestBody final Configuracao configuracao){
        try {
            this.configuracaoService.cadastar(configuracao);
            return ResponseEntity.ok("Cadastrado com Sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>atualizar(@PathVariable ("id") final Long id, @RequestBody Configuracao configuracao){
        Configuracao configuracaoBanco= this.configuracaoService.findById(id);
        configuracaoBanco.setFimExpediente(configuracaoBanco.getFimExpediente());
        configuracaoBanco.setGerarDesconto(configuracaoBanco.isGerarDesconto());
        configuracaoBanco.setVagasMoto(configuracaoBanco.getVagasMoto());
        configuracaoBanco.setVagasCarro(configuracaoBanco.getVagasCarro());
        configuracaoBanco.setVagasVan(configuracaoBanco.getVagasVan());
        configuracaoBanco.setValorHora(configuracaoBanco.getValorHora());
        configuracaoBanco.setValorMinutoMulta(configuracaoBanco.getValorMinutoMulta());
        configuracaoBanco.setTempoParaDesconto(configuracaoBanco.getTempoParaDesconto());
        configuracaoBanco.setTempoDeDesconto(configuracaoBanco.getTempoDeDesconto());
        try{
            this.configuracaoService.atualizar(configuracaoBanco);
            return ResponseEntity.ok("Atualizado com Sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }

    }

}
