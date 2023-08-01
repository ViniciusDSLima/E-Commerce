package com.example.commerce.request;

import com.example.commerce.enums.CategoriaProduto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoAtualizarRequest {
    private Long id;
    @Schema(defaultValue = "Nome")
    private String nome;
    @Schema(defaultValue = "Categoria")
    private CategoriaProduto categoriaProduto;
    @Schema(defaultValue = "0.0")
    private Double preco;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime atualizacao = LocalDateTime.now();
}
