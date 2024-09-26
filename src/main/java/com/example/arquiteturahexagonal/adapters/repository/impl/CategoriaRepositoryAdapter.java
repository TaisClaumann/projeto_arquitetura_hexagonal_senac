package com.example.arquiteturahexagonal.adapters.repository.impl;

import com.example.arquiteturahexagonal.adapters.converter.CategoriaConverter;
import com.example.arquiteturahexagonal.adapters.entities.CategoriaEntity;
import com.example.arquiteturahexagonal.adapters.repository.CategoriaRepository;
import com.example.arquiteturahexagonal.core.domain.Categoria;
import com.example.arquiteturahexagonal.core.ports.saida.CategoriaRepositoryPort;
import com.example.arquiteturahexagonal.core.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaRepositoryAdapter implements CategoriaRepositoryPort {

    @Autowired
    private CategoriaConverter categoriaConverter;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll().stream().map(categoriaConverter::toDomain).toList();
    }

    @Override
    public Categoria salvar(Categoria categoria) {
        CategoriaEntity categoriaSalva = categoriaRepository.save(categoriaConverter.toEntity(categoria));
        return categoriaConverter.toDomain(categoriaSalva);
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return categoriaConverter.toDomain(categoriaRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Autor não encontrado! ID: " + id)));
    }

    @Override
    public Categoria atualizar(Long id, Categoria categoria) {
        CategoriaEntity categoriaSalva = categoriaRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Autor não encontrado! ID: " + id));
        categoria.setId(categoriaSalva.getId());
        return categoriaConverter.toDomain(categoriaRepository.save(categoriaConverter.toEntity(categoria)));
    }

    @Override
    public void excluir(Long id) {
        if (categoriaRepository.existsById(id)) categoriaRepository.deleteById(id);
    }
}
