package com.asj.emcas.datos;

import com.asj.emcas.entidad.Persona;
import com.asj.emcas.entidad.Reserva;
import com.asj.emcas.entidad.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DatosDummy {



    public static Usuario getUser() {
        Persona pers = new Persona(1, "Pipi", "Farias", "123456789", new Usuario());
        List<Reserva> listReservas = new ArrayList<>();
        Usuario usuarioP = new Usuario(1, "pipifarias", "pipifarias@gmail.com", "pipi12345", listReservas, pers);
        pers.setUsuario(usuarioP);
        return usuarioP;

    }



}
