package com.example.arquiteturahexagonal.adapters.controller;

import com.example.arquiteturahexagonal.adapters.converter.AutorConverter;
import com.example.arquiteturahexagonal.adapters.dto.AutorDto;
import com.example.arquiteturahexagonal.core.ports.entrada.AutorServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorServicePort autorService;

    @Autowired
    private AutorConverter autorConverter;

    @PostMapping
    public AutorDto salvar(@RequestBody AutorDto autorDto) {
        return autorConverter.toDto(autorService.salvar(autorConverter.toDomain(autorDto)));
    }

    @PutMapping("/{id}")
    public AutorDto atualizar(@PathVariable("id") Long id, @RequestBody AutorDto autorDto) {
        return autorConverter.toDto(autorService.atualizar(id, autorConverter.toDomain(autorDto)));
    }

    @GetMapping("/{id}")
    public AutorDto buscarPorId(@PathVariable("id") Long id) {
        return autorConverter.toDto(autorService.buscarPorId(id));
    }


    @GetMapping
    public List<AutorDto> listar() {
        return autorService.buscarTodos().stream().map(a -> autorConverter.toDto(a)).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        autorService.excluir(id);
    }
}
