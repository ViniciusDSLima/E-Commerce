package com.example.commerce.response;

import com.example.commerce.enums.CategoriaCliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteResponse {
    private Long id;
    private String nome;
    @Email
    private String email;
    private String senha;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime cadastro;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime atualizacao;
    private CategoriaCliente categoria;

    public ClienteResponse(Long id, String nome, String email, String senha, LocalDateTime cadastro, CategoriaCliente categoria, LocalDateTime atualizacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cadastro = cadastro;
        this.atualizacao = atualizacao;
        this.categoria = categoria;
    }
}
