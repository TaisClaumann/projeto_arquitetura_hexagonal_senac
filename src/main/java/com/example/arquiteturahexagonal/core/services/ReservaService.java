package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.core.domain.Reserva;
import com.example.arquiteturahexagonal.core.ports.ReservaServicePort;

import java.util.List;

public class ReservaService implements ReservaServicePort {

    @Override
    public Reserva salvar(Reserva reserva) {
        return reserva;
    }

    @Override
    public Reserva buscarPorId(Long id) {
        return new Reserva();
    }

    @Override
    public Reserva atualizar(Long id, Reserva reserva) {
        return reserva;
    }

    @Override
    public List<Reserva> buscarTodos() {
        return List.of();
    }

    @Override
    public void excluir(Long id) {

    }

    @Override
    public List<Reserva> buscarReservasPorUsuario(Long usuarioId) {
        return List.of();
    }
}
