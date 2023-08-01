package com.example.commerce.models;

import com.example.commerce.enums.Descricao;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;

@Entity(name = "produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Descricao descricao;
    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Double preco;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"dd/MM/yyyy"})
    private LocalDateTime dataFabricacao;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"dd/MM/yyyy"})
    private LocalDateTime dataCadastro;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = {"dd/MM/yyyy"})
    private LocalDateTime dataVenda;
}
