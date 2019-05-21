package com.example.maldonado.intendencia.entidades;

public class rondin {

    private String id;
    private String area;
    private String subArea;
    private String prefecto;
    private String piso;
    private String pizarron;
    private String escritorio;
    private String basura;
    private String banco;

    public rondin(String id, String area, String subArea, String prefecto, String piso, String pizarron, String escritorio, String basura, String banco) {
        this.id = id;
        this.area = area;
        this.subArea = subArea;
        this.prefecto = prefecto;
        this.piso = piso;
        this.pizarron = pizarron;
        this.escritorio = escritorio;
        this.basura = basura;
        this.banco = banco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSubArea() {
        return subArea;
    }

    public void setSubArea(String subArea) {
        this.subArea = subArea;
    }

    public String getPrefecto() {
        return prefecto;
    }

    public void setPrefecto(String prefecto) {
        this.prefecto = prefecto;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getPizarron() {
        return pizarron;
    }

    public void setPizarron(String pizarron) {
        this.pizarron = pizarron;
    }

    public String getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(String escritorio) {
        this.escritorio = escritorio;
    }

    public String getBasura() {
        return basura;
    }

    public void setBasura(String basura) {
        this.basura = basura;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
