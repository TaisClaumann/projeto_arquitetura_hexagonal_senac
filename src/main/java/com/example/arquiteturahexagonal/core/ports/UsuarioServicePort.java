package com.example.arquiteturahexagonal.core.ports;

import com.example.arquiteturahexagonal.adapters.dto.LoginDto;
import com.example.arquiteturahexagonal.core.domain.Usuario;

import java.util.List;

public interface UsuarioServicePort {

    Usuario salvar(Usuario usuario);
    Usuario buscarPorId(Long id);
    void logar(LoginDto loginDto);
    Usuario atualizar(Long id, Usuario usuario);
    List<Usuario> buscarTodos();
}
