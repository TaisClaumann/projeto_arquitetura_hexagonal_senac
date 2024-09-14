package com.example.arquiteturahexagonal.adapters.controller;

import com.example.arquiteturahexagonal.adapters.converter.LivroConverter;
import com.example.arquiteturahexagonal.adapters.dto.LivroDto;
import com.example.arquiteturahexagonal.core.ports.LivroServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroServicePort livroService;

    @Autowired
    private LivroConverter livroConverter;

    @PostMapping
    public LivroDto salvar(@RequestBody LivroDto livroDto) {
        return livroConverter.toDto(livroService.salvar(livroConverter.toDomain(livroDto)));
    }

    @PutMapping("/{id}")
    public LivroDto atualizar(@PathVariable("id") Long id, @RequestBody LivroDto livroDto) {
        return livroConverter.toDto(livroService.atualizar(id, livroConverter.toDomain(livroDto)));
    }

    @GetMapping("/{id}")
    public LivroDto buscarPorId(@PathVariable("id") Long id) {
        return livroConverter.toDto(livroService.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public List<LivroDto> buscarPorNome(@RequestParam("nome") String nome) {
        return livroService.buscarPorNome(nome).stream().map(l -> livroConverter.toDto(l)).toList();
    }

    @GetMapping
    public List<LivroDto> listar() {
        return livroService.buscarTodos().stream().map(l -> livroConverter.toDto(l)).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        livroService.excluir(id);
    }
}
