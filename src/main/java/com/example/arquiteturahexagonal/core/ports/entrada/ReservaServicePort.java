package com.example.arquiteturahexagonal.core.ports.entrada;

import com.example.arquiteturahexagonal.core.domain.Reserva;

import java.util.List;

public interface ReservaServicePort {

    Reserva salvar(Reserva reserva);
    Reserva buscarPorId(Long id);
    Reserva atualizar(Long id, Reserva reserva);
    List<Reserva> buscarTodos();
    void excluir(Long id);
    List<Reserva> buscarReservasPorUsuario(Long usuarioId);
}
