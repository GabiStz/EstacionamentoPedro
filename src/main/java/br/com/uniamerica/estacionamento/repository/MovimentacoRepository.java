package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Movimentacao;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacoRepository extends JpaRepository<Movimentacao, Long> { }
