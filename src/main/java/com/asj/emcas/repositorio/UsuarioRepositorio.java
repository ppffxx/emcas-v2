package com.asj.emcas.repositorio;

import com.asj.emcas.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

        Optional<Usuario> findByCorreo(String correo);
        Optional<Usuario> findByUsuario(String usuario);

}
