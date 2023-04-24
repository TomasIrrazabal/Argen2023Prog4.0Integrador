package org.example.clases;
import javax.swing.*;
import java.util.List;
public class Jugador {
    // zona de variables
    public Equipo equipoSeleccionado;
    private int puntaje=0;

    public Jugador() {
    }

    public Jugador(Equipo equipoSeleccionado, int puntaje) {
        this.equipoSeleccionado = equipoSeleccionado;
        this.puntaje = puntaje;
    }

    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }

    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void elegirEquipo(List<Equipo>listaEquipos){
        //Muestro la lista de equipos
        String listaDeLosEquiposEnMensaje= "Seleccione su equipo: \n";
        for (int i = 0; i < listaEquipos.size(); i++) {
            listaDeLosEquiposEnMensaje+=(i+1)+". "+listaEquipos.get(i).getNombre()+"\n";
        }
        JOptionPane.showMessageDialog(null,listaDeLosEquiposEnMensaje,"Seleccion de Equipo",JOptionPane.INFORMATION_MESSAGE);
        int indiceEquipo=0;

        //menu para seleccion de equipo
        do{
        indiceEquipo=Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingrese el indice del equipo que quiere seleccionar:",
                "Ingreso valor",JOptionPane.INFORMATION_MESSAGE))-1;

        }while(indiceEquipo<0||indiceEquipo>8);
        JOptionPane.showMessageDialog(null,"El equipo que elegiste es: "
                + listaEquipos.get(indiceEquipo).getNombre());
        this.equipoSeleccionado=listaEquipos.get(indiceEquipo);
    }
    public void sumarPuntos(){
        if(equipoSeleccionado.isAutorizacion()==true)
            puntaje+=1;
    }


    
}
