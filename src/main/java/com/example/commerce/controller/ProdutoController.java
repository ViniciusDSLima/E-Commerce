package com.example.commerce.controller;

import com.example.commerce.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService service;
    
}
