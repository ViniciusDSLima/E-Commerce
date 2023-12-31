package com.example.commerce.request;

import com.example.commerce.enums.CategoriaProduto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class ProdutoCadastroRequest {

    @Schema(defaultValue = "Nome")
    @NotBlank
    private String nome;

    @Schema(defaultValue = "Categoria")
    @NonNull
    private CategoriaProduto categoria;

    @Schema(defaultValue = "0.0")
    @NonNull
    private Double preco;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NonNull
    private LocalDate fabricacao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @NonNull
    private LocalDateTime cadastro = LocalDateTime.now();
}
