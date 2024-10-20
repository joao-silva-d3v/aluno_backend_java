package com.aluno.aluno_backend.dtos;

public record AlunoRequest(
     String name,
     Boolean active,
     String period
) {
    
}
