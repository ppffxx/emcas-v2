package com.asj.emcas.servicio.impl;

import com.asj.emcas.entidad.Persona;
import com.asj.emcas.entidad.Usuario;
import com.asj.emcas.repositorio.PersonaRepositorio;
import com.asj.emcas.repositorio.UsuarioRepositorio;
import com.asj.emcas.servicio.UsuarioServicio;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    private final UsuarioRepositorio usuarioRepositorio;
    private final PersonaRepositorio personaRepositorio;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio, PersonaRepositorio personaRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.personaRepositorio = personaRepositorio;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {

        if(correoOUsuarioExiste(usuario.getCorreo(), usuario.getUsuario())) {
            throw new RuntimeException("Usuario o correo ya registrado");
        }

        Usuario usuarioCreado = usuarioRepositorio.save(usuario);
        Persona persona = new Persona();
        persona.setUsuario(usuarioCreado);
        personaRepositorio.save(persona);
        return usuarioCreado;
    }

    @Override
    public Usuario obtenerUsuario(Integer idUsuario) {
        Optional<Usuario> optionalUsuario = usuarioRepositorio.findById(idUsuario);

        if(optionalUsuario.isPresent()) {
            return optionalUsuario.get();
        } else {
            throw new RuntimeException("Usuario con el id " + idUsuario + " no existe");
        }

    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        Optional<Usuario> optionalUsuario = usuarioRepositorio.findById(idUsuario);
        if(optionalUsuario.isPresent()) {
            usuarioRepositorio.deleteById(idUsuario);
        } else {
            throw new RuntimeException("Usuario con el id " + idUsuario + " no existe");
        }
    }

    @Override
    public Usuario loginUsuario(Usuario usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepositorio.findByUsuario(usuario.getUsuario());
        if(optionalUsuario.isPresent()) {
            Usuario usuarioTemp = optionalUsuario.get();
            if(usuarioTemp.getUsuario().equals(usuario.getUsuario()) && usuarioTemp.getContrasenia().equals(usuario.getContrasenia())) {
                return usuarioTemp;
            } else {
                throw new RuntimeException("Credenciales incorrectas");
            }
        } else {
            throw new RuntimeException("Credenciales no encontradas");
        }
    }

    public boolean correoOUsuarioExiste(String correo, String usuario) {
        return (usuarioRepositorio.findByCorreo(correo).isPresent() || usuarioRepositorio.findByUsuario(usuario).isPresent());
    }

}
