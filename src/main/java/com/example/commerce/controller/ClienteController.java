package com.example.commerce.controller;

import com.example.commerce.request.ClienteAtualizaRequest;
import com.example.commerce.request.ClienteCadastroRequest;
import com.example.commerce.service.CLienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class ClienteController {

    CLienteService service;

    @PostMapping("/cadastrar")
    @Operation(summary = "cadastra o cliente no banco de dados da empresa, o que da a ele mais funcoes no site.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "cria o cliente na base de dados"),
            @ApiResponse(responseCode = "400", description = "Erro do negocio"),
            @ApiResponse(responseCode = "500", description = "Erro do servidor")
    })
    public ResponseEntity cadastrarCliente(@RequestBody ClienteCadastroRequest clienteCadastroRequest){
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(service.cadastrarCliente(clienteCadastroRequest));
    }

    @PutMapping("atualizar")
    @Operation(summary = "atualiza o cliente no banco de dados da empresa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "atualiza o cliente na base de dados"),
            @ApiResponse(responseCode = "400", description = "Erro do negocio"),
            @ApiResponse(responseCode = "500", description = "Erro do servidor")
    })
    public ResponseEntity atualizarCliente(@RequestBody ClienteAtualizaRequest clienteAtualizaRequest){
        return ResponseEntity.status(HttpStatus.OK.value()).body(service.atualizarCliente(clienteAtualizaRequest));
    }
}
