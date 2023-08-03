package com.example.commerce.service;

import com.example.commerce.DTO.ClienteDTO;
import com.example.commerce.DTO.ClientePageDTO;
import com.example.commerce.mapper.ClienteMapper;
import com.example.commerce.models.Cliente;
import com.example.commerce.repository.ClienteRepository;
import com.example.commerce.request.ClienteAtualizaRequest;
import com.example.commerce.request.ClienteCadastroRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CLienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClientePageDTO findAll(@PositiveOrZero int page, @Positive @Max(100) int pageSize) {
        Page<Cliente> clientePage = clienteRepository.findAll(PageRequest.of(page, pageSize));
        List<ClienteDTO> clienteDTOList = clientePage.stream().map(clienteMapper::toDTO).toList();

        return new ClientePageDTO(clienteDTOList,clientePage.getTotalElements(), clientePage.getTotalPages());
    }

    @Transactional
    public Cliente cadastrarCliente(ClienteCadastroRequest clienteCadastroRequest) {
         return clienteRepository.save(new Cliente(clienteCadastroRequest));
    }
    @Transactional
    public ClienteDTO atualizarCliente(ClienteAtualizaRequest clienteAtualizaRequest) {
        Cliente cliente = clienteRepository.getReferenceById(clienteAtualizaRequest.getId());
        cliente.atualizarInformacoes(clienteAtualizaRequest);

        return new ClienteDTO(cliente);
    }
    
}
