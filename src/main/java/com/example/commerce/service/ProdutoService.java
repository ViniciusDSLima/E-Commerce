package com.example.commerce.service;

import com.example.commerce.models.Produto;
import com.example.commerce.repository.ProdutoRepository;
import com.example.commerce.request.ProdutoAtualizarRequest;
import com.example.commerce.request.ProdutoCadastroRequest;
import com.example.commerce.response.ProdutoAtualizarResponse;
import com.example.commerce.response.ProdutoCadastroResponse;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    ProdutoRepository produtoRepository;
    @Transactional
    public ProdutoCadastroResponse cadastrarProduto(ProdutoCadastroRequest produtoCadastroRequest) {
        Produto produto = produtoRepository.save(new Produto(produtoCadastroRequest));

        return new ProdutoCadastroResponse(produto);
    }
    @Transactional
    public ProdutoAtualizarResponse atualizarProduto(ProdutoAtualizarRequest produtoAtualizarRequest) {
        Produto produto = produtoRepository.getReferenceById(produtoAtualizarRequest.getId());
        produto.atualizarInformacoes(produtoAtualizarRequest);

        return new ProdutoAtualizarResponse(produto);
    }
        
    public Produto buscarProdutos(Pageable pageable) {
        return (Produto) produtoRepository.findAllByAtivoTrue(pageable).map(Produto::new);
    }

    public Optional<Produto> buscarProduto(Long id) {
        return produtoRepository.findById(id);
    }
    @Transactional
    public void apagarProduto(Long id) {
        var produto = produtoRepository.getReferenceById(id);
        produto.excluir();
    }
}
