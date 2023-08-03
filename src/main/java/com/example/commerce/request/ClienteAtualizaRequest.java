package com.example.commerce.request;

import com.example.commerce.enums.CategoriaCliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteAtualizaRequest {
    private Long id;
    @Schema(defaultValue = "Nome")
    private String nome;
    @Schema(defaultValue = "Email")
    private String email;
    @Schema(defaultValue = "Senha")
    private String senha;
    @Schema(defaultValue = "Categoria")
    private CategoriaCliente categoriaCliente;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime atualizacao = LocalDateTime.now();
}
