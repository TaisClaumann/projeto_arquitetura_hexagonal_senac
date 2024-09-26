package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.adapters.dto.LoginDto;
import com.example.arquiteturahexagonal.core.domain.Usuario;
import com.example.arquiteturahexagonal.core.ports.entrada.UsuarioServicePort;
import com.example.arquiteturahexagonal.core.ports.saida.UsuarioRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioService implements UsuarioServicePort {

    @Autowired
    private UsuarioRepositoryPort usuarioRepositoryPort;

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioRepositoryPort.salvar(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepositoryPort.buscarPorId(id);
    }

    @Override
    public void logar(LoginDto loginDto) {
        usuarioRepositoryPort.logar(loginDto);
    }

    @Override
    public Usuario atualizar(Long id, Usuario usuario) {
        return usuarioRepositoryPort.atualizar(id, usuario);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepositoryPort.buscarTodos();
    }
}
