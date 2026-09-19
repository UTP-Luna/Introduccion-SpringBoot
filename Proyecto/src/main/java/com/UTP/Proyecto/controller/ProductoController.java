package com.UTP.Proyecto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UTP.Proyecto.DTO.ProductoDTO;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @PostMapping
    public ProductoDTO crear(@RequestBody ProductoDTO producto) {
        // aquí podrías guardar en una BD; por ahora solo retornamos lo recibido
        return producto;
    }

    @GetMapping("/{nombre}")
    public String saludarPath(@PathVariable String nombre) {
        return "Hola (PathVariable) " + nombre;
    }

    @GetMapping
    public String saludarParam(@RequestParam String nombre) {
        return "Hola (RequestParam) " + nombre;
    }

    @GetMapping("/opcional")
    public String saludarParamOpcional(
        @RequestParam(defaultValue = "Mundo") String nombre) {
        return "Hola (RequestParam opcional) " + nombre;
    }
}

