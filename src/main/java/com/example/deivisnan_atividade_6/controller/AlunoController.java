package com.example.deivisnan_atividade_6.controller;

import com.example.deivisnan_atividade_6.model.Aluno;
import com.example.deivisnan_atividade_6.repository.AlunoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlunoController {

    private final AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/listar")
    public String listarAlunos(Model model) {
        List<Aluno> alunos = repository.findAll();
        model.addAttribute("alunos", alunos);
        return "index";
    }

    @GetMapping("/novo")
    public String novoAluno(Aluno aluno) {
        return "form";
    }

    @PostMapping("/salvar")
    public String salvarAluno(Aluno aluno) {
        repository.save(aluno);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarAluno(@PathVariable Long id, Model model) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("aluno", aluno);
        return "form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/listar";
    }
}
