package com.example.solucion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.solucion.entity.TipoCambio;
import com.example.solucion.repository.TipoCambioRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TipoCambioService {

    private final TipoCambioRepository tipoCambioRepository;

    @Autowired
    public TipoCambioService(TipoCambioRepository tipoCambioRepository) {
        this.tipoCambioRepository = tipoCambioRepository;
    }

    public Flux<TipoCambio> obtenerTodosLosTipoCambios() {
        return Flux.fromIterable(tipoCambioRepository.findAll());
    }

    public Mono<TipoCambio> obtenerTipoCambioPorId(int id) {
        return Mono.justOrEmpty(tipoCambioRepository.findById(id));
    }

    public Mono<TipoCambio> guardarTipoCambio(TipoCambio tipoCambio) {
        return Mono.just(tipoCambioRepository.save(tipoCambio));
    }

    public Mono<TipoCambio> editarTipoCambio(int id, TipoCambio tipoCambio) {
        return obtenerTipoCambioPorId(id)
                .flatMap(existingTipoCambio -> {
                    tipoCambio.setId(id);
                    return Mono.just(tipoCambioRepository.save(tipoCambio));
                });
    }

    public Mono<Boolean> eliminarTipoCambio(int id) {
        return obtenerTipoCambioPorId(id)
                .flatMap(existingTipoCambio -> {
                    tipoCambioRepository.deleteById(id);
                    return Mono.just(true);
                })
                .defaultIfEmpty(false);
    }

    public Flux<TipoCambio> buscarPorTipoCambio(float tipoCambio) {
        return Flux.fromIterable(tipoCambioRepository.findByTipoCambio(tipoCambio));
    }
}