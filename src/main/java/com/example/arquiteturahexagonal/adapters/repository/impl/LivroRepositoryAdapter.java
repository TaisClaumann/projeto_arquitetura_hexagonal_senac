package com.example.arquiteturahexagonal.adapters.repository.impl;

import com.example.arquiteturahexagonal.adapters.converter.LivroConverter;
import com.example.arquiteturahexagonal.adapters.entities.LivroEntity;
import com.example.arquiteturahexagonal.adapters.repository.LivroRepository;
import com.example.arquiteturahexagonal.core.domain.Livro;
import com.example.arquiteturahexagonal.core.ports.saida.LivroRepositoryPort;
import com.example.arquiteturahexagonal.core.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivroRepositoryAdapter implements LivroRepositoryPort {

    @Autowired
    private LivroConverter livroConverter;

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public List<Livro> listar() {
        return livroRepository.findAll().stream().map(livroConverter::toDomain).toList();
    }

    @Override
    public Livro salvar(Livro Livro) {
        LivroEntity LivroSalvo = livroRepository.save(livroConverter.toEntity(Livro));
        return livroConverter.toDomain(LivroSalvo);
    }

    @Override
    public Livro buscarPorId(Long id) {
        return livroConverter.toDomain(livroRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Livro não encontrado! ID: " + id)));
    }

    @Override
    public Livro atualizar(Long id, Livro Livro) {
        LivroEntity LivroSalvo = livroRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Livro não encontrado! ID: " + id));
        Livro.setId(LivroSalvo.getId());
        return livroConverter.toDomain(livroRepository.save(livroConverter.toEntity(Livro)));
    }

    @Override
    public void excluir(Long id) {
        if (livroRepository.existsById(id)) livroRepository.deleteById(id);
    }

    @Override
    public List<Livro> buscarPorNome(String nome) {
        return livroRepository.findAllByNomeContainingIgnoreCase(nome).stream()
                .map(livroConverter::toDomain).toList();
    }
}
