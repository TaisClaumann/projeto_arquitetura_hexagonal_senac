package com.example.arquiteturahexagonal.core.domain;

import java.util.List;

public class Categoria {

    private Long id;
    private String nome;
    private List<Livro> livros;

    public Categoria() {

    }

    public Categoria(Long id, String nome, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.livros = livros;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
