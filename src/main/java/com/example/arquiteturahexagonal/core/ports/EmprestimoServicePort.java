package com.example.arquiteturahexagonal.core.ports;

import com.example.arquiteturahexagonal.core.domain.Emprestimo;

import java.util.List;

public interface EmprestimoServicePort {

    Emprestimo salvar(Emprestimo emprestimo);
    Emprestimo buscarPorId(Long id);
    Emprestimo atualizar(Long id, Emprestimo emprestimo);
    List<Emprestimo> buscarTodos();
    void excluir(Long id);
    List<Emprestimo> buscarPorUsuario(Long usuarioId);
    List<Emprestimo> buscarEmprestimosEmAbertoPorLivro(Long livroId);
}
