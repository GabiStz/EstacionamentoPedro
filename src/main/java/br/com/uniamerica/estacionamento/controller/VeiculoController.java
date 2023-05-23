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
            final Veiculo veiculo = this.veiculoService.findById(id);
            return ResponseEntity.ok().body("Obejto encontrado");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }
    @GetMapping("/ListaCompleta")
    public List<Veiculo> listacompleta() {
        return veiculoService.findAll();
    }
    @GetMapping("/veiculo-ativa")
    public ResponseEntity <?> ativo (){

        List<Veiculo> veiculo = this.veiculoService.findAll();

        List <Veiculo> veiculoAtivo = new ArrayList<>();

        for (Veiculo valor: veiculo) {
            if (valor.isAtivo())
            {
                veiculoAtivo.add(valor);
            }
        }
        return ResponseEntity.ok(veiculoAtivo);
    }
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Veiculo veiculo){
        try{
            this.veiculoService.cadastrar(veiculo);
            return ResponseEntity.ok().body("Veiculo Cadastrado");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
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
