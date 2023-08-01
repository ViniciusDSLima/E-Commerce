package com.example.commerce.models;

import com.example.commerce.enums.CategoriaProduto;
import com.example.commerce.request.ProdutoCadastroRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate cadastro;

    public Produto(ProdutoCadastroRequest produtoCadastroRequest) {
        this.nome = produtoCadastroRequest.getNome();
        this.categoria = produtoCadastroRequest.getCategoria();
        this.preco = produtoCadastroRequest.getPreco();
        this.fabricaco = produtoCadastroRequest.getFabricacao();
        this.cadastro = produtoCadastroRequest.getCadastro();
    }
}
