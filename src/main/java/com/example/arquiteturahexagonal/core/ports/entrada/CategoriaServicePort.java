package com.example.arquiteturahexagonal.core.ports.entrada;

import com.example.arquiteturahexagonal.core.domain.Categoria;

import java.util.List;

public interface CategoriaServicePort {

    Categoria salvar(Categoria categoria);
    Categoria buscarPorId(Long id);
    Categoria atualizar(Long id, Categoria categoria);
    List<Categoria> buscarTodos();
    void excluir(Long id);
}
