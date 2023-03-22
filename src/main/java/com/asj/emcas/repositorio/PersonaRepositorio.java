package com.asj.emcas.repositorio;

import com.asj.emcas.entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {
}
