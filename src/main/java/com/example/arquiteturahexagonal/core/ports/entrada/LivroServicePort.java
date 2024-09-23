package com.example.arquiteturahexagonal.core.ports.entrada;

import com.example.arquiteturahexagonal.core.domain.Livro;

import java.util.List;

public interface LivroServicePort {

    Livro salvar(Livro livro);
    Livro buscarPorId(Long id);
    Livro atualizar(Long id, Livro livro);
    List<Livro> buscarTodos();
    void excluir(Long id);
    List<Livro> buscarPorNome(String nome);
}
