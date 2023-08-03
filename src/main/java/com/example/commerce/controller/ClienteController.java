package com.example.commerce.controller;

import com.example.commerce.DTO.ClienteDTO;
import com.example.commerce.DTO.ClientePageDTO;
import com.example.commerce.request.ClienteAtualizaRequest;
import com.example.commerce.request.ClienteCadastroRequest;
import com.example.commerce.response.ClienteResponse;
import com.example.commerce.service.CLienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import org.aspectj.lang.annotation.Pointcut;
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

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "buscar todos os clientes cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca todos os clientes"),
            @ApiResponse(responseCode = "500", description = "Erro do servidor")
    })
    public ClientePageDTO findAll(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                  @RequestParam(defaultValue = "10") @Positive @Max(100) int pageSize){
        return service.findAll(page, pageSize);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "busca um cliente especifico pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca o cliente"),
            @ApiResponse(responseCode = "500", description = "Erro do servidor")
    })
    public ClienteDTO findById(@PathVariable @Positive Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "inativa o cliente do servidor da loja")
    public ResponseEntity apagarCliente(@PathVariable Long id){
        service.apagarCliente(id);

        return ResponseEntity.noContent().build();
    }
}

