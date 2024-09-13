package com.example.arquiteturahexagonal.adapters.converter;

import com.example.arquiteturahexagonal.adapters.dto.CategoriaDto;
import com.example.arquiteturahexagonal.adapters.dto.ReservaDto;
import com.example.arquiteturahexagonal.core.domain.Categoria;
import com.example.arquiteturahexagonal.core.domain.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

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

    public ReservaDto toDto(Reserva reserva) {
        return new ReservaDto(reserva.getId(),
                usuarioConverter.toDto(reserva.getUsuarioReserva()),
                livroConverter.toDto(reserva.getLivroReserva()),
                reserva.getData());
    }
}
