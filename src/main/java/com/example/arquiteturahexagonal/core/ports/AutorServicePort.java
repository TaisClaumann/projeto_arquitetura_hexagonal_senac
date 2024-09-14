package com.example.arquiteturahexagonal.core.ports;

import com.example.arquiteturahexagonal.core.domain.Autor;

import java.util.List;

public interface AutorServicePort {

    Autor salvar(Autor autor);
    Autor buscarPorId(Long id);
    Autor atualizar(Long id, Autor autor);
    List<Autor> buscarTodos();
    void excluir(Long id);
}
