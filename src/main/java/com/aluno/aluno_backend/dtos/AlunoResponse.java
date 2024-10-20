package com.aluno.aluno_backend.dtos;

public record AlunoResponse(
    Integer id,
    String name,
    Boolean active,
    String period
) {
    
}
