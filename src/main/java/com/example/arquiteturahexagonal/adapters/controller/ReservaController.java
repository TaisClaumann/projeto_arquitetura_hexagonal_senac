package com.example.arquiteturahexagonal.adapters.controller;

import com.example.arquiteturahexagonal.adapters.converter.ReservaConverter;
import com.example.arquiteturahexagonal.adapters.dto.ReservaDto;
import com.example.arquiteturahexagonal.core.ports.ReservaServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaServicePort reservaService;

    @Autowired
    private ReservaConverter reservaConverter;

    @PostMapping
    public ReservaDto salvar(@RequestBody ReservaDto reservaDto) {
        return reservaConverter.toDto(reservaService.salvar(reservaConverter.toDomain(reservaDto)));
    }

    @PutMapping("/{id}")
    public ReservaDto atualizar(@PathVariable("id") Long id, @RequestBody ReservaDto reservaDto) {
        return reservaConverter.toDto(reservaService.atualizar(id, reservaConverter.toDomain(reservaDto)));
    }

    @GetMapping
    public List<ReservaDto> listar() {
        return reservaService.buscarTodos().stream().map(r -> reservaConverter.toDto(r)).toList();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long id) {
        reservaService.excluir(id);
    }

    @GetMapping("/{id}")
    public ReservaDto buscarPorId(@PathVariable("id") Long id) {
        return reservaConverter.toDto(reservaService.buscarPorId(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<ReservaDto> buscarPorUsuario(@PathVariable("usuarioId") Long usuarioId) {
        return reservaService.buscarReservasPorUsuario(usuarioId).stream().map(r -> reservaConverter.toDto(r)).toList();
    }
}
