package com.example.arquiteturahexagonal.adapters.converter;

import com.example.arquiteturahexagonal.adapters.dto.ReservaDto;
import com.example.arquiteturahexagonal.adapters.entities.ReservaEntity;
import com.example.arquiteturahexagonal.core.domain.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaConverter {

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Autowired
    private LivroConverter livroConverter;

    public Reserva toDomain(ReservaDto reservaDto) {
        return new Reserva(reservaDto.getId(),
                reservaDto.getData(),
                usuarioConverter.toDomain(reservaDto.getUsuarioReserva()),
                livroConverter.toDomain(reservaDto.getLivroReserva()));
    }

    public Reserva toDomain(ReservaEntity reservaEntity) {
        return new Reserva(reservaEntity.getId(),
                reservaEntity.getData(),
                usuarioConverter.toDomain(reservaEntity.getUsuario()),
                livroConverter.toDomain(reservaEntity.getLivro()));
    }

    public ReservaDto toDto(Reserva reserva) {
        return new ReservaDto(reserva.getId(),
                usuarioConverter.toDto(reserva.getUsuarioReserva()),
                livroConverter.toDto(reserva.getLivroReserva()),
                reserva.getData());
    }

    public ReservaEntity toEntity(Reserva reserva) {
        return new ReservaEntity(reserva.getId(),
                reserva.getData(),
                usuarioConverter.toEntity(reserva.getUsuarioReserva()),
                livroConverter.toEntity(reserva.getLivroReserva()));
    }
}
