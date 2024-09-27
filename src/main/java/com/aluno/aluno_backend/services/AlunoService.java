package com.aluno.aluno_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluno.aluno_backend.entities.Aluno;
import com.aluno.aluno_backend.repositories.AlunoRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> getAlunos(){
        return repository.findAll();
    }

    public Aluno getAlunoById(int id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Aluno não cadastrado!")
        );
    }

    public Aluno save(Aluno aluno){
        return repository.save(aluno);
    }

    public void deleteById(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Aluno não cadastrado");
        }
    }

    public void update(int id, Aluno aluno){
        Aluno aux = repository.getReferenceById(id);
        aux.setName(aluno.getName());
        aux.setPeriod(aluno.getPeriod());
        aux.setActive(aluno.getActive());
        repository.save(aux);
    }
    
}
