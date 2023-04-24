package org.example.clases;

import org.example.enumeraciones.Resultado;

import javax.swing.*;

public class Partido {
    // zona de variables
    private int golesEquipoLocal=0;
    private int golesEquipoVisitante=0;



    public Partido() {
    }

    public Partido(int golesEquipoLocal, int golesEquipoVisitante) {
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    public Equipo simularPartido(Equipo equipoLocal,Equipo equipoVisitante){

        // Agregue un bucle DoWhile ya que si los equipos enpataban, se repite el partido, pero aveces ocupababa el
        // lugar de otro y daba un resultado erroneo

        do {
        //Hago que los resultados de los partidos sean aleatorios
        golesEquipoLocal= (int)(Math.random()*10+1);
        golesEquipoVisitante= (int)(Math.random()*10+1);


        //Muestro mensaje con el resultado del partido
        JOptionPane.showMessageDialog(null,equipoLocal.getNombre()+ " "+this.golesEquipoLocal+" - "
                +this.golesEquipoVisitante+equipoVisitante.getNombre(),"Resultado",JOptionPane.INFORMATION_MESSAGE );

        //le suma los goles a los equipos
        equipoLocal.sumarGolesNuevos(this.golesEquipoLocal);
        equipoVisitante.sumarGolesNuevos(this.golesEquipoVisitante);

        //logica del partido

        if(this.golesEquipoLocal>this.golesEquipoVisitante){
            equipoVisitante.setAutorizacion(false);
            equipoVisitante.setResultadoEnELPartido(Resultado.PERDEDOR);
            equipoLocal.setResultadoEnELPartido(Resultado.GANADOR);
            /*JOptionPane.showMessageDialog(null,"Gano "+equipoLocal.getNombre(),
                    "Resultado",JOptionPane.INFORMATION_MESSAGE);*/
            return equipoLocal;
        }else if(
                this.golesEquipoVisitante>this.golesEquipoLocal){
            equipoLocal.setAutorizacion(false);
            equipoVisitante.setResultadoEnELPartido(Resultado.GANADOR);
            equipoLocal.setResultadoEnELPartido(Resultado.PERDEDOR);
            /*JOptionPane.showMessageDialog(null,"Gano "+equipoVisitante.getNombre(),
                    "Resultado",JOptionPane.INFORMATION_MESSAGE);*/

            return equipoVisitante;
        }else{

                JOptionPane.showMessageDialog(null, "Se jugara el desempate entre " + equipoLocal.getNombre() +
                        " - " + equipoVisitante.getNombre());
                equipoLocal.setResultadoEnELPartido(Resultado.EMPATE);
                equipoVisitante.setResultadoEnELPartido(Resultado.EMPATE);
                simularPartido(equipoLocal, equipoVisitante);

        }
        }while (equipoLocal.isAutorizacion()&&equipoVisitante.isAutorizacion());

        return null;
    }
}
