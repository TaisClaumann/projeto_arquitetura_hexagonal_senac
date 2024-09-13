package com.example.arquiteturahexagonal.core.domain;

import java.time.LocalDate;

public class Reserva {

    private Long id;
    private LocalDate data;
    private Usuario usuarioReserva;
    private Livro livroReserva;

    public Reserva() {}

    public Reserva(Long id, LocalDate data, Usuario usuarioReserva, Livro livroReserva) {
        this.id = id;
        this.data = data;
        this.usuarioReserva = usuarioReserva;
        this.livroReserva = livroReserva;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setUsuarioReserva(Usuario usuarioReserva) {
        this.usuarioReserva = usuarioReserva;
    }

    public void setLivroReserva(Livro livroReserva) {
        this.livroReserva = livroReserva;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Usuario getUsuarioReserva() {
        return usuarioReserva;
    }

    public Livro getLivroReserva() {
        return livroReserva;
    }
}
