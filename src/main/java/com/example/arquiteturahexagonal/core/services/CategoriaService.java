package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.core.domain.Categoria;
import com.example.arquiteturahexagonal.core.ports.CategoriaServicePort;

import java.util.List;

public class CategoriaService implements CategoriaServicePort {

    @Override
    public Categoria salvar(Categoria categoria) {
        return categoria;
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return new Categoria();
    }

    @Override
    public Categoria atualizar(Long id, Categoria categoria) {
        return categoria;
    }

    @Override
    public List<Categoria> buscarTodos() {
        return List.of();
    }

    @Override
    public void excluir(Long id) {
    }
}
