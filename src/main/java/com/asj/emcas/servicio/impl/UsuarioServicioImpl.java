package com.asj.emcas.servicio.impl;

import com.asj.emcas.dto.UsuarioDTO;
import com.asj.emcas.dto.UsuarioLoginDTO;
import com.asj.emcas.dto.UsuarioReservaDTO;
import com.asj.emcas.dto.UsuarioSinIdDTO;
import com.asj.emcas.entidad.Persona;
import com.asj.emcas.entidad.Usuario;
import com.asj.emcas.exceptions.NotFoundException;
import com.asj.emcas.mapper.UsuarioMapper;
import com.asj.emcas.repositorio.PersonaRepositorio;
import com.asj.emcas.repositorio.UsuarioRepositorio;
import com.asj.emcas.servicio.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    private final UsuarioRepositorio usuarioRepositorio;
    private final PersonaRepositorio personaRepositorio;

    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO crearUsuario(UsuarioSinIdDTO usuarioSinIdDTO) {
        Usuario usuario = usuarioMapper.UsuarioDTORegistroToUsuarioEntity(usuarioSinIdDTO);
        if(correoOUsuarioExiste(usuario.getCorreo(), usuario.getUsuario())) {
            throw new RuntimeException("Usuario o correo ya registrado");
        }

        Usuario usuarioCreado = usuarioRepositorio.save(usuario);
        Persona persona = new Persona();
        persona.setUsuario(usuarioCreado);
        personaRepositorio.save(persona);
        UsuarioDTO usuarioDTO = usuarioMapper.UsuarioEntityToUsuarioDTO(usuarioCreado);
        return usuarioDTO;
    }

    @Override
    public UsuarioReservaDTO obtenerUsuario(Integer idUsuario) {
        Optional<Usuario> optionalUsuario = usuarioRepositorio.findById(idUsuario);
        if(optionalUsuario.isPresent()) {
            UsuarioReservaDTO usuarioReservaDTO = usuarioMapper.UsuarioEntityToUsuarioReservaDTO(optionalUsuario.get());
            return usuarioReservaDTO;
        } else {
            throw new NotFoundException("Usuario con el id " + idUsuario + " no existe");
        }
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        Optional<Usuario> optionalUsuario = usuarioRepositorio.findById(idUsuario);
        if(optionalUsuario.isPresent()) {
            usuarioRepositorio.deleteById(idUsuario);
        } else {
            throw new NotFoundException("Usuario con el id " + idUsuario + " no existe");
        }
    }

    @Override
    public UsuarioDTO loginUsuario(UsuarioLoginDTO usuarioLoginDTO) {
        Usuario usuario  = usuarioMapper.UsuarioLoginDTOToUsuarioEntity(usuarioLoginDTO);
        Optional<Usuario> optionalUsuario = usuarioRepositorio.findByUsuario(usuario.getUsuario());
        if(optionalUsuario.isPresent()) {
            Usuario usuarioTemp = optionalUsuario.get();
            if(usuarioTemp.getUsuario().equals(usuario.getUsuario()) && usuarioTemp.getContrasenia().equals(usuario.getContrasenia())) {
                UsuarioDTO usuarioLogin = usuarioMapper.UsuarioEntityToUsuarioDTO(usuarioTemp);
                return usuarioLogin;
            } else {
                throw new RuntimeException("Credenciales incorrectas");
            }
        } else {
            throw new NotFoundException("Credenciales no encontradas");
        }
    }

    public boolean correoOUsuarioExiste(String correo, String usuario) {
        return (usuarioRepositorio.findByCorreo(correo).isPresent() || usuarioRepositorio.findByUsuario(usuario).isPresent());
    }

}
