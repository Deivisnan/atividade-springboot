package com.example.deivisnan_atividade_6;

import com.example.deivisnan_atividade_6.model.Produto;
import com.example.deivisnan_atividade_6.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeivisnanAtividade6Application {

    public static void main(String[] args) {
        SpringApplication.run(DeivisnanAtividade6Application.class, args);
    }

    // Adiciona produtos de teste no banco H2 ao iniciar o projeto
    @Bean
    CommandLineRunner init(ProdutoRepository repository) {
        return args -> {
            repository.save(new Produto("Notebook", 3500.0));
            repository.save(new Produto("Mouse", 80.0));
            repository.save(new Produto("Teclado", 120.0));
        };
    }
}
