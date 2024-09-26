package com.example.arquiteturahexagonal.adapters.repository.impl;

import com.example.arquiteturahexagonal.adapters.converter.AutorConverter;
import com.example.arquiteturahexagonal.adapters.entities.AutorEntity;
import com.example.arquiteturahexagonal.adapters.repository.AutorRepository;
import com.example.arquiteturahexagonal.core.domain.Autor;
import com.example.arquiteturahexagonal.core.ports.saida.AutorRepositoryPort;
import com.example.arquiteturahexagonal.core.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutorRepositoryAdapter implements AutorRepositoryPort {

    @Autowired
    private AutorConverter autorConverter;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> listar() {
        return autorRepository.findAll().stream().map(autorConverter::toDomain).toList();
    }

    @Override
    public Autor salvar(Autor autor) {
        AutorEntity autorSalvo = autorRepository.save(autorConverter.toEntity(autor));
        return autorConverter.toDomain(autorSalvo);
    }

    @Override
    public Autor buscarPorId(Long id) {
        return autorConverter.toDomain(autorRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Autor não encontrado! ID: " + id)));
    }

    @Override
    public Autor atualizar(Long id, Autor autor) {
        AutorEntity autorSalvo = autorRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Autor não encontrado! ID: " + id));
        autor.setId(autorSalvo.getId());
        return autorConverter.toDomain(autorRepository.save(autorConverter.toEntity(autor)));
    }

    @Override
    public void excluir(Long id) {
        if (autorRepository.existsById(id)) autorRepository.deleteById(id);
    }
}
