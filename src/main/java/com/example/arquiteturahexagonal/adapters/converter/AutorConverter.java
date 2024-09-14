package com.example.arquiteturahexagonal.adapters.converter;

import com.example.arquiteturahexagonal.adapters.dto.AutorDto;
import com.example.arquiteturahexagonal.core.domain.Autor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class AutorConverter {

    public Autor toDomain(AutorDto autorDto) {
        return new Autor(autorDto.getId(), autorDto.getNome(), Collections.emptyList());
    }

    public AutorDto toDto(Autor autor) {
        return new AutorDto(autor.getId(), autor.getNome());
    }
}
