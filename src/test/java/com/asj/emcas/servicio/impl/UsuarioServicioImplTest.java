package com.asj.emcas.servicio.impl;

import com.asj.emcas.datos.DatosDummy;
import com.asj.emcas.entidad.Persona;
import com.asj.emcas.entidad.Reserva;
import com.asj.emcas.entidad.Usuario;
import com.asj.emcas.repositorio.PersonaRepositorio;
import com.asj.emcas.repositorio.UsuarioRepositorio;
import com.asj.emcas.servicio.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@SpringBootTest
class UsuarioServicioImplTest {

    @MockBean
    private UsuarioRepositorio usuarioRepositorio;
    @MockBean
    private PersonaRepositorio personaRepositorio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    void crearUsuario() {

        Usuario usuario = DatosDummy.getUser();

        usuarioServicio.crearUsuario(usuario);

        ArgumentCaptor<Usuario> usuarioArgumentCaptor = ArgumentCaptor.forClass(Usuario.class);
        verify(usuarioRepositorio).save(usuarioArgumentCaptor.capture());

        Usuario usuarioCaptor = usuarioArgumentCaptor.getValue();

        assertThat(usuarioCaptor).isEqualTo(usuario);
        verify(usuarioRepositorio).save(any());

    }

    @Test
    void crearUsuarioMal() {
        Usuario usuario = DatosDummy.getUser();

        given(usuarioRepositorio.findByUsuario(usuario.getUsuario())).willReturn(Optional.of(usuario));
        assertThatThrownBy(() -> usuarioServicio.crearUsuario(usuario)).isInstanceOf(RuntimeException.class);
    }


    @Test
    void obtenerUsuario() {

        Integer idUsuario = 1;
        when(usuarioRepositorio.findById(idUsuario)).thenReturn(Optional.of(DatosDummy.getUser()));
        Usuario usuario = usuarioServicio.obtenerUsuario(idUsuario);
        assertThat(usuario.getIdUsuario()).isEqualTo(1);

    }

    @Test
    void obtenerUsuarioMal() {
        Integer idUsuario = 1;
        given(usuarioRepositorio.findById(idUsuario)).willReturn(Optional.empty());
        assertThatThrownBy(() -> usuarioServicio.obtenerUsuario(idUsuario)).isInstanceOf(RuntimeException.class);
    }


    /*

    @Test
    void actualizarUsuario() {

        Integer idUsuario = 1;
        Persona pers = new Persona(1, "Pipi", "Farias", "123456789", new Usuario());
        List<Reserva> listReservas = new ArrayList<>();
        Usuario usuarioNuevo = new Usuario(1, "pipifariasc", "pipifariasc@gmail.com", "pipi12345", listReservas, pers);
        pers.setUsuario(usuarioNuevo);

        given(usuarioRepositorio.findById(idUsuario)).willReturn(Optional.of(DatosDummy.getUser()));
        given(usuarioServicio.actualizarUsuario(idUsuario, usuarioNuevo)).willReturn(usuarioNuevo);
        Usuario usuarioActualizado = usuarioServicio.actualizarUsuario(idUsuario, usuarioNuevo);
        ArgumentCaptor<Usuario> usuarioArgumentCaptor = ArgumentCaptor.forClass(Usuario.class);
        verify(usuarioRepositorio).save(usuarioArgumentCaptor.capture());
        assertThat(usuarioActualizado.getContrasenia()).isEqualTo("pipi12345");

    }

    @Test
    void actualizarUsuarioMal() {

        Integer idUsuario = 1;
        Persona pers = new Persona(1, "Pipi", "Farias", "123456789", new Usuario());
        List<Reserva> listReservas = new ArrayList<>();
        Usuario usuarioNuevo = new Usuario(1, "pipifarias", "pipifarias@gmail.com", "pipi12345", listReservas, pers);
        pers.setUsuario(usuarioNuevo);

        given(usuarioRepositorio.findById(idUsuario)).willReturn(Optional.of(DatosDummy.getUser()));

        given(usuarioRepositorio.findById(idUsuario)).willReturn(Optional.of(DatosDummy.getUser()));
        assertThatThrownBy(() -> usuarioServicio.actualizarUsuario(idUsuario,DatosDummy.getUser())).isInstanceOf(RuntimeException.class).hasMessageContaining("Usuario o correo ya registrado");

    }

    @Test
    void actualizarUsuarioNotFound() {
        Integer idUsuario = 3;
        Persona pers = new Persona(1, "Pipi", "Farias", "123456789", new Usuario());
        List<Reserva> listReservas = new ArrayList<>();
        Usuario usuarioNuevo = new Usuario(1, "pipifarias", "pipifarias@gmail.com", "pipi12345", listReservas, pers);
        pers.setUsuario(usuarioNuevo);
        given(usuarioRepositorio.findById(idUsuario)).willReturn(Optional.empty());
        assertThatThrownBy(() -> usuarioServicio.actualizarUsuario(idUsuario,usuarioNuevo)).isInstanceOf(RuntimeException.class).hasMessageContaining("Usuario con el id "  + idUsuario + " no existe");
    }

     */

    @Test
    void eliminarUsuario() {

        Integer idUsuario = 1;

        given(usuarioRepositorio.findById(idUsuario)).willReturn(Optional.of(DatosDummy.getUser()));
        willDoNothing().given(usuarioRepositorio).deleteById(idUsuario);
        usuarioServicio.eliminarUsuario(idUsuario);

        verify(usuarioRepositorio,times(1)).deleteById(any());

    }

    @Test
    void eliminarUsuarioNotFound() {
        Integer idUsuario = 1;

        given(usuarioRepositorio.findById(idUsuario)).willReturn(Optional.empty());

        assertThatThrownBy(() -> usuarioServicio.eliminarUsuario(idUsuario)).isInstanceOf(RuntimeException.class);

    }

    @Test
    void obtenerTodosUsuarios() {

        List<Usuario> listaUsuarios = new ArrayList<>();
        given(usuarioRepositorio.findAll()).willReturn(listaUsuarios);
        usuarioServicio.obtenerTodosUsuarios();

    }

    @Test
    void loginUsuario() {
        Integer idUsuario = 1;
        Persona pers = new Persona(1, "Pipi", "Farias", "123456789", new Usuario());
        List<Reserva> listReservas = new ArrayList<>();
        Usuario usuarioLogin = new Usuario(1, "pipifarias", "pipifarias@gmail.com", "pipi12345", listReservas, pers);
        pers.setUsuario(usuarioLogin);

        given(usuarioRepositorio.findByUsuario(usuarioLogin.getUsuario())).willReturn(Optional.of(DatosDummy.getUser()));
        Usuario usuarioLoginOk = usuarioServicio.loginUsuario(usuarioLogin);

        assertThat(usuarioLoginOk.getContrasenia()).isEqualTo(usuarioLogin.getContrasenia());
        assertThat(usuarioLoginOk.getUsuario()).isEqualTo(usuarioLogin.getUsuario());


    }

    @Test
    void loginUsuarioNotFound() {
        Integer idUsuario = 1;
        Persona pers = new Persona(1, "Pipi", "Farias", "123456789", new Usuario());
        List<Reserva> listReservas = new ArrayList<>();
        Usuario usuarioLogin = new Usuario(1, "pipifarias", "pipifarias@gmail.com", "pipi12345", listReservas, pers);
        pers.setUsuario(usuarioLogin);

        given(usuarioRepositorio.findByUsuario(usuarioLogin.getUsuario())).willReturn(Optional.empty());
        assertThatThrownBy(() -> usuarioServicio.loginUsuario(usuarioLogin)).isInstanceOf(RuntimeException.class);

    }

    @Test
    void loginUsuarioIncorrecto() {

        Integer idUsuario = 1;
        Persona pers = new Persona(1, "Pipi", "Farias", "123456789", new Usuario());
        List<Reserva> listReservas = new ArrayList<>();
        Usuario usuarioLogin = new Usuario(1, "pipixf", "pipifarias@gmail.com", "pipi123456789", listReservas, pers);
        pers.setUsuario(usuarioLogin);

        given(usuarioRepositorio.findByUsuario(usuarioLogin.getUsuario())).willReturn(Optional.of(DatosDummy.getUser()));
        assertThatThrownBy(() -> usuarioServicio.loginUsuario(usuarioLogin)).isInstanceOf(RuntimeException.class);

    }

    @Test
    void correoOUsuarioExiste() {

        String correo = "pipifarias@gmail.com";
        String usuario = "pipifarias";

        given(usuarioRepositorio.findByCorreo(correo)).willReturn(Optional.of(DatosDummy.getUser()));
        given(usuarioRepositorio.findByUsuario(usuario)).willReturn(Optional.of(DatosDummy.getUser()));
        Boolean existeUsuarioporCorreo = usuarioServicio.correoOUsuarioExiste(correo, usuario);
        assertThat(existeUsuarioporCorreo).isTrue();

    }

}