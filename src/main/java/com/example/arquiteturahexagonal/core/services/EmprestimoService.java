package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.core.domain.Emprestimo;
import com.example.arquiteturahexagonal.core.ports.entrada.EmprestimoServicePort;
import com.example.arquiteturahexagonal.core.ports.saida.EmprestimoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmprestimoService implements EmprestimoServicePort {

    @Autowired
    private EmprestimoRepositoryPort emprestimoRepositoryPort;

    @Override
    public Emprestimo salvar(Emprestimo emprestimo) {
        return emprestimoRepositoryPort.salvar(emprestimo);
    }

    @Override
    public Emprestimo buscarPorId(Long id) {
        return emprestimoRepositoryPort.buscarPorId(id);
    }

    @Override
    public Emprestimo atualizar(Long id, Emprestimo emprestimo) {
        return emprestimoRepositoryPort.atualizar(id, emprestimo);
    }

    @Override
    public List<Emprestimo> buscarTodos() {
        return emprestimoRepositoryPort.listar();
    }

    @Override
    public void excluir(Long id) {
        emprestimoRepositoryPort.excluir(id);
    }

    @Override
    public List<Emprestimo> buscarPorUsuario(Long usuarioId) {
        return emprestimoRepositoryPort.buscarPorUsuario(usuarioId);
    }

    @Override
    public List<Emprestimo> buscarEmprestimosEmAbertoPorLivro(Long livroId) {
        return emprestimoRepositoryPort.buscarEmprestimosEmAbertoPorLivro(livroId);
    }
}
