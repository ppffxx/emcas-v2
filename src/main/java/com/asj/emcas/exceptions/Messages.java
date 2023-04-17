package com.asj.emcas.exceptions;

public class Messages {
    public static String getMessage(String type, Integer Id) {
        return ""+ type + " con el id " + Id + " no existe";
    }
    public static String getGenMessage() {
        return "Error al realizar la operacion con los datos";
    }
}
