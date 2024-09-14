package com.example.arquiteturahexagonal.core.ports;

import com.example.arquiteturahexagonal.core.domain.Livro;
import com.example.arquiteturahexagonal.core.domain.Usuario;

import java.util.List;

public interface LivroServicePort {

    Livro salvar(Livro livro);
    Livro buscarPorId(Long id);
    Livro atualizar(Long id, Livro livro);
    List<Livro> buscarTodos();
    void excluir(Long id);
    Usuario buscarPorNome(String nome);
}
