package com.example.deivisnan_atividade_6.controller;

import com.example.deivisnan_atividade_6.model.Aluno;
import com.example.deivisnan_atividade_6.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoApiController {

    @Autowired
    private AlunoRepository alunoRepository;

    // GET - listar todos os alunos
    @GetMapping
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    // POST - criar novo aluno
    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    // PUT - atualizar um aluno existente
    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno alunoExistente = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        alunoExistente.setNome(aluno.getNome());
        alunoExistente.setEmail(aluno.getEmail());
        alunoExistente.setMatricula(aluno.getMatricula());
        alunoExistente.setIdade(aluno.getIdade());

        return alunoRepository.save(alunoExistente);
    }

    // DELETE - deletar aluno por ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        alunoRepository.deleteById(id);
    }
}



