package com.example.deivisnan_atividade_6.controller;

import com.example.deivisnan_atividade_6.model.Produto;
import com.example.deivisnan_atividade_6.repository.ProdutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class ProdutoController {

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String listarProdutos(Model model) {
        List<Produto> produtos = repository.findAll();
        model.addAttribute("produtos", produtos);
        return "index";
    }


    // Mostrar o formulário para cadastrar produto
    @GetMapping("/novo")
    public String mostrarFormulario(Produto produto) {
        return "form";
    }

    // Receber os dados do formulário e salvar no banco
    @PostMapping("/salvar")
    public String salvarProduto(Produto produto) {
        repository.save(produto);
        return "redirect:/"; // volta para a lista de produtos
    }


    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }



}


