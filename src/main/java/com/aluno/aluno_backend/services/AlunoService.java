package com.aluno.aluno_backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aluno.aluno_backend.dtos.AlunoRequest;
import com.aluno.aluno_backend.dtos.AlunoResponse;
import com.aluno.aluno_backend.entities.Aluno;
import com.aluno.aluno_backend.mappers.AlunoMapper;
import com.aluno.aluno_backend.repositories.AlunoRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<AlunoResponse> getAlunos(){
        return repository.findAll()
                         .stream()
                         .map(aluno -> AlunoMapper.toDto(aluno))
                         .toList();
    }

    public Aluno getAlunoById(int id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Aluno não cadastrado!")
        );
    }

    public Aluno save(AlunoRequest dtoRequestAluno){
        return repository.save(AlunoMapper.toEntity(dtoRequestAluno));
    }

    public void deleteById(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Aluno não cadastrado");
        }
    }

    public void update(int id, AlunoRequest dtoRequestAluno){
        Aluno aux = repository.getReferenceById(id);
        aux.setName(dtoRequestAluno.name());
        aux.setPeriod(dtoRequestAluno.period());
        aux.setActive(dtoRequestAluno.active());
        repository.save(aux);
    }
    
}
