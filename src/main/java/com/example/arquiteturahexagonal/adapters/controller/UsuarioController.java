package com.example.arquiteturahexagonal.adapters.controller;

import com.example.arquiteturahexagonal.adapters.converter.UsuarioConverter;
import com.example.arquiteturahexagonal.adapters.dto.LoginDto;
import com.example.arquiteturahexagonal.adapters.dto.UsuarioDto;
import com.example.arquiteturahexagonal.core.ports.entrada.UsuarioServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServicePort usuarioService;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @PostMapping
    public UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto) {
        return usuarioConverter.toDto(usuarioService.salvar(usuarioConverter.toDomain(usuarioDto)));
    }

    @PutMapping("/{id}")
    public UsuarioDto atualizar(@PathVariable("id") Long id, @RequestBody UsuarioDto usuarioDto) {
        return usuarioConverter.toDto(usuarioService.atualizar(id, usuarioConverter.toDomain(usuarioDto)));
    }

    @GetMapping("/{id}")
    public UsuarioDto buscarPorId(@PathVariable("id") Long id) {
        return usuarioConverter.toDto(usuarioService.buscarPorId(id));
    }

    @GetMapping
    public List<UsuarioDto> buscarTodos() {
        return usuarioService.buscarTodos().stream().map(u -> usuarioConverter.toDto(u)).toList();
    }

    @PostMapping("/login")
    public void logar(@RequestBody LoginDto loginDto) {
        usuarioService.logar(loginDto);
    }
}
