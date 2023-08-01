package com.example.commerce.response;

import com.example.commerce.enums.CategoriaProduto;
import com.example.commerce.models.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoAtualizarResponse {
    private String nome;
    private CategoriaProduto categoria;
    private Double preco;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fabricaco;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime cadastro;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime atualizacao;

    public ProdutoAtualizarResponse(Produto produto) {
        this(produto.getNome(), produto.getCategoria(), produto.getPreco(), produto.getFabricaco(), produto.getCadastro(), produto.getAtualizacao());
    }
}
