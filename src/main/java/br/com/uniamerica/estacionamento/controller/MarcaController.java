package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Marca;
import br.com.uniamerica.estacionamento.repository.MarcaRepository;
import br.com.uniamerica.estacionamento.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/marca")
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private MarcaService marcaService;
    @GetMapping("/{id}")
    public ResponseEntity<?>FindByIdPath(@PathVariable ("id") final Long id){
        try{
            Marca marca = marcaService.findById(id);
            return ResponseEntity.ok().body("Marca encontrada com Sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }
    @GetMapping("/ListaCompleta")
    public ResponseEntity<?> ListaComplesta(){
        try{
            return ResponseEntity.ok().body(marcaRepository.findAll());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error" + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrar (@RequestBody final Marca marca){
        try {
            this.marcaService.cadastra(marca);
            return ResponseEntity.ok("Cadastrado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR" + e.getMessage());
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?>atualizar(@PathVariable("id")final Long id, @RequestBody Marca marca){
        Marca marcaBanco = this.marcaService.findById(id);
        marcaBanco.setNome(marcaBanco.getNome());
        marcaBanco.setAtivo(marcaBanco.isAtivo());
        marcaBanco.setCadastro(marcaBanco.getCadastro());
        marcaBanco.setEdicao(marcaBanco.getEdicao());
        try {
            this.marcaService.atualizar(marcaBanco);
            return ResponseEntity.ok("Atualizado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");
        }
    }
    @DeleteMapping
    public ResponseEntity<?>delete(@PathVariable("id")final Long id){
        Marca marcaBanco = this.marcaService.findById(id);
        try {
            this.marcaService.delete(marcaBanco);
            return ResponseEntity.ok("Deletado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(("Error ao deletar"));
        }

    }


}
