package com.example.arquiteturahexagonal.core.ports.saida;

import com.example.arquiteturahexagonal.core.domain.Emprestimo;

import java.util.List;

public interface EmprestimoRepositoryPort {

    List<Emprestimo> listar();

    Emprestimo salvar(Emprestimo emprestimo);

    Emprestimo buscarPorId(Long id);

    Emprestimo atualizar(Long id, Emprestimo emprestimo);

    void excluir(Long id);

    List<Emprestimo> buscarPorUsuario(Long usuarioId);

    List<Emprestimo> buscarEmprestimosEmAbertoPorLivro(Long livroId);
}
