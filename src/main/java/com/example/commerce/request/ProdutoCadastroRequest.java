package com.example.commerce.request;

import com.example.commerce.enums.CategoriaProduto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@Data
public class ProdutoCadastroRequest {

    @Schema(defaultValue = "Nome")
    private String nome;

    @Schema(defaultValue = "Categoria")
    private CategoriaProduto categoria;

    @Schema(defaultValue = "0.0")
    private Double preco;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fabricacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate cadastro = LocalDate.now();
}
