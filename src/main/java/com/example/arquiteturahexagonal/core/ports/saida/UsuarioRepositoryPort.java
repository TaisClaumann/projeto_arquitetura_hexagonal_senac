package com.example.arquiteturahexagonal.core.ports.saida;

import com.example.arquiteturahexagonal.adapters.dto.LoginDto;
import com.example.arquiteturahexagonal.core.domain.Usuario;

import java.util.List;

public interface UsuarioRepositoryPort {

    Usuario salvar(Usuario usuario);
    List<Usuario> buscarTodos();

    Usuario atualizar(Long id, Usuario usuario);
    Usuario buscarPorId(Long id);
    void logar(LoginDto login);

}
