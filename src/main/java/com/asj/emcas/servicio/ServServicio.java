package com.asj.emcas.servicio;

import com.asj.emcas.entidad.Servicio;

import java.util.List;

public interface ServServicio {
    Servicio crearServicio(Servicio servicio);
    Servicio obtenerServicio(Integer idServicio);
    Servicio actualizarServicio(Integer idServicio, Servicio tmp);
    void eliminarServicio(Integer idServicio);
    List<Servicio> obtenerTodosServicios();



}
