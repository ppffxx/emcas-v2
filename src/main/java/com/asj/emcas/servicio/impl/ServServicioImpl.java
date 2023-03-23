package com.asj.emcas.servicio.impl;

import com.asj.emcas.entidad.Servicio;
import com.asj.emcas.repositorio.ServicioRepositorio;
import com.asj.emcas.servicio.ServServicio;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ServServicioImpl implements ServServicio {

    private final ServicioRepositorio servicioRepositorio;

    public ServServicioImpl(ServicioRepositorio servicioRepositorio) {
        this.servicioRepositorio = servicioRepositorio;
    }

    @Override
    public Servicio crearServicio(Servicio servicio) {
        if(servicio.getNombre() != null) {
            return servicioRepositorio.save(servicio);
        } else {
            throw new RuntimeException("el nombre no puede ser nulo");
        }
    }

    @Override
    public Servicio obtenerServicio(Integer idServicio) {
        Optional<Servicio> optionalServicio = servicioRepositorio.findById(idServicio);

        if(optionalServicio.isPresent()) {
            return optionalServicio.get();
        } else {
            throw new RuntimeException("Servicio con el id " + idServicio + " no existe");
        }

    }

    @Override
    public Servicio actualizarServicio(Integer idServicio, Servicio tmp) {
        Servicio servAct;
        Optional<Servicio> optionalServicio = servicioRepositorio.findById(idServicio);
        if(optionalServicio.isPresent()) {
            servAct = optionalServicio.get();

            try {
                return servicioRepositorio.save(servAct);
            }
            catch (RuntimeException ex) {
                throw new RuntimeException("Servicio ya registrado");
            }

        } else {
            throw new RuntimeException("Servicio con el id " + idServicio + " no existe");
        }

    }

    @Override
    public void eliminarServicio(Integer idServicio) {
        Optional<Servicio> optionalServicio = servicioRepositorio.findById(idServicio);

        if(optionalServicio.isPresent()) {
            servicioRepositorio.deleteById(idServicio);
        } else {
            throw new RuntimeException("Servicio con el id " + idServicio + " no existe");
        }

    }

    @Override
    public List<Servicio> obtenerTodosServicios() {
        return servicioRepositorio.findAll() ;
    }
}
