package com.example.commerce.service;

import com.example.commerce.models.Produto;
import com.example.commerce.request.ProdutoAtualizarRequest;
import com.example.commerce.request.ProdutoCadastroRequest;

public interface ValidacaoAtualizacaoProduto {

    boolean validar(Produto produto, ProdutoAtualizarRequest produtoAtualizarRequest) throws RuntimeException;
}
