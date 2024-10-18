package com.aluno.aluno_backend.dtos;

public record AlunoResponse(
    Integer id,
    String name,
    Boolean active,
    String period
) {

    public Integer getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
    
    
}
