package com.example.commerce.service;

import com.example.commerce.models.Cliente;
import com.example.commerce.repository.ClienteRepository;
import com.example.commerce.request.ClienteAtualizaRequest;
import com.example.commerce.request.ClienteCadastroRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CLienteService {

    ClienteRepository clienteRepository;
    @Transactional
    public Cliente cadastrarCliente(ClienteCadastroRequest clienteCadastroRequest) {
         return clienteRepository.save(new Cliente(clienteCadastroRequest));
    }
    @Transactional
    public Cliente atualizarCliente(ClienteAtualizaRequest clienteAtualizaRequest) {
        Cliente cliente = clienteRepository.getReferenceById(clienteAtualizaRequest.getId());
        cliente.atualizarInformacoes(clienteAtualizaRequest);

        return cliente;
    }
}
