package com.example.proyectoSura.utilidades;

public enum Enum {
    ERROR_REGISTRO("Error inesperado en el registro"),
    AFILIADO_INEXISTENTE("El afiliado no existe en nuestra base de datos"),
    EXAMEN_INEXISTENTE("El examen consultado no existe en nuestra base de datos"),
    SIGNO_INEXISTENTE("El signo consultado no existe en nuestra base de datos"),
    ERROR_EN_CONSULTA("Se produjo un error al realizar la consulta en nuestra base de datos"),

    ;

    private String Mensaje;

    Enum(String mensaje) {
        Mensaje = mensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }
}
