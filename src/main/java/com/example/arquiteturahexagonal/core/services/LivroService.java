package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.core.domain.Livro;
import com.example.arquiteturahexagonal.core.ports.entrada.LivroServicePort;
import com.example.arquiteturahexagonal.core.ports.saida.LivroRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LivroService implements LivroServicePort {

    @Autowired
    private LivroRepositoryPort livroRepositoryPort;

    @Override
    public Livro salvar(Livro livro) {
        return livroRepositoryPort.salvar(livro);
    }

    @Override
    public Livro buscarPorId(Long id) {
        return livroRepositoryPort.buscarPorId(id);
    }

    @Override
    public Livro atualizar(Long id, Livro livro) {
        return livroRepositoryPort.atualizar(id, livro);
    }

    @Override
    public List<Livro> buscarTodos() {
        return livroRepositoryPort.listar();
    }

    @Override
    public void excluir(Long id) {
        livroRepositoryPort.excluir(id);
    }

    @Override
    public List<Livro> buscarPorNome(String nome) {
        return livroRepositoryPort.buscarPorNome(nome);
    }
}
