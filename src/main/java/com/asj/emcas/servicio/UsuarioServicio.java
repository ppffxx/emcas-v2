package com.asj.emcas.servicio;

import com.asj.emcas.entidad.Usuario;

import java.util.List;



public interface UsuarioServicio {

    Usuario crearUsuario(Usuario usuario);
    Usuario obtenerUsuario(Integer idUsuario);
    Usuario actualizarUsuario(Integer idUsuario, Usuario usuario);
    void eliminarUsuario(Integer idUsuario);
    List<Usuario> obtenerTodosUsuarios();

}
