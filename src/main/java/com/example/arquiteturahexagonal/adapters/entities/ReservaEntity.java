package com.example.arquiteturahexagonal.adapters.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reserva")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private UsuarioEntity usuario;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private LivroEntity livro;
}
