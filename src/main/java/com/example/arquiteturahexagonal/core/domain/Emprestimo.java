package com.example.arquiteturahexagonal.core.domain;

import com.example.arquiteturahexagonal.core.enums.StatusEnum;

import java.time.LocalDate;

public class Emprestimo {

    private Long id;
    private LocalDate dataSaida;
    private LocalDate dataVencimento;
    private StatusEnum status;
    public Usuario usuarioEmprestimo;
    public Livro livroEmprestimo;

    public Emprestimo() {

    }

    public Emprestimo(Long id, LocalDate dataSaida, LocalDate dataVencimento,
                      StatusEnum status, Usuario usuarioEmprestimo, Livro livroEmprestimo) {
        this.id = id;
        this.dataSaida = dataSaida;
        this.dataVencimento = dataVencimento;
        this.status = status;
        this.usuarioEmprestimo = usuarioEmprestimo;
        this.livroEmprestimo = livroEmprestimo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public void setUsuarioEmprestimo(Usuario usuarioEmprestimo) {
        this.usuarioEmprestimo = usuarioEmprestimo;
    }

    public void setLivroEmprestimo(Livro livroEmprestimo) {
        this.livroEmprestimo = livroEmprestimo;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public Usuario getUsuarioEmprestimo() {
        return usuarioEmprestimo;
    }

    public Livro getLivroEmprestimo() {
        return livroEmprestimo;
    }
}
