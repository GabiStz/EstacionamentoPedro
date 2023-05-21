package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import br.com.uniamerica.estacionamento.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/modelo")
public class ModeloController {
    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    private ModeloService modeloService;
    @GetMapping("/{id}")
    public ResponseEntity<?> findByIdPath(@PathVariable("id")final Long id){
        try {
            final Modelo modelo = this.modeloService.findByid(id);
            return ResponseEntity.ok().body(modelo);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Nenhum valor encontrado");
        }

    }
    @GetMapping("/ListaCompleta")
    public List<Modelo> listaCompleta(){
        return modeloService.findAll();
    }
    @PostMapping
    public ResponseEntity<?>cadastar(@RequestBody final Modelo modelo){
        try{
            this.modeloService.cadastrar(modelo);
            return ResponseEntity.ok("Cadastro realizado com sucesso!!");
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body("ERROR");

         }



        }
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar ( @PathVariable ("id") final Long id, @RequestBody final Modelo modelo){
        Modelo modeloBanco = this.modeloService.findByid(id);
        modeloBanco.setMarca(modelo.getMarca());
        modeloBanco.setNome(modelo.getNome());
        try{
            this.modeloService.atualizar(modeloBanco);
            return ResponseEntity.ok("Modelo atualizado com sucesso");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR");

        }
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable ("id") final Long id){
        Modelo modeloBanco = this.modeloService.findByid(id);

    try{
             this.modeloService.delete(modeloBanco);
             return ResponseEntity.ok("Deletado com sucesso");
        }
    catch(Exception e){
            return ResponseEntity.badRequest().body("ERROR");

        }
    }

}