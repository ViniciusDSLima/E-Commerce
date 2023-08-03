package com.example.commerce.DTO;

import com.example.commerce.enums.CategoriaCliente;
import com.example.commerce.models.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
public record ClienteDTO(
         Long id,
         String nome,
         String email,
         String senha,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
         LocalDateTime cadastro,
        @Enumerated(EnumType.STRING)
         CategoriaCliente categoria,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
         LocalDateTime atualizacao
){
    public ClienteDTO(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(),cliente.getEmail(), cliente.getSenha(), cliente.getCadastro(), cliente.getCategoria(), cliente.getAtualizacao());
    }
}

