package br.com.uniamerica.estacionamento.controller;

import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.MovimentacoRepository;
import br.com.uniamerica.estacionamento.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/api/movimentacao")
public class MovimentacaoController {
    @Autowired
    private MovimentacoRepository movimentacoRepository;
    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<?>findById(@PathVariable ("id") final Long id){
        try {
            final Movimentacao movimentacao = this.movimentacaoService.findById(id);
            return ResponseEntity.ok("Objeto encontrado ");
        }
    }
}
