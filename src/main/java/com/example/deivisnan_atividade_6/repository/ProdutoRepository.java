package com.example.deivisnan_atividade_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.deivisnan_atividade_6.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
