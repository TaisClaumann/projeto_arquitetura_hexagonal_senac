package com.example.arquiteturahexagonal.core.ports.saida;

import com.example.arquiteturahexagonal.core.domain.Reserva;

import java.util.List;

public interface ReservaRepositoryPort {

    List<Reserva> listar();

    Reserva salvar(Reserva reserva);

    Reserva buscarPorId(Long id);

    Reserva atualizar(Long id, Reserva reserva);

    void excluir(Long id);

    List<Reserva> buscarReservasPorUsuario(Long usuarioId);
}
