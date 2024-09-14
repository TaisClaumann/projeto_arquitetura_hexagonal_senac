package com.example.arquiteturahexagonal.adapters.dto;

import com.example.arquiteturahexagonal.core.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmprestimoDto {

    private Long id;
    private String dataSaida;
    private String dataVencimento;
    private UsuarioDto usuarioEmprestimo;
    private LivroDto livroEmprestimo;
    private StatusEnum status;
}
