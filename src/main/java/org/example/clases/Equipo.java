package org.example.clases;

import org.example.enumeraciones.Resultado;

public class Equipo {
    // zona de variables
    private String nombre;
    private boolean autorizacion=true;
    private Resultado resultadoEnELPartido;
    private int cantGolesEnElTorneo;

    public Equipo() {

    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre, boolean autorizacion, Resultado resultadoEnELPartido, int cantGolesEnElTorneo) {
        this.nombre= nombre;
        this.autorizacion = autorizacion;
        this.resultadoEnELPartido = resultadoEnELPartido;
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Resultado getResultadoEnELPartido() {
        return resultadoEnELPartido;
    }

    public void setResultadoEnELPartido(Resultado resultadoEnELPartido) {
        this.resultadoEnELPartido = resultadoEnELPartido;
    }

    public int getCantGolesEnElTorneo() {
        return cantGolesEnElTorneo;
    }

    public void setCantGolesEnElTorneo(int cantGolesEnElTorneo) {
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }

    public void sumarGolesNuevos(int nuevosGoles){
        this.cantGolesEnElTorneo+=nuevosGoles;
    }
}
