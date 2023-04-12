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
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    private final UsuarioRepositorio usuarioRepositorio;
    private final PersonaRepositorio personaRepositorio;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO crearUsuario(UsuarioSinIdDTO usuarioSinIdDTO) {
        Usuario usuario = usuarioMapper.UsuarioDTORegistroToUsuarioEntity(usuarioSinIdDTO);
        if(correoOUsuarioExiste(usuario.getCorreo(), usuario.getUsuario())) {throw new RuntimeException("Usuario o correo ya registrado");}
        Usuario usuarioCreado = usuarioRepositorio.save(usuario);
        Persona persona = new Persona();
        persona.setUsuario(usuarioCreado);
        personaRepositorio.save(persona);
        return usuarioMapper.UsuarioEntityToUsuarioDTO(usuarioCreado);
    }

    @Override
    public UsuarioReservaDTO obtenerUsuario(Integer idUsuario) {
        Usuario user = usuarioRepositorio.findById(idUsuario).orElseThrow(() -> new NotFoundException("Usuario con el id " + idUsuario + " no existe"));
        return usuarioMapper.UsuarioEntityToUsuarioReservaDTO(user);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) {
        usuarioRepositorio.findById(idUsuario).orElseThrow(() -> new NotFoundException("Usuario con el id " + idUsuario + " no existe"));
        usuarioRepositorio.deleteById(idUsuario);
    }

    @Override
    public UsuarioDTO loginUsuario(UsuarioLoginDTO usuarioLoginDTO) {
        Usuario usuarioTemp = usuarioRepositorio.findByUsuario(usuarioLoginDTO.getUsuario()).orElseThrow(() -> new NotFoundException("Credenciales no encontradas"));
        if(usuarioTemp.getUsuario().equals(usuarioLoginDTO.getUsuario()) && usuarioTemp.getContrasenia().equals(usuarioLoginDTO.getContrasenia())) {
            return usuarioMapper.UsuarioEntityToUsuarioDTO(usuarioTemp);
        } else {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }

    public boolean correoOUsuarioExiste(String correo, String usuario) {
        return (usuarioRepositorio.findByCorreo(correo).isPresent() || usuarioRepositorio.findByUsuario(usuario).isPresent());
    }

}
