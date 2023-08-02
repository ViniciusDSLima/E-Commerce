package com.example.commerce.repository;

import com.example.commerce.DTO.ProdutoDTO;
import com.example.commerce.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Page<ProdutoDTO> findAllByAtivoTrue(Pageable pageable);

}
