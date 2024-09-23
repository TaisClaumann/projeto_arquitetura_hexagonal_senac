package com.example.arquiteturahexagonal.adapters.converter;

import com.example.arquiteturahexagonal.adapters.dto.UsuarioDto;
import com.example.arquiteturahexagonal.adapters.entities.UsuarioEntity;
import com.example.arquiteturahexagonal.core.domain.Usuario;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UsuarioConverter {

    public Usuario toDomain(UsuarioDto usuarioDto) {
        return new Usuario(usuarioDto.getId(),
                usuarioDto.getNome(),
                null,
                null,
                usuarioDto.getCpf(),
                usuarioDto.getDataNascimento(),
                usuarioDto.isAtivo());
    }

    public Usuario toDomain(UsuarioEntity usuarioEntity) {
        return new Usuario(usuarioEntity.getId(),
                usuarioEntity.getNome(),
                null,
                null,
                usuarioEntity.getCpf(),
                usuarioEntity.getDataNascimento(),
                usuarioEntity.isAtivo());
    }

    public UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getDataNascimento(),
                usuario.isAtivo());
    }

    public UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getCpf(),
                usuario.getDataNascimento(),
                usuario.isAtivo(),
                Collections.emptyList(),
                Collections.emptyList());
    }
}
