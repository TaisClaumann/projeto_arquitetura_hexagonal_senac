package com.example.arquiteturahexagonal.core.ports.saida;

import com.example.arquiteturahexagonal.core.domain.Categoria;

import java.util.List;

public interface CategoriaRepositoryPort {

    List<Categoria> listar();

    Categoria salvar(Categoria categoria);

    Categoria buscarPorId(Long id);

    Categoria atualizar(Long id, Categoria categoria);

    void excluir(Long id);
}
