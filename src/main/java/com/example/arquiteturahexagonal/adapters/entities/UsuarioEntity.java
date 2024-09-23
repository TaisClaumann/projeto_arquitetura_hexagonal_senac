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
@Table(name = "usuario")
public class UsuarioEntity {

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    public List<EmprestimoEntity> emprestimos;
    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    public List<ReservaEntity> reservas;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String dataNascimento;
    private boolean ativo;
}
