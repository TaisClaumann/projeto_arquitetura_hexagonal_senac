package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.core.domain.Emprestimo;
import com.example.arquiteturahexagonal.core.ports.entrada.EmprestimoServicePort;

import java.util.List;

public class EmprestimoService implements EmprestimoServicePort {


    @Override
    public Emprestimo salvar(Emprestimo emprestimo) {
        return emprestimo;
    }

    @Override
    public Emprestimo buscarPorId(Long id) {
        return new Emprestimo();
    }

    @Override
    public Emprestimo atualizar(Long id, Emprestimo emprestimo) {
        return emprestimo;
    }

    @Override
    public List<Emprestimo> buscarTodos() {
        return List.of();
    }

    @Override
    public void excluir(Long id) {

    }

    @Override
    public List<Emprestimo> buscarPorUsuario(Long usuarioId) {
        return List.of();
    }

    @Override
    public List<Emprestimo> buscarEmprestimosEmAbertoPorLivro(Long livroId) {
        return List.of();
    }
}
