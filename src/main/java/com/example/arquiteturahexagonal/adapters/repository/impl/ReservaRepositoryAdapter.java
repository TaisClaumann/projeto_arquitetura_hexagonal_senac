package com.example.arquiteturahexagonal.adapters.repository.impl;

import com.example.arquiteturahexagonal.adapters.converter.ReservaConverter;
import com.example.arquiteturahexagonal.adapters.entities.ReservaEntity;
import com.example.arquiteturahexagonal.adapters.repository.ReservaRepository;
import com.example.arquiteturahexagonal.core.domain.Reserva;
import com.example.arquiteturahexagonal.core.ports.saida.ReservaRepositoryPort;
import com.example.arquiteturahexagonal.core.services.exceptions.RegistroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservaRepositoryAdapter implements ReservaRepositoryPort {

    @Autowired
    private ReservaConverter reservaConverter;

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<Reserva> listar() {
        return reservaRepository.findAll().stream().map(reservaConverter::toDomain).toList();
    }

    @Override
    public Reserva salvar(Reserva Reserva) {
        ReservaEntity ReservaSalvo = reservaRepository.save(reservaConverter.toEntity(Reserva));
        return reservaConverter.toDomain(ReservaSalvo);
    }

    @Override
    public Reserva buscarPorId(Long id) {
        return reservaConverter.toDomain(reservaRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Reserva não encontrado! ID: " + id)));
    }

    @Override
    public Reserva atualizar(Long id, Reserva Reserva) {
        ReservaEntity ReservaSalvo = reservaRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("Reserva não encontrado! ID: " + id));
        Reserva.setId(ReservaSalvo.getId());
        return reservaConverter.toDomain(reservaRepository.save(reservaConverter.toEntity(Reserva)));
    }

    @Override
    public void excluir(Long id) {
        if (reservaRepository.existsById(id)) reservaRepository.deleteById(id);
    }

    @Override
    public List<Reserva> buscarReservasPorUsuario(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId).stream().map(reservaConverter::toDomain).toList();
    }
}
