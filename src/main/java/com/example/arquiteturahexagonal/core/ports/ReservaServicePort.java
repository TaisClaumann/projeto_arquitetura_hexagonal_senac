package com.example.arquiteturahexagonal.core.ports;

import com.example.arquiteturahexagonal.core.domain.Categoria;
import com.example.arquiteturahexagonal.core.domain.Reserva;

import java.util.List;

public interface ReservaServicePort {

    Reserva salvar(Reserva reserva);
    Categoria buscarPorId(Long id);
    Categoria atualizar(Long id, Categoria categoria);
    List<Categoria> buscarTodos();
    void excluir(Long id);
}
