package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.VeiculoRepository;
import br.com.uniamerica.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/{id}")
    public ResponseEntity<?>findByPath(@PathVariable ("id") final Long id){
        try {
            Veiculo veiculo = veiculoService.findById(id);
            return ResponseEntity.ok().body(veiculo);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Nenhum valor Encontrado" + e.getMessage());
        }
    }
    @GetMapping("/ListaCompleta")
    public ResponseEntity<?> listacompleta() {
        try {
            return ResponseEntity.ok().body(veiculoService.findAll());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR" + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Veiculo veiculo){
        try{
            this.veiculoService.cadastrar(veiculo);
            return ResponseEntity.ok().body("Veiculo Cadastrado");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR" + e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar (@PathVariable ("id") final Long id, @RequestBody Veiculo veiculo){
        Veiculo veiculoBanco = this.veiculoService.findById(id);
        veiculoBanco.setAno(veiculoBanco.getAno());
        veiculoBanco.setCor(veiculoBanco.getCor());
        veiculoBanco.setTipo(veiculoBanco.getTipo());
        veiculoBanco.setPlaca(veiculoBanco.getPlaca());
        veiculoBanco.setModelo(veiculoBanco.getModelo());
        try {
            this.veiculoService.atualizar(veiculoBanco);
            return ResponseEntity.ok().body("Atualizado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }
    @DeleteMapping
    public ResponseEntity<?>delete(@PathVariable ("id") final Long id){
        Veiculo veiculoBanco = this.veiculoService.findById(id);
        try {
            this.veiculoService.deletar(veiculoBanco);
            return ResponseEntity.ok().body("Deletado com sucesso");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

}
