package com.example.arquiteturahexagonal.core.ports.saida;

import com.example.arquiteturahexagonal.core.domain.Autor;

import java.util.List;

public interface AutorRepositoryPort {

    List<Autor> listar();

    Autor salvar(Autor autor);

    Autor buscarPorId(Long id);

    Autor atualizar(Long id, Autor autor);

    void excluir(Long id);
}
