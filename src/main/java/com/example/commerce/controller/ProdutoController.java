package com.example.commerce.controller;

import com.example.commerce.enums.CategoriaCliente;
import com.example.commerce.models.Produto;
import com.example.commerce.request.ProdutoCadastroRequest;
import com.example.commerce.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService service;

    @PostMapping("/cadastro")
    public ResponseEntity cadastrarProduto(@RequestBody ProdutoCadastroRequest produtoCadastroRequest){
        service.cadastrarProduto(new Produto(produtoCadastroRequest));

        return ResponseEntity.ok().body("Produto cadastrado com sucesso! " + produtoCadastroRequest);
    }
}
