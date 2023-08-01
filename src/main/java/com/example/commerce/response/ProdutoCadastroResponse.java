package com.example.commerce.response;

import com.example.commerce.enums.CategoriaProduto;
import com.example.commerce.models.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoCadastroResponse{
    private String nome;
    private CategoriaProduto categoria;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Double preco;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fabricaco;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime cadastro;
    public ProdutoCadastroResponse(Produto produto) {
        this(produto.getNome(),produto.getCategoria(),produto.getPreco(),produto.getFabricaco(),produto.getCadastro());
    }
}
