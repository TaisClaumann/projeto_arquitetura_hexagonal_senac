package com.example.arquiteturahexagonal.core.domain;

import java.util.List;

public class Livro {

    private Long id;
    private String nome;
    private List<Autor> autores;
    private List<Categoria> categorias;
    private List<Emprestimo> emprestimos;
    private List<Reserva> reservas;
    private String editora;
    private Integer quantidade;

    public Livro() {

    }

    public Livro(Long id, String nome, List<Autor> autores, List<Categoria> categorias,
                 List<Emprestimo> emprestimos, List<Reserva> reservas, String editora,
                 Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.autores = autores;
        this.categorias = categorias;
        this.emprestimos = emprestimos;
        this.reservas = reservas;
        this.editora = editora;
        this.quantidade = quantidade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public String getEditora() {
        return editora;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
