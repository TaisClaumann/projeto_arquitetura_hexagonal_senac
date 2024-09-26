package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.core.domain.Categoria;
import com.example.arquiteturahexagonal.core.ports.entrada.CategoriaServicePort;
import com.example.arquiteturahexagonal.core.ports.saida.CategoriaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoriaService implements CategoriaServicePort {

    @Autowired
    private CategoriaRepositoryPort categoriaRepositoryPort;

    @Override
    public Categoria salvar(Categoria categoria) {
        return categoriaRepositoryPort.salvar(categoria);
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return categoriaRepositoryPort.buscarPorId(id);
    }

    @Override
    public Categoria atualizar(Long id, Categoria categoria) {
        return categoriaRepositoryPort.atualizar(id, categoria);
    }

    @Override
    public List<Categoria> buscarTodos() {
        return categoriaRepositoryPort.listar();
    }

    @Override
    public void excluir(Long id) {
        categoriaRepositoryPort.excluir(id);
    }
}
