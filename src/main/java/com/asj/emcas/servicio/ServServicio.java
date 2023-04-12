package com.asj.emcas.servicio;

import com.asj.emcas.dto.ServicioDTO;
import com.asj.emcas.dto.ServicioSinIdDTO;
import com.asj.emcas.entidad.Servicio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ServServicio {
    ServicioDTO crearServicio(ServicioSinIdDTO servicioSinIdDTO);
    ServicioDTO obtenerServicio(Integer idServicio);
    ServicioDTO actualizarServicio(Integer idServicio, ServicioSinIdDTO servicioSinIdDTO);
    void eliminarServicio(Integer idServicio);
    List<ServicioDTO> obtenerTodosServicios();

}
