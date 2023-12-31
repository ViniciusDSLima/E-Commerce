package com.example.commerce.models;

import com.example.commerce.enums.CategoriaCliente;
import com.example.commerce.request.ClienteAtualizaRequest;
import com.example.commerce.request.ClienteCadastroRequest;
import com.example.commerce.response.ClienteResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime cadastro;
    @Enumerated(EnumType.STRING)
    private CategoriaCliente categoria;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime atualizacao;
    private Boolean ativo;

    public Cliente(ClienteCadastroRequest clienteCadastroRequest) {
        this.nome = clienteCadastroRequest.getNome();
        this.email = clienteCadastroRequest.getEmail();
        this.senha = clienteCadastroRequest.getSenha();
        this.categoria = clienteCadastroRequest.getCategoria();
        this.cadastro = clienteCadastroRequest.getCadastro();
        this.ativo = true;
    }

    public void atualizarInformacoes(ClienteAtualizaRequest clienteAtualizaRequest) {
        if (clienteAtualizaRequest.getEmail()!= null)  this.email = clienteAtualizaRequest.getEmail();

        if(clienteAtualizaRequest.getSenha() != null) this.senha = clienteAtualizaRequest.getSenha();

        this.atualizacao = clienteAtualizaRequest.getAtualizacao();
    }

    public void apagarCliente(Long id) {
        this.ativo = false;
    }
}
