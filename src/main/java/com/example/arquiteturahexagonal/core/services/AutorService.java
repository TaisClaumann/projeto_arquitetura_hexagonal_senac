package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.core.domain.Autor;
import com.example.arquiteturahexagonal.core.ports.AutorServicePort;

import java.util.List;

public class AutorService implements AutorServicePort {

    @Override
    public Autor salvar(Autor autor) {
        return autor;
    }

    @Override
    public Autor buscarPorId(Long id) {
        return new Autor();
    }

    @Override
    public Autor atualizar(Long id, Autor autor) {
        return autor;
    }

    @Override
    public List<Autor> buscarTodos() {
        return List.of();
    }

    @Override
    public void excluir(Long id) {

    }
}
