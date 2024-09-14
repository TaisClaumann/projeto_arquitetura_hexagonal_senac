package com.example.arquiteturahexagonal.adapters.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LivroDto {

    private Long id;
    private String nome;
    private List<AutorDto> autores;
    private List<CategoriaDto> categorias;
    private String editora;
    private Integer quantidade;
}
