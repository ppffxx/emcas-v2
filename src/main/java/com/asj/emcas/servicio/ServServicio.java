package com.asj.emcas.servicio;

import com.asj.emcas.dto.ServicioSinIdDTO;
import com.asj.emcas.entidad.Servicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServServicio {
    Servicio crearServicio(ServicioSinIdDTO servicioSinIdDTO);
    Servicio obtenerServicio(Integer idServicio);
    Servicio actualizarServicio(Integer idServicio, ServicioSinIdDTO servicioSinIdDTO);
    void eliminarServicio(Integer idServicio);
    List<Servicio> obtenerTodosServicios();



}
