package com.asj.emcas.repositorio;

import com.asj.emcas.entidad.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Integer> {


}
