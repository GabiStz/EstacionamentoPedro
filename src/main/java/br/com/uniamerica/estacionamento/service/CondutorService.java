package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
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
                 public Condutor findById(long id){
                    Optional<Condutor> condutor= this.condutorRepository.findById(id);
                 return condutor.orElseThrow(()-> new RuntimeException(
                    "Condutor Encontrado:" + Condutor.class.getName()
                    )
                );
        }

            public List<Condutor>findAll(){
            return this.condutorRepository.findAll();
       }
       @Transactional
            public void cadastrar (Condutor condutor){
                this.condutorRepository.save(condutor);
       }
       @Transactional
             public void delete (Condutor condutor){
                 this.condutorRepository.delete(condutor);
        }
       @Transactional
            public void atualizar (Condutor condutor){
                this.condutorRepository.save(condutor);
        }

}
