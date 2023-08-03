package com.example.commerce.request;

import com.example.commerce.enums.CategoriaCliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class ClienteCadastroRequest {

    @Schema(defaultValue = "Nome")
    @NotBlank
    private String nome;
    @Schema(defaultValue = "Senha")
    @NotBlank
    private String senha;
    @Schema(defaultValue = "Email")
    @NotBlank
    @Email
    private String email;
    @Schema(defaultValue = "DataCadastro")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime cadastro = LocalDateTime.now();
    @Schema(defaultValue = "Categoria")
    @NonNull
    private CategoriaCliente categoria;
}
