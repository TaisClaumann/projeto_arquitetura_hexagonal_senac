package com.example.arquiteturahexagonal.adapters.converter;

import com.example.arquiteturahexagonal.adapters.dto.LivroDto;
import com.example.arquiteturahexagonal.core.domain.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class LivroConverter {

    @Autowired
    private AutorConverter autorConverter;

    @Autowired
    private CategoriaConverter categoriaConverter;

    public Livro toDomain(LivroDto livroDto) {
        return new Livro(livroDto.getId(),
                livroDto.getNome(),
                livroDto.getAutores().stream().map(a -> autorConverter.toDomain(a)).toList(),
                livroDto.getCategorias().stream().map(c -> categoriaConverter.toDomain(c)).toList(),
                Collections.emptyList(),
                Collections.emptyList(),
                livroDto.getEditora(),
                livroDto.getQuantidade());
    }

    public LivroDto toDto(Livro livro) {
        return new LivroDto(livro.getId(),
                livro.getNome(),
                livro.getAutores().stream().map(a -> autorConverter.toDto(a)).toList(),
                livro.getCategorias().stream().map(c -> categoriaConverter.toDto(c)).toList(),
                livro.getEditora(),
                livro.getQuantidade());
    }
}
