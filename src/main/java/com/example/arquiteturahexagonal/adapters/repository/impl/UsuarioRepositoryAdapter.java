package com.example.arquiteturahexagonal.adapters.repository.impl;

import com.example.arquiteturahexagonal.adapters.converter.UsuarioConverter;
import com.example.arquiteturahexagonal.adapters.dto.LoginDto;
import com.example.arquiteturahexagonal.adapters.entities.UsuarioEntity;
import com.example.arquiteturahexagonal.adapters.repository.UsuarioRepository;
import com.example.arquiteturahexagonal.core.domain.Usuario;
import com.example.arquiteturahexagonal.core.ports.saida.UsuarioRepositoryPort;
import com.example.arquiteturahexagonal.core.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    @Autowired
    private UsuarioConverter usuarioConverter;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario salvar(Usuario usuario) {
        usuario.setAtivo(true);
        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuarioConverter.toEntity(usuario));
        return usuarioConverter.toDomain(usuarioSalvo);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll().stream()
                .map(usuarioEntity -> usuarioConverter.toDomain(usuarioEntity))
                .toList();
    }

    @Override
    public Usuario atualizar(Long id, Usuario usuario) {
        buscarPorId(id);
        usuario.setId(id);
        UsuarioEntity usuarioEntity = usuarioConverter.toEntity(usuario);
        return usuarioConverter.toDomain(usuarioRepository.save(usuarioEntity));
    }

    @Override
    public Usuario buscarPorId(Long id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Usuário não encontrado! ID: " + id));
        return usuarioConverter.toDomain(usuarioEntity);
    }

    @Override
    public void logar(LoginDto login) {
        usuarioRepository.findByEmailAndSenha(login.getEmail(), login.getSenha())
                .orElseThrow(() -> new RegistroNaoEncontradoException("Usuário ou senha incorretos"));
    }
}
