package com.asj.emcas.servicio.impl;

import com.asj.emcas.dto.ServicioSinIdDTO;
import com.asj.emcas.entidad.Servicio;
import com.asj.emcas.exceptions.NotFoundException;
import com.asj.emcas.mapper.ServicioMapper;
import com.asj.emcas.repositorio.ServicioRepositorio;
import com.asj.emcas.servicio.ServServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ServServicioImpl implements ServServicio {
    private final ServicioRepositorio servicioRepositorio;
    private final ServicioMapper servicioMapper;
    @Override
    public Servicio crearServicio(ServicioSinIdDTO servicioSinIdDTO) {
        Servicio servicio = servicioMapper.ServicioCreacionDTOToServicioEntity(servicioSinIdDTO);
        return servicioRepositorio.save(servicio);
    }

    @Override
    public Servicio obtenerServicio(Integer idServicio) {
        return servicioRepositorio.findById(idServicio).orElseThrow(() -> new NotFoundException("Servicio con el id " + idServicio + " no existe"));
    }

    @Override
    public Servicio actualizarServicio(Integer idServicio, ServicioSinIdDTO servicioSinIdDTO) {
        Servicio servicioTemp = servicioMapper.ServicioCreacionDTOToServicioEntity(servicioSinIdDTO);
        Servicio servAct = servicioRepositorio.findById(idServicio).orElseThrow(() -> new NotFoundException("Servicio con el id " + idServicio + " no existe"));
        if(servicioTemp.getNombre() != null) {servAct.setNombre(servicioTemp.getNombre());}
        if(servicioTemp.getDescripcion() != null) {servAct.setDescripcion(servicioTemp.getDescripcion());}
        if(servicioTemp.getPrecio() != null) {servAct.setPrecio(servicioTemp.getPrecio());}
        return servicioRepositorio.save(servAct);
    }

    @Override
    public void eliminarServicio(Integer idServicio) {
        servicioRepositorio.findById(idServicio).orElseThrow(() -> new NotFoundException("Servicio con el id " + idServicio + " no existe"));
        servicioRepositorio.deleteById(idServicio);
    }

    @Override
    public List<Servicio> obtenerTodosServicios() {
        return servicioRepositorio.findAll() ;
    }
}
