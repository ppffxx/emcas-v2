package com.asj.emcas.controlador;


import com.asj.emcas.dto.UsuarioDTO;
import com.asj.emcas.dto.UsuarioSinIdDTO;
import com.asj.emcas.entidad.Usuario;
import com.asj.emcas.mapper.UsuarioMapper;
import com.asj.emcas.servicio.UsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {


    private final UsuarioServicio usuarioServicio;
    private final UsuarioMapper usuarioMapper;

    public UsuarioControlador(UsuarioServicio usuarioServicio, UsuarioMapper usuarioMapper) {
        this.usuarioServicio = usuarioServicio;
        this.usuarioMapper = usuarioMapper;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuario(@PathVariable Integer id) {

        try {
            Usuario usuario = usuarioServicio.obtenerUsuario(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuario);
        }

        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

    }

    @GetMapping("/todos")
    public ResponseEntity<?> obtenerTodos() {
        List<Usuario> usuariosTodos = usuarioServicio.obtenerTodosUsuarios();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuariosTodos);
    }



    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioSinIdDTO usuarioSinIdDTO) {

        try {
            Usuario usuario = usuarioMapper.UsuarioDTORegistroToUsuarioEntity(usuarioSinIdDTO);
            Usuario usuarioN = usuarioServicio.crearUsuario(usuario);
            UsuarioDTO temp = usuarioMapper.UsuarioEntityToUsuarioDTO(usuarioN);
            return ResponseEntity.status(HttpStatus.CREATED).body(temp);
        }

        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }

    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Integer idUsuario, @RequestBody UsuarioSinIdDTO usuarioSinIdDTO) {

        try {
            Usuario usuarioTemp = usuarioMapper.UsuarioDTORegistroToUsuarioEntity(usuarioSinIdDTO);
            Usuario usActualizado = usuarioServicio.actualizarUsuario(idUsuario, usuarioTemp);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usActualizado);

        }
        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Integer idUsuario) {
        try {
            usuarioServicio.eliminarUsuario(idUsuario);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

    }

}
