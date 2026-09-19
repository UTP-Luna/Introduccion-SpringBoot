package com.UTP.Proyecto.controller;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/saludo")

public class SaludoController {

    // GET /api/saludo/{nombre}
    @GetMapping("/{nombre}")
    public String saludoPath(@PathVariable String nombre) {
        LocalDateTime ahora = LocalDateTime.now();
        DayOfWeek dia = ahora.getDayOfWeek();
        String diaSemana = dia.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        return "Hola " + nombre + ", hoy es " + diaSemana + " y la hora exacta es " + ahora;
    }

    // POST /api/saludo
    @PostMapping
    public List<String> saludoMultiple(@RequestBody List<String> nombres) {
        LocalDateTime ahora = LocalDateTime.now();
        DayOfWeek dia = ahora.getDayOfWeek();
        String diaSemana = dia.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));

        return nombres.stream()
                .map(n -> "Hola " + n + ", hoy es " + diaSemana + " y la hora exacta es " + ahora)
                .toList();
    }
}

