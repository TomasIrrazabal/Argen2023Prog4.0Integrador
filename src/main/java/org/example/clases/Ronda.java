package org.example.clases;

import javax.swing.*;
import java.util.List;

public class Ronda {
    // zona de variables

    private int nroDeRonda;
    private int cantidadDeEquiposEnRonda;
    private int cantidadDeEquiposEnLlave;
    private String equipoGanador="";



    public Ronda() {
    }

    public Ronda(int nroDeRonda, int cantidadDeEquiposEnRonda, int cantidadDeEquiposEnLlave) {
        this.nroDeRonda = nroDeRonda;
        this.cantidadDeEquiposEnRonda = cantidadDeEquiposEnRonda;
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }


    public int getNroDeRonda() {
        return nroDeRonda;
    }

    public void setNroDeRonda(int nroDeRonda) {
        this.nroDeRonda = nroDeRonda;
    }

    public int getCantidadDeEquiposEnRonda() {
        return cantidadDeEquiposEnRonda;
    }

    public void setCantidadDeEquiposEnRonda(int cantidadDeEquiposEnRonda) {
        this.cantidadDeEquiposEnRonda = cantidadDeEquiposEnRonda;
    }

    public int getCantidadDeEquiposEnLlave() {
        return cantidadDeEquiposEnLlave;
    }

    public void setCantidadDeEquiposEnLlave(int cantidadDeEquiposEnLlave) {
        this.cantidadDeEquiposEnLlave = cantidadDeEquiposEnLlave;
    }


    public void cuartosDeFinal(Llave llaveIzquierda, Llave llaveDerecha){
            //seteo el numero de ronda
            this.nroDeRonda = 1;

            //Setea la cantidad de equipos en llave como 4.
            this.cantidadDeEquiposEnLlave = 4;

            //Instancio un objeto de partido para usa su metodo
            Partido partido = new Partido();

            //Muestro mensaje por pantalla de bienvenida a la ronda "cuartos"
            JOptionPane.showMessageDialog(null, "Se jugaran los cuartos de final",
                    "Cuartos", JOptionPane.INFORMATION_MESSAGE);

            //Simulo los partidos
            for (int i = 0; i < cantidadDeEquiposEnLlave; i += 2) {
                partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(i),
                        llaveIzquierda.getEquiposDeLaLlave().get(i + 1));
                partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(i),
                        llaveDerecha.getEquiposDeLaLlave().get(i + 1));
            }
            removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
            removerEquipos(llaveDerecha.getEquiposDeLaLlave());
        //Setear la cantidad actual de equipos por llave
        this.cantidadDeEquiposEnLlave=2;
    }
    //Remuevo los equipos que perdieron
    public void removerEquipos(List<Equipo> equipos){
        int contadorEquiposPorLlave = cantidadDeEquiposEnLlave;
        for(int i=0; i<contadorEquiposPorLlave;i++){
            Equipo auxiliar =equipos.get(i);
            if(!auxiliar.isAutorizacion()){
                 equipos.remove(auxiliar);
                 contadorEquiposPorLlave--;
            }
        }
    }
    public void semiFinal(Llave llaveDerecha,Llave llaveIzquierda){

            //seteo el numero de ronda
            this.nroDeRonda = 2;

            //Setea la cantidad de equipos en llave como 2.
            this.cantidadDeEquiposEnLlave = 2;

            //Instancio un objeto de partido para usa su metodo
            Partido partido = new Partido();

            //Muestro un mensaje de bienvenida a las semifinales
            JOptionPane.showMessageDialog(null, "Se jugaran las semifinales ",
                    "Semifinales", JOptionPane.INFORMATION_MESSAGE);

            //simular los partidos
            partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(0), llaveIzquierda.getEquiposDeLaLlave().get(1));
            partido.simularPartido(llaveDerecha.getEquiposDeLaLlave().get(0), llaveDerecha.getEquiposDeLaLlave().get(1));
            //Removemos a los perdedores
            removerEquipos(llaveDerecha.getEquiposDeLaLlave());
            removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
    }
    public void finalDelTorneo(Llave llaveDerecha, Llave llaveIzquierda){

            //seteo el numero de ronda
            this.nroDeRonda = 3;

            //Setea la cantidad de equipos en llave como 1.
            this.cantidadDeEquiposEnLlave = 1;

            //Muestro un mensaje de bienvenida a las semifinales
            JOptionPane.showMessageDialog(null, "Se jugara la final ",
                    "Final", JOptionPane.INFORMATION_MESSAGE);

            //Instancio un objeto de partido para usa su metodo
            Partido partido = new Partido();

            //simular el partido final
            Equipo equipo = partido.simularPartido(llaveIzquierda.getEquiposDeLaLlave().get(0),
                    llaveDerecha.getEquiposDeLaLlave().get(0));
            //remuevo al perdedor para cerrar el bucle
            removerEquipos(llaveDerecha.getEquiposDeLaLlave());
            removerEquipos(llaveIzquierda.getEquiposDeLaLlave());

            //Muestro un mensaje mostrando quien gano el torneo
            JOptionPane.showMessageDialog(null,"El ganador del torneo es: "+ equipo.getNombre(),
                    "Ganador",JOptionPane.INFORMATION_MESSAGE);
            //Muestro la cantidad de goles del equipo ganador
            JOptionPane.showMessageDialog(null,"La cantidad de goles, de el equipo ganador en el torneo fueron: "
                            + equipo.getCantGolesEnElTorneo(),
                    "Cantidad de Goles",JOptionPane.INFORMATION_MESSAGE);
    }
}
