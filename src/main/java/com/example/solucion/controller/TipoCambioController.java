package com.example.solucion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.solucion.entity.TipoCambio;
import com.example.solucion.service.TipoCambioService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tipo-cambio")
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;

    @Autowired
    public TipoCambioController(TipoCambioService tipoCambioService) {
        this.tipoCambioService = tipoCambioService;
    }

    @GetMapping
    public Flux<TipoCambio> obtenerTodosLosTipoCambios() {
        return tipoCambioService.obtenerTodosLosTipoCambios();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<TipoCambio>> obtenerTipoCambioPorId(@PathVariable int id) {
        return tipoCambioService.obtenerTipoCambioPorId(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<TipoCambio>> crearTipoCambio(@RequestBody TipoCambio tipoCambio) {
        return tipoCambioService.guardarTipoCambio(tipoCambio)
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<TipoCambio>> editarTipoCambio(@PathVariable int id, @RequestBody TipoCambio tipoCambio) {
        return tipoCambioService.editarTipoCambio(id, tipoCambio)
                .map(tipoCambioActualizado -> ResponseEntity.ok(tipoCambioActualizado))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminarTipoCambio(@PathVariable int id) {
        return tipoCambioService.eliminarTipoCambio(id)
                .map(deleted -> deleted ? ResponseEntity.noContent().<Void>build() : ResponseEntity.notFound().<Void>build());
    }

    @GetMapping("/buscar-por-tipo-cambio/{tipoCambio}")
    public Flux<TipoCambio> buscarPorTipoCambio(@PathVariable float tipoCambio) {
        return tipoCambioService.buscarPorTipoCambio(tipoCambio);
    }
}