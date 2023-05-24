package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CondutorService {
    @Autowired
    private CondutorRepository condutorRepository;

    public Condutor findById(long id) {
        if (id == 0) {
            throw new RuntimeException(", Id informado não localizado!");

        } else if (condutorRepository.findById(id).isEmpty()) {
            throw new RuntimeException((", não foi possivel localizar marca informado!"));

        } else {
            return condutorRepository.findById(id).orElse(null);
        }

    }

    public List<Condutor> findAll() {
        if (condutorRepository.findAll().isEmpty()) {
            throw new RuntimeException(", banco de dados nao possui condutor cadastrado");
        } else {
            return condutorRepository.findAll();
        }
    }

    public List<Condutor> listarAtivos() {
        if (condutorRepository.findAll().isEmpty()) {
            throw new RuntimeException(", banco de dados não possui condutores ativos!");

        } else {
            return condutorRepository.findAll();
        }
    }

    @Transactional
    public Condutor cadastrar(Condutor condutor) {
        if (!condutorRepository.verificarCPF(condutor.getCpf()).isEmpty()) {
            throw new RuntimeException(", condutor informado já esta cadastrado!");

        } else if (!condutorRepository.verificarTelefone(condutor.getTelefone()).isEmpty()) {
            throw new RuntimeException(", telefone informado já cadastrado para outro condutor!");

        } else {
            return condutorRepository.save(condutor);
        }
    }

    @Transactional
    public Condutor atualizar(Long id, Condutor condutor) {
        final Condutor condutorBanco = this.findById(id);

        if (condutorBanco == null || !condutorBanco.getId().equals(condutor.getId())) {
            throw new RuntimeException("não foi possivel identificar o condutor informado!");
        }
        return condutorRepository.save(condutor);
    }

}
