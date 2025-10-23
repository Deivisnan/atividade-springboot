package com.example.deivisnan_atividade_6;

import com.example.deivisnan_atividade_6.model.Aluno;
import com.example.deivisnan_atividade_6.repository.AlunoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeivisnanAtividade6Application {

    public static void main(String[] args) {
        SpringApplication.run(DeivisnanAtividade6Application.class, args);
    }

    @Bean
    CommandLineRunner init(AlunoRepository repository) {
        return args -> {
            repository.save(new Aluno("João Silva", "joao@email.com", "2025001", 20));
            repository.save(new Aluno("Maria Souza", "maria@email.com", "2025002", 22));
            repository.save(new Aluno("Carlos Lima", "carlos@email.com", "2025003", 19));
        };
    }

}
