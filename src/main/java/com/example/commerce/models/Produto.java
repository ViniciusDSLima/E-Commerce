package com.example.commerce.models;

import com.example.commerce.DTO.ProdutoDTO;
import com.example.commerce.enums.CategoriaProduto;
import com.example.commerce.request.ProdutoAtualizarRequest;
import com.example.commerce.request.ProdutoCadastroRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    @Enumerated(EnumType.STRING)
    private CategoriaProduto categoria;
    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Double preco;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fabricaco;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime cadastro;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime atualizacao;
    private Boolean ativo;
    public Produto(ProdutoCadastroRequest produtoCadastroRequest) {
        this.nome = produtoCadastroRequest.getNome();
        this.categoria = produtoCadastroRequest.getCategoria();
        this.preco = produtoCadastroRequest.getPreco();
        this.fabricaco = produtoCadastroRequest.getFabricacao();
        this.cadastro = produtoCadastroRequest.getCadastro();
        this.ativo = true;
    }

    public Produto(ProdutoDTO produtoDTO) {
        this.nome = produtoDTO.nome();
        this.categoria = produtoDTO.categoria();
        this.preco = produtoDTO.preco();
        this.fabricaco = produtoDTO.fabricacao();
        this.cadastro = produtoDTO.cadastro();
    }

    public void atualizarInformacoes(ProdutoAtualizarRequest produtoAtualizarRequest) {
        if (produtoAtualizarRequest.getNome() != null) this.nome = produtoAtualizarRequest.getNome();

        if (produtoAtualizarRequest.getPreco()!= null)  this.preco = produtoAtualizarRequest.getPreco();

        if(produtoAtualizarRequest.getCategoriaProduto() != null) this.categoria = produtoAtualizarRequest.getCategoriaProduto();

        this.atualizacao = produtoAtualizarRequest.getAtualizacao();
    }

    public void excluir() {
        this.ativo = false;
    }
}
