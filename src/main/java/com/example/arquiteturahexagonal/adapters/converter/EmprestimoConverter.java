package com.example.arquiteturahexagonal.adapters.converter;

import com.example.arquiteturahexagonal.adapters.dto.EmprestimoDto;
import com.example.arquiteturahexagonal.adapters.entities.EmprestimoEntity;
import com.example.arquiteturahexagonal.core.domain.Emprestimo;
import com.example.arquiteturahexagonal.core.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmprestimoConverter {

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Autowired
    private LivroConverter livroConverter;

    public Emprestimo toDomain(EmprestimoDto emprestimoDto) {
        return new Emprestimo(emprestimoDto.getId(),
                DataUtils.stringToLocalDate(emprestimoDto.getDataSaida()),
                DataUtils.stringToLocalDate(emprestimoDto.getDataVencimento()),
                emprestimoDto.getStatus(),
                usuarioConverter.toDomain(emprestimoDto.getUsuarioEmprestimo()),
                livroConverter.toDomain(emprestimoDto.getLivroEmprestimo()));
    }

    public Emprestimo toDomain(EmprestimoEntity emprestimoEntity) {
        return new Emprestimo(emprestimoEntity.getId(),
                emprestimoEntity.getDataSaida(),
                emprestimoEntity.getDataVencimento(),
                emprestimoEntity.getStatus(),
                usuarioConverter.toDomain(emprestimoEntity.getUsuario()),
                livroConverter.toDomain(emprestimoEntity.getLivro()));
    }

    public EmprestimoDto toDto(Emprestimo emprestimo) {
        return new EmprestimoDto(emprestimo.getId(),
                DataUtils.localDateToString(emprestimo.getDataSaida()),
                DataUtils.localDateToString(emprestimo.getDataVencimento()),
                usuarioConverter.toDto(emprestimo.getUsuarioEmprestimo()),
                livroConverter.toDto(emprestimo.getLivroEmprestimo()),
                emprestimo.getStatus());
    }

    public EmprestimoEntity toEntity(Emprestimo emprestimo) {
        return new EmprestimoEntity(emprestimo.getId(),
                usuarioConverter.toEntity(emprestimo.getUsuarioEmprestimo()),
                livroConverter.toEntity(emprestimo.getLivroEmprestimo()),
                emprestimo.getDataSaida(),
                emprestimo.getDataVencimento(),
                emprestimo.getStatus());
    }
}
