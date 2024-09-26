package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.core.domain.Autor;
import com.example.arquiteturahexagonal.core.ports.entrada.AutorServicePort;
import com.example.arquiteturahexagonal.core.ports.saida.AutorRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AutorService implements AutorServicePort {

    @Autowired
    private AutorRepositoryPort autorRepositoryPort;

    @Override
    public Autor salvar(Autor autor) {
        return autorRepositoryPort.salvar(autor);
    }

    @Override
    public Autor buscarPorId(Long id) {
        return autorRepositoryPort.buscarPorId(id);
    }

    @Override
    public Autor atualizar(Long id, Autor autor) {
        return autorRepositoryPort.atualizar(id, autor);
    }

    @Override
    public List<Autor> buscarTodos() {
        return autorRepositoryPort.listar();
    }

    @Override
    public void excluir(Long id) {
        autorRepositoryPort.excluir(id);
    }
}
