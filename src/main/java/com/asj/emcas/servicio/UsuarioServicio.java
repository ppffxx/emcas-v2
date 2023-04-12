package com.asj.emcas.servicio;

import com.asj.emcas.dto.UsuarioDTO;
import com.asj.emcas.dto.UsuarioLoginDTO;
import com.asj.emcas.dto.UsuarioReservaDTO;
import com.asj.emcas.dto.UsuarioSinIdDTO;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioServicio {

    UsuarioDTO crearUsuario(UsuarioSinIdDTO usuarioSinIdDTO);
    UsuarioReservaDTO obtenerUsuario(Integer idUsuario);
    void eliminarUsuario(Integer idUsuario);
    UsuarioDTO loginUsuario(UsuarioLoginDTO usuarioLoginDTO);
    boolean correoOUsuarioExiste(String correo, String usuario);

}
