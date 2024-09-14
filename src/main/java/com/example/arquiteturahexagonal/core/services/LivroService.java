package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.core.domain.Livro;
import com.example.arquiteturahexagonal.core.domain.Usuario;
import com.example.arquiteturahexagonal.core.ports.LivroServicePort;

import java.util.Collections;
import java.util.List;

public class LivroService implements LivroServicePort {


    @Override
    public Livro salvar(Livro livro) {
        return livro;
    }

    @Override
    public Livro buscarPorId(Long id) {
        return new Livro();
    }

    @Override
    public Livro atualizar(Long id, Livro livro) {
        return livro;
    }

    @Override
    public List<Livro> buscarTodos() {
        return List.of();
    }

    @Override
    public void excluir(Long id) {

    }

    @Override
    public List<Livro> buscarPorNome(String nome) {
        return Collections.emptyList();
    }
}
