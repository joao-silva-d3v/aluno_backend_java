package com.aluno.aluno_backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import com.aluno.aluno_backend.dtos.AlunoRequest;
import com.aluno.aluno_backend.dtos.AlunoResponse;
import com.aluno.aluno_backend.entities.Aluno;
import com.aluno.aluno_backend.services.AlunoService;

@RestController
public class AlunoController {
      
      @Autowired
      private AlunoService service;

     
      @GetMapping("students")
      public ResponseEntity<List<AlunoResponse>> getAlunos(){
         return ResponseEntity.ok(service.getAlunos());
      }
    
      @GetMapping("students/{id}")
      public ResponseEntity<Aluno> getAlunoById(@PathVariable int id){
         return ResponseEntity.ok(service.getAlunoById(id));
      }
   
      @PostMapping("students")
      public ResponseEntity<Aluno> save(@RequestBody AlunoRequest aluno){
            Aluno novoAluno = service.save(aluno);

            URI location = ServletUriComponentsBuilder
                           .fromCurrentRequest()
                           .path("/{id}")
                           .buildAndExpand(novoAluno.getId())
                           .toUri();

            return ResponseEntity.created(location).body(novoAluno);

      }

      @DeleteMapping("students/{id}")
      public ResponseEntity<Void> deleteById(@PathVariable int id){
          service.deleteById(id);
          return ResponseEntity.noContent().build();
      }

      @PutMapping("students/{id}")
      public ResponseEntity<Void> update(@PathVariable int id, @RequestBody AlunoRequest aluno){
          service.update(id, aluno);
          return ResponseEntity.ok().build();
      }

}
