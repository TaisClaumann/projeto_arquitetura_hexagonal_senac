package com.example.arquiteturahexagonal.core.ports.saida;

import com.example.arquiteturahexagonal.core.domain.Livro;

import java.util.List;

public interface LivroRepositoryPort {

    List<Livro> listar();

    Livro salvar(Livro livro);

    Livro buscarPorId(Long id);

    Livro atualizar(Long id, Livro livro);

    void excluir(Long id);

    List<Livro> buscarPorNome(String nome);
}
