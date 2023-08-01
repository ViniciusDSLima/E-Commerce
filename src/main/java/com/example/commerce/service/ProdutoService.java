package com.example.commerce.service;

import com.example.commerce.models.Produto;
import com.example.commerce.repository.ProdutoRepository;
import com.example.commerce.request.ProdutoAtualizarRequest;
import com.example.commerce.request.ProdutoCadastroRequest;
import com.example.commerce.response.ProdutoAtualizarResponse;
import com.example.commerce.response.ProdutoCadastroResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {

    ProdutoRepository produtoRepository;

    public ProdutoCadastroResponse cadastrarProduto(ProdutoCadastroRequest produtoCadastroRequest) {
        Produto produto = produtoRepository.save(new Produto(produtoCadastroRequest));

        return new ProdutoCadastroResponse(produto);
    }

    public ProdutoAtualizarResponse atualizarProduto(ProdutoAtualizarRequest produtoAtualizarRequest) {
        Produto produto = produtoRepository.getReferenceById(produtoAtualizarRequest.getId());
        produto.atualizarInformacoes(produtoAtualizarRequest);

        return new ProdutoAtualizarResponse(produto);
    }
}
