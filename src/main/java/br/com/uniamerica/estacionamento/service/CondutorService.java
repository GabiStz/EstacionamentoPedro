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
                     if(id == 0){
                         throw new RuntimeException(", Id informado não localizado!");

                     }   else if(condutorRepository.findById(id).isEmpty()){
                         throw new RuntimeException((", não foi possivel localizar marca informado!"));

                     }else {
                         return condutorRepository.findById(id).orElse(null);
                     }

        }

            public List<Condutor>findAll(){
                if (condutorRepository.findAll().isEmpty()){
                    throw new RuntimeException(", banco de dados nao possui condutor cadastrado");
                }else{
                    return condutorRepository.findAll();
                }
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
