package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.adapters.dto.LoginDto;
import com.example.arquiteturahexagonal.core.domain.Usuario;
import com.example.arquiteturahexagonal.core.ports.UsuarioServicePort;

import java.util.List;

public class UsuarioService implements UsuarioServicePort {

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuario;
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return new Usuario();
    }

    @Override
    public void logar(LoginDto loginDto) {
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        return usuario;
    }

    @Override
    public List<Usuario> buscarTodos() {
        return List.of();
    }
}
