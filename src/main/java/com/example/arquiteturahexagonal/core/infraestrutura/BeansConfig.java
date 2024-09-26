package com.example.arquiteturahexagonal.core.infraestrutura;

import com.example.arquiteturahexagonal.core.ports.entrada.*;
import com.example.arquiteturahexagonal.core.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public UsuarioServicePort usuarioServicePortImpl() {
        return new UsuarioService();
    }

    @Bean
    public ReservaServicePort reservaServicePortImpl() {
        return new ReservaService();
    }

    @Bean
    public LivroServicePort livroServicePortImpl() {
        return new LivroService();
    }

    @Bean
    public EmprestimoServicePort emprestimoServicePortImpl() {
        return new EmprestimoService();
    }

    @Bean
    public CategoriaServicePort categoriaServicePortImpl() {
        return new CategoriaService();
    }

    @Bean
    public AutorServicePort autorServicePortImpl() {
        return new AutorService();
    }
}
