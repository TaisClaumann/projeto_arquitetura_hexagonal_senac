package com.example.arquiteturahexagonal.adapters.converter;

import com.example.arquiteturahexagonal.adapters.dto.LivroDto;
import com.example.arquiteturahexagonal.adapters.entities.LivroEntity;
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

    public Livro toDomain(LivroEntity livroEntity) {
        return new Livro(livroEntity.getId(),
                livroEntity.getNome(),
                livroEntity.getAutores().stream().map(a -> autorConverter.toDomain(a)).toList(),
                livroEntity.getCategorias().stream().map(c -> categoriaConverter.toDomain(c)).toList(),
                Collections.emptyList(),
                Collections.emptyList(),
                livroEntity.getEditora(),
                livroEntity.getQuantidade());
    }

    public LivroDto toDto(Livro livro) {
        return new LivroDto(livro.getId(),
                livro.getNome(),
                livro.getAutores().stream().map(a -> autorConverter.toDto(a)).toList(),
                livro.getCategorias().stream().map(c -> categoriaConverter.toDto(c)).toList(),
                livro.getEditora(),
                livro.getQuantidade());
    }

    public LivroEntity toEntity(Livro livro) {
        return new LivroEntity(livro.getId(),
                livro.getNome(),
                livro.getAutores().stream().map(a -> autorConverter.toEntity(a)).toList(),
                livro.getCategorias().stream().map(c -> categoriaConverter.toEntity(c)).toList(),
                Collections.emptyList(),
                Collections.emptyList(),
                livro.getEditora(),
                livro.getQuantidade());
    }
}
