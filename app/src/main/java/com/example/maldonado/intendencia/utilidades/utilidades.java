package com.example.maldonado.intendencia.utilidades;

public class utilidades {

    //constantes campos tabala usuarios
    public static final String TABLA_USUARIO  = "usuario";
    public static final String CAMPO_ID  = "id";
    public static final String CAMPO_NOMBRE  = "nombre";
    public static final String CAMPO_APELLIDO  = "apellido";
    public static final String CAMPO_CONTRASENA = "contrasena";
    public static final String CAMPO_AREA = "area";
    public static final String CAMPO_TURNO = "turno";

    //constantes de la tabla rondin
    public static final String TABLA_RONDIN  = "rondin";
    public static final String RONDIN_ID  = "id";
    public static final String RONDIN_AREA  = "area";
    public static final String RONDIN_SUBAREA  = "subarea";
    public static final String RONDIN_PREFECTO = "prefecto";
    public static final String RONDIN_PISO  = "piso";
    public static final String RONDIN_PIZARRON  = "pizarron";
    public static final String RONDIN_ESCRITORIO  = "escritrio";
    public static final String RONDIN_BASURA  = "basura";
    public static final String RONDIN_BANCO  = "banco";



    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+TABLA_USUARIO+" " +
            "("+CAMPO_ID+" INTEGER, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_APELLIDO+" TEXT, " +
            ""+CAMPO_CONTRASENA+" TEXT, "+CAMPO_AREA+" TEXT, "+CAMPO_TURNO+" TEXT)";

    public static final String CREAR_TABLA_RONDIN = "CREATE TABLE "+TABLA_RONDIN+" " +
            "("+RONDIN_ID+" TEXT, "+RONDIN_AREA+" TEXT, "+RONDIN_SUBAREA+" TEXT, " +
            ""+RONDIN_PREFECTO+" TEXT, "+RONDIN_PISO+" TEXT, "+RONDIN_PIZARRON+" TEXT, " +
            ""+RONDIN_ESCRITORIO+" TEXT, "+RONDIN_BASURA+" TEXT, "+RONDIN_BANCO+" TEXT)";
}
