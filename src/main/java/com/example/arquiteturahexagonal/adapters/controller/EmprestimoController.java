package com.example.arquiteturahexagonal.adapters.controller;

import com.example.arquiteturahexagonal.adapters.converter.EmprestimoConverter;
import com.example.arquiteturahexagonal.adapters.dto.EmprestimoDto;
import com.example.arquiteturahexagonal.core.domain.Emprestimo;
import com.example.arquiteturahexagonal.core.ports.EmprestimoServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    
    @Autowired
    private EmprestimoServicePort emprestimoService;

    @Autowired
    private EmprestimoConverter emprestimoConverter;

    @PostMapping
    public EmprestimoDto salvar(@RequestBody EmprestimoDto emprestimoDto) {
        return emprestimoConverter.toDto(emprestimoService.salvar(emprestimoConverter.toDomain(emprestimoDto)));
    }

    @PutMapping("/{id}")
    public EmprestimoDto atualizar(@PathVariable("id") Long id, @RequestBody Emprestimo emprestimo) {
        return emprestimoConverter.toDto(emprestimoService.atualizar(id, emprestimo));
    }

    @GetMapping("/{id}")
    public EmprestimoDto buscarPorId(@PathVariable("id") Long id) {
        return emprestimoConverter.toDto(emprestimoService.buscarPorId(id));
    }

    @GetMapping
    public List<EmprestimoDto> buscarTodos() {
        return emprestimoService.buscarTodos().stream().map(e -> emprestimoConverter.toDto(e)).toList();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<EmprestimoDto> buscarPorUsuario(@PathVariable("usuarioId") Long usuarioId) {
        return emprestimoService.buscarPorUsuario(usuarioId).stream().map(e -> emprestimoConverter.toDto(e)).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        emprestimoService.excluir(id);
    }
}
