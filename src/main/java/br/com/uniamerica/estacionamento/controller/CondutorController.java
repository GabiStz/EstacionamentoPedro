package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;

import br.com.uniamerica.estacionamento.service.CondutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api/condutor")

public class CondutorController {
    @Autowired
    private CondutorRepository condutorRepository;
    @Autowired
    private CondutorService condutorService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id") final Long id) {
        try {
            final Condutor condutor = this.condutorService.findById(id);
            return ResponseEntity.ok().body(condutor);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Nenhum valor Encontrado");
        }

    }

    @GetMapping("/ListaCompleta")
    public List<Condutor> listacompleta() {
        return condutorService.findAll();
    }
    @GetMapping("/condutor-ativa")
    public ResponseEntity <?> ativo (){

        List<Condutor> condutors = this.condutorService.findAll();

        List <Condutor> condutorAtiva = new ArrayList<>();

        for (Condutor valor: condutors) {
            if (valor.isAtivo())
            {
                condutorAtiva.add(valor);
            }
        }
        return ResponseEntity.ok(condutorAtiva);
}

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody final Condutor condutor) {
        try {
            this.condutorService.cadastrar(condutor);
            return ResponseEntity.ok("Cadastrado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") final Long id, @RequestBody final Condutor condutor) {
        Condutor condutorBanco = this.condutorService.findById(id);
        condutorBanco.setNome(condutor.getNome());
        condutorBanco.setCpf(condutor.getCpf());
        condutorBanco.setTelefone(condutor.getTelefone());
        try {
            this.condutorService.atualizar(condutorBanco);
            return ResponseEntity.ok("Atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        Condutor condutorBanco = this.condutorService.findById(id);
        try {
            this.condutorService.delete(condutorBanco);
            return ResponseEntity.ok("Deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERROR");
        }
    }
}