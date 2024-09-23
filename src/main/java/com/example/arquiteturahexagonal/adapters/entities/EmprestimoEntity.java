package com.example.arquiteturahexagonal.adapters.entities;

import com.example.arquiteturahexagonal.core.enums.StatusEnum;
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
@Table(name = "emprestimo")
public class EmprestimoEntity {

    @ManyToOne(cascade = CascadeType.REFRESH)
    public UsuarioEntity usuario;
    @ManyToOne(cascade = CascadeType.REFRESH)
    public LivroEntity livro;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataSaida;
    private LocalDate dataVencimento;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
