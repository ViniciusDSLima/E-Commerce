package com.example.commerce.DTO;

import com.example.commerce.enums.CategoriaProduto;
import com.example.commerce.models.Produto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ProdutoDTO(String nome, CategoriaProduto categoria, Double preco, LocalDate fabricacao, LocalDateTime cadastro, LocalDateTime atualizacao, Boolean ativo ) {

    public ProdutoDTO(Produto produto) {
        this(produto.getNome(), produto.getCategoria(), produto.getPreco(), produto.getFabricaco(), produto.getCadastro(), produto.getAtualizacao(), produto.getAtivo());
    }
}
