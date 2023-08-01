package com.example.commerce.models;

import com.example.commerce.enums.CategoriaCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;
    @Enumerated(EnumType.STRING)
    private CategoriaCliente categoriaCliente;
}
