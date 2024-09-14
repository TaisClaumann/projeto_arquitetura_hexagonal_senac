package com.example.arquiteturahexagonal.adapters.controller;

import com.example.arquiteturahexagonal.adapters.converter.CategoriaConverter;
import com.example.arquiteturahexagonal.adapters.dto.CategoriaDto;
import com.example.arquiteturahexagonal.core.ports.CategoriaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServicePort categoriaService;

    @Autowired
    private CategoriaConverter categoriaConverter;

    @PostMapping
    public CategoriaDto salvar(@RequestBody CategoriaDto categoriaDto) {
        return categoriaConverter.toDto(categoriaService.salvar(categoriaConverter.toDomain(categoriaDto)));
    }

    @PutMapping("/{id}")
    public CategoriaDto atualizar(@PathVariable("id") Long id, @RequestBody CategoriaDto categoriaDto) {
        return categoriaConverter.toDto(categoriaService.atualizar(id, categoriaConverter.toDomain(categoriaDto)));
    }

    @GetMapping("/{id}")
    public CategoriaDto buscarPorId(@PathVariable("id") Long id) {
        return categoriaConverter.toDto(categoriaService.buscarPorId(id));
    }

    @GetMapping
    public List<CategoriaDto> listar() {
        return categoriaService.buscarTodos().stream().map(c -> categoriaConverter.toDto(c)).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        categoriaService.excluir(id);
    }
}
