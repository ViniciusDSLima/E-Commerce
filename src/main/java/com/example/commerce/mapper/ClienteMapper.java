package com.example.commerce.mapper;

import com.example.commerce.DTO.ClienteDTO;
import com.example.commerce.models.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.id());
        cliente.setNome(clienteDTO.nome());
        cliente.setSenha(clienteDTO.senha());
        cliente.setEmail(clienteDTO.email());
        cliente.setCategoria(clienteDTO.categoria());
        cliente.setCadastro(clienteDTO.cadastro());
        cliente.setAtualizacao(clienteDTO.atualizacao());
        return cliente;
    }

    public ClienteDTO toDTO(Cliente cliente){
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getSenha(), cliente.getEmail(), cliente.getCadastro(), cliente.getCategoria(), cliente.getAtualizacao());
    }
}
