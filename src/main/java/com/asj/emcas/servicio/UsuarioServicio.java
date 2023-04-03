package com.asj.emcas.servicio;

import com.asj.emcas.entidad.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UsuarioServicio {

    Usuario crearUsuario(Usuario usuario);
    Usuario obtenerUsuario(Integer idUsuario);

    void eliminarUsuario(Integer idUsuario);
    List<Usuario> obtenerTodosUsuarios();

    Usuario loginUsuario(Usuario usuario);
    boolean correoOUsuarioExiste(String correo, String usuario);

}
