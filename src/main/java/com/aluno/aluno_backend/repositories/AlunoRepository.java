package com.aluno.aluno_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aluno.aluno_backend.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Integer>{
    
}
