package com.asj.emcas.repositorio;

import com.asj.emcas.datos.DatosDummy;
import com.asj.emcas.entidad.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class UsuarioRepositorioTest {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @BeforeEach
    void setUp() {
        usuarioRepositorio.save(DatosDummy.getUser());
    }

    @AfterEach
    void tearDown() {
        usuarioRepositorio.deleteAll();
    }

    @Test
    void findByCorreo() {
        Optional<Usuario> optionalUsuario = this.usuarioRepositorio.findByCorreo("pipifarias@gmail.com");
        assertThat(optionalUsuario.isPresent()).isTrue();
        assertThat(optionalUsuario.get().getCorreo()).isEqualTo("pipifarias@gmail.com");
    }

    @Test
    void findByUsuario() {
        Optional<Usuario> optionalUsuario = this.usuarioRepositorio.findByUsuario("pipifarias");
        assertThat(optionalUsuario.isPresent()).isTrue();
        assertThat(optionalUsuario.get().getUsuario()).isEqualTo("pipifarias");
    }
}