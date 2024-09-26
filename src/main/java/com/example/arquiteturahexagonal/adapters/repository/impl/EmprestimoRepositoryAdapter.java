package com.example.arquiteturahexagonal.adapters.repository.impl;

import com.example.arquiteturahexagonal.adapters.converter.EmprestimoConverter;
import com.example.arquiteturahexagonal.adapters.entities.EmprestimoEntity;
import com.example.arquiteturahexagonal.adapters.repository.EmprestimoRepository;
import com.example.arquiteturahexagonal.core.domain.Emprestimo;
import com.example.arquiteturahexagonal.core.enums.StatusEnum;
import com.example.arquiteturahexagonal.core.ports.saida.EmprestimoRepositoryPort;
import com.example.arquiteturahexagonal.core.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmprestimoRepositoryAdapter implements EmprestimoRepositoryPort {

    @Autowired
    private EmprestimoConverter emprestimoConverter;

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Override
    public List<Emprestimo> listar() {
        return emprestimoRepository.findAll().stream().map(emprestimoConverter::toDomain).toList();
    }

    @Override
    public Emprestimo salvar(Emprestimo Emprestimo) {
        EmprestimoEntity EmprestimoSalvo = emprestimoRepository.save(emprestimoConverter.toEntity(Emprestimo));
        return emprestimoConverter.toDomain(EmprestimoSalvo);
    }

    @Override
    public Emprestimo buscarPorId(Long id) {
        return emprestimoConverter.toDomain(emprestimoRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Emprestimo não encontrado! ID: " + id)));
    }

    @Override
    public Emprestimo atualizar(Long id, Emprestimo Emprestimo) {
        EmprestimoEntity EmprestimoSalvo = emprestimoRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Emprestimo não encontrado! ID: " + id));
        Emprestimo.setId(EmprestimoSalvo.getId());
        return emprestimoConverter.toDomain(emprestimoRepository.save(emprestimoConverter.toEntity(Emprestimo)));
    }

    @Override
    public void excluir(Long id) {
        if (emprestimoRepository.existsById(id)) emprestimoRepository.deleteById(id);
    }

    @Override
    public List<Emprestimo> buscarPorUsuario(Long usuarioId) {
        return emprestimoRepository.findByUsuarioId(usuarioId).stream()
                .map(emprestimoConverter::toDomain).toList();
    }

    @Override
    public List<Emprestimo> buscarEmprestimosEmAbertoPorLivro(Long livroId) {
        return emprestimoRepository.findByLivroIdAndStatus(livroId, StatusEnum.ABERTO).stream()
                .map(emprestimoConverter::toDomain).toList();
    }
}
