package com.example.arquiteturahexagonal.adapters.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "livro")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "livro_autor", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<AutorEntity> autores;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "livro_categoria", joinColumns = @JoinColumn(name = "livro_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<CategoriaEntity> categorias;

    @JsonIgnore
    @OneToMany(mappedBy = "livro")
    private List<EmprestimoEntity> emprestimos;

    @JsonIgnore
    @OneToMany(mappedBy = "livro")
    private List<ReservaEntity> reservas;

    private String editora;

    private Integer quantidade;

}
