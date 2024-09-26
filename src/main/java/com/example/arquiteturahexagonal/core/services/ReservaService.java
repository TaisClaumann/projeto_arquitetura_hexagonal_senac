package com.example.arquiteturahexagonal.core.services;

import com.example.arquiteturahexagonal.core.domain.Reserva;
import com.example.arquiteturahexagonal.core.ports.entrada.ReservaServicePort;
import com.example.arquiteturahexagonal.core.ports.saida.ReservaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservaService implements ReservaServicePort {

    @Autowired
    private ReservaRepositoryPort reservaRepositoryPort;

    @Override
    public Reserva salvar(Reserva reserva) {
        return reservaRepositoryPort.salvar(reserva);
    }

    @Override
    public Reserva buscarPorId(Long id) {
        return reservaRepositoryPort.buscarPorId(id);
    }

    @Override
    public Reserva atualizar(Long id, Reserva reserva) {
        return reservaRepositoryPort.atualizar(id, reserva);
    }

    @Override
    public List<Reserva> buscarTodos() {
        return reservaRepositoryPort.listar();
    }

    @Override
    public void excluir(Long id) {
        reservaRepositoryPort.excluir(id);
    }

    @Override
    public List<Reserva> buscarReservasPorUsuario(Long usuarioId) {
        return reservaRepositoryPort.buscarReservasPorUsuario(usuarioId);
    }
}
