package com.example.arquiteturahexagonal.adapters.converter;

import com.example.arquiteturahexagonal.adapters.dto.CategoriaDto;
import com.example.arquiteturahexagonal.adapters.entities.CategoriaEntity;
import com.example.arquiteturahexagonal.core.domain.Categoria;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CategoriaConverter {

    public Categoria toDomain(CategoriaDto categoriaDto) {
        return new Categoria(categoriaDto.getId(), categoriaDto.getNome(), Collections.emptyList());
    }

    public Categoria toDomain(CategoriaEntity categoriaEntity) {
        return new Categoria(categoriaEntity.getId(), categoriaEntity.getNome(), Collections.emptyList());
    }

    public CategoriaDto toDto(Categoria categoria) {
        return new CategoriaDto(categoria.getId(), categoria.getNome());
    }

    public CategoriaEntity toEntity(Categoria categoria) {
        return new CategoriaEntity(categoria.getId(), categoria.getNome(), Collections.emptyList());
    }
}
