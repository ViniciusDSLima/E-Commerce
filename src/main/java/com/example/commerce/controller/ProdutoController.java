package com.example.commerce.controller;

import com.example.commerce.DTO.ProdutoDTO;
import com.example.commerce.models.Produto;
import com.example.commerce.request.ProdutoAtualizarRequest;
import com.example.commerce.request.ProdutoCadastroRequest;
import com.example.commerce.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService service;

    @PostMapping("/cadastro")
    @Operation(summary = "Cadastra o produto, porem para isso tem de receber um Json no corpo da requisicao.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucesso. Retorna o produtoDTO criado"),
            @ApiResponse(responseCode = "400", description = "Erro de negócio")
    })
    public ResponseEntity cadastrarProduto(@RequestBody ProdutoCadastroRequest produtoCadastroRequest){
        return ResponseEntity.status(CREATED.value()).body(service.cadastrarProduto(produtoCadastroRequest));
    }

    @PutMapping("/atualizar")
    @Operation(summary = "Atualiza o produto, porem para isso tem de receber um Json no corpo da requisicao")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso. Retorna o produtoDTO com as informacoes atualizadas"),
            @ApiResponse(responseCode = "500", description = "Erro do servidor")
    })
    public ResponseEntity atualizarProduto(@RequestBody ProdutoAtualizarRequest produtoAtualizarRequest){
        return ResponseEntity.ok(service.atualizarProduto(produtoAtualizarRequest));
    }

    @GetMapping
    @Operation(summary = "buscar todos os produtos no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso, Retorna todos os produtosDTO criados"),
            @ApiResponse(responseCode = "400", description = "Erro do negocio.")
    })
    public ResponseEntity bucarProdutos(@PageableDefault(size = 10, sort = {"categoria"})Pageable pageable){
        return ResponseEntity.ok(service.buscarProdutosAtivos(pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "bucar um produto pelo seu Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso, Retorna o produtoDto"),
            @ApiResponse(responseCode = "400", description = "Erro do negocio")
    })
    public ResponseEntity buscarProduto(@PathVariable Long id){
        Optional<Produto> produto = service.buscarProduto(id);

        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Apagar um produto pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sucesso, produto apagado da base de dados"),
            @ApiResponse(responseCode = "400", description = "Erro do negocio")
    })
    public ResponseEntity apagarProduto(@PathVariable Long id){
        service.apagarProduto(id);

        return ResponseEntity.noContent().build();
    }
}
