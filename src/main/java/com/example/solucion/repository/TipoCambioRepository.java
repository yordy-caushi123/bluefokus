package com.example.solucion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.solucion.entity.TipoCambio;

import java.util.List;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Integer> {

    List<TipoCambio> findByTipoCambio(float tipoCambio);

    // Puedes agregar más consultas personalizadas según tus necesidades
}