package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.MovimentacoRepository;
import br.com.uniamerica.estacionamento.service.CondutorService;
import br.com.uniamerica.estacionamento.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api/movimentacao")
public class MovimentacaoController {
    @Autowired
    private MovimentacoRepository movimentacoRepository;
    @Autowired
    private MovimentacaoService movimentacaoService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        try {
            final Movimentacao movimentacao = this.movimentacaoService.findById(id);
            return ResponseEntity.ok("Objeto encontrado ");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERROR!");
        }
    }

    @GetMapping("/ListaCompleta")
    public List<Movimentacao> listaC() {
        return this.movimentacaoService.findAll();
    }
    @GetMapping("/movimentacao-ativa")
    public ResponseEntity <?> ativo (){

        List<Movimentacao> movimentacao = this.movimentacaoService.findAll();

        List <Movimentacao> movimentacaoAtivo = new ArrayList<>();

        for (Movimentacao valor: movimentacao) {
            if (valor.isAtivo())
            {
                movimentacaoAtivo.add(valor);
            }
        }
        return ResponseEntity.ok(movimentacaoAtivo);
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Movimentacao movimentacao) {
        try {
            this.movimentacaoService.cadastrar(movimentacao);
            return ResponseEntity.ok("Cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") final Long id, @RequestBody Movimentacao movimentacao) {
        Movimentacao movimentacaoBanco = this.movimentacaoService.findById(id);
        movimentacaoBanco.setEntrada(movimentacaoBanco.getEntrada());
        movimentacaoBanco.setSaida(movimentacaoBanco.getSaida());
        movimentacaoBanco.setTempo(movimentacaoBanco.getTempo());
        movimentacaoBanco.setTempoMulta(movimentacaoBanco.getTempoMulta());
        movimentacaoBanco.setTempoDesconto(movimentacaoBanco.getTempoDesconto());
        movimentacaoBanco.setValorHora(movimentacaoBanco.getValorHora());
        movimentacaoBanco.setValorHoraMulta(movimentacaoBanco.getValorHoraMulta());
        movimentacaoBanco.setValorMulta(movimentacaoBanco.getValorMulta());
        movimentacaoBanco.setCadastro(movimentacaoBanco.getCadastro());
        try {
            this.movimentacaoService.atualizar(movimentacao);
            return ResponseEntity.ok("Atualizado com Sucesso");

        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }

    }
    @DeleteMapping
    public ResponseEntity<?>deletar(@PathVariable("id") final Long id){
        Movimentacao movimentacaoBanco= this.movimentacaoService.findById(id);
        try {
            this.movimentacaoService.delete(movimentacaoBanco);
            return ResponseEntity.ok("Deletado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }

    }
}