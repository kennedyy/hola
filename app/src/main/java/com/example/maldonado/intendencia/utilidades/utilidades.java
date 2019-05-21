package com.example.maldonado.intendencia.utilidades;

public class utilidades {

    //contantes campos tabala usuarios
    public static final String TABLA_USUARIO  = "usuario";
    public static final String CAMPO_ID  = "id";
    public static final String CAMPO_NOMBRE  = "nombre";
    public static final String CAMPO_APELLIDO  = "apellido";
    public static final String CAMPO_CONTRASENA = "contrasena";
    public static final String CAMPO_AREA = "area";
    public static final String CAMPO_TURNO = "turno";



    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+" " +
            "("+CAMPO_ID+" INTEGER, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_APELLIDO+" TEXT, " +
            ""+CAMPO_CONTRASENA+" TEXT, "+CAMPO_AREA+" TEXT, "+CAMPO_TURNO+" TEXT)";
}
