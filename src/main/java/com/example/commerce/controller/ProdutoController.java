package com.example.commerce.controller;

import com.example.commerce.request.ProdutoAtualizarRequest;
import com.example.commerce.request.ProdutoCadastroRequest;
import com.example.commerce.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService service;

    @PostMapping("/cadastro")
    @Operation(summary = "Cadastra o produto, porem para isso tem de receber um Json no corpo da requisicao.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucesso. Retorna o voucher criado"),
            @ApiResponse(responseCode = "400", description = "Erro de negócio")
    })
    public ResponseEntity cadastrarProduto(@RequestBody ProdutoCadastroRequest produtoCadastroRequest){
        return ResponseEntity.status(CREATED.value()).body(service.cadastrarProduto(produtoCadastroRequest));
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualiza o produto, porem para isso tem de receber um Json no corpo da requisicao")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso. Retorna o voucher com as informacoes atualizadas"),
            @ApiResponse(responseCode = "500", description = "Erro do servidor")
    })
    public ResponseEntity atualizarProduto(@RequestBody ProdutoAtualizarRequest produtoAtualizarRequest){
        return ResponseEntity.ok(service.atualizarProduto(produtoAtualizarRequest));
    }
}
