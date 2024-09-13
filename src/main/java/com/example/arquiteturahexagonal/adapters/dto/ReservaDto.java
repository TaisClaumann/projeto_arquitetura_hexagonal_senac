package com.example.arquiteturahexagonal.adapters.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservaDto {

    private Long id;
    private UsuarioDto usuarioReserva;
    private LivroDto livroReserva;
    private LocalDate data;
}
