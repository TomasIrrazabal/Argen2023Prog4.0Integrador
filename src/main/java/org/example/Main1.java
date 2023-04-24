package org.example;

import org.example.clases.Equipo;
import org.example.clases.Jugador;
import org.example.clases.Llave;
import org.example.clases.Ronda;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main1 {
public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"¡Bienvenido al Torneo!",
               "Bienvenida",JOptionPane.INFORMATION_MESSAGE);

        menu();

    }
    // Metodo menu
public static void mostrarOpciones(){
        JOptionPane.showMessageDialog(null,"Selecione una opción:\n"+
                "1. Crear lista de equipos \n"+
                "2. Cargar los equipos\n"+
                "3. Eligir equipo\n"+
                "4. Crear llave Derecha\n"+
                "5. Crear llave Izquierda\n"+
                "6. Crear rondas \n"+
                "7. Jugar el torneo\n"+
                "8. Mostrar resultado del torneo\n"+
                "0. Salir", "Opciones",JOptionPane.INFORMATION_MESSAGE);
    }
public static void menu(){
        JOptionPane.showMessageDialog(null,"¡Bienvenido al menu!\n" +
                "Selecciona una de las siguientes opciones:","Menú",JOptionPane.INFORMATION_MESSAGE);

        //Se inicializan las variables que se utilizarán durante la ejecución del programa.
                boolean salir = true;
                ArrayList<Equipo> listaDeEquipos = null;
                Jugador jugador = null;
                Llave llaveDerecha = null;
                Llave llaveIzquierda = null;
                Ronda ronda =null;
                String opcion = " ";
        do{
            //llamo al metodo "mostrarOpciones()" para mostrar las opciones disponibles
            mostrarOpciones();
            opcion = JOptionPane.showInputDialog(null,
                    "Ingrese la opcion : ","Ingreso opcion",JOptionPane.INFORMATION_MESSAGE);

            switch (opcion){
                case "1":
                    listaDeEquipos = crearListaDeEquipos(listaDeEquipos);
                    break;
                case "2":
                    agregarEquipos(listaDeEquipos);
                    break;
                case "3":
                    jugador = elegirEquipo(listaDeEquipos);
                        break;
                case "4":
                    llaveDerecha = crearLlaveDerecha(listaDeEquipos);
                    break;
                case "5":
                    llaveIzquierda = crearLlaveIzquierda(listaDeEquipos);
                    break;
                case "6":
                    ronda = crearRondas();
                    break;
                case "7":
                    jugarTorneo(ronda, llaveDerecha,llaveIzquierda,jugador);
                    break;
                case "8":
                    resultadoDelTorneo(jugador);
                    break;
                case "0":
                    salir =false;
                    JOptionPane.showMessageDialog(null, "Finalizando el programa","Salir",JOptionPane.INFORMATION_MESSAGE);
                default:

                    break;
            }

        }while(salir == true);


    }
    // Metodo para reservar espacio de memoria para los equipos que jugaran el torneo
public static ArrayList<Equipo> crearListaDeEquipos(ArrayList<Equipo> listaDeEquipos){
    JOptionPane.showMessageDialog(null,"Se crearon los equipos.");
    //Creo una nueva ArrayList
    ArrayList<Equipo>listaDeEquipo =new ArrayList<>();
    return listaDeEquipo;
}
    // Metodo para agregar los equipos a una lista
public static void agregarEquipos(ArrayList<Equipo> listaDeEquipos){
    String opcionAgregarEquipos= JOptionPane.showInputDialog(null,"¿Quiere cargar los equipos a mano?\n"+
            " SI/NO","Ingreso de equipos",JOptionPane.INFORMATION_MESSAGE);
    opcionAgregarEquipos=opcionAgregarEquipos.toUpperCase();

    // Se le da la opcion al usuario de cargar los equipos "a mano" o usar unos predefinidos
    if (opcionAgregarEquipos.equals("SI")){
        //cargo "listaDeEquipos" y luego lo imprimo por pantalla
        for (int i = 0; i <8 ; i++) {
            JOptionPane.showMessageDialog(null,"Ingrese el nombre del equipo N°"+(i+1)+" equipo:",
                    "Ingreso de equipos",JOptionPane.INFORMATION_MESSAGE);
            Equipo equipoAuxiliar= new Equipo(JOptionPane.showInputDialog(null, "",
                    "Ingreso de equipo",JOptionPane.INFORMATION_MESSAGE));
            listaDeEquipos.add(equipoAuxiliar);
        }
        String listaDeLosEquiposEnMensaje= "Los equipos cargados son: \n";
        for (int j = 0; j < listaDeEquipos.size(); j++) {

            listaDeLosEquiposEnMensaje += (j + 1) + ". " + listaDeEquipos.get(j).getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null,listaDeLosEquiposEnMensaje,"Equipos cargados",JOptionPane.INFORMATION_MESSAGE);
    }else if (opcionAgregarEquipos.equals("NO")) {

        //Hardcodeo los equipos por peticion del usuario
        Equipo e1 = new Equipo("Belgica");
        Equipo e2 = new Equipo("Francia");
        Equipo e3 = new Equipo("Portugal");
        Equipo e4 = new Equipo("Brasil");
        Equipo e5 = new Equipo("Italia");
        Equipo e6 = new Equipo("Argelia");
        Equipo e7 = new Equipo("Alemania");
        Equipo e8 = new Equipo("Argentina");

        //agrego los equipos al Arraylist "listaDeEquipos"
        listaDeEquipos.add(e1);
        listaDeEquipos.add(e2);
        listaDeEquipos.add(e3);
        listaDeEquipos.add(e4);
        listaDeEquipos.add(e5);
        listaDeEquipos.add(e6);
        listaDeEquipos.add(e7);
        listaDeEquipos.add(e8);

        //muestro por pantalla los equipos cargados
        String listaDeLosEquiposEnMensaje= "Los equipos cargados son: \n";
        for (int i = 0; i < listaDeEquipos.size(); i++) {
            listaDeLosEquiposEnMensaje += (i + 1) + ". " + listaDeEquipos.get(i).getNombre() + "\n";

        }
        JOptionPane.showMessageDialog(null,listaDeLosEquiposEnMensaje,"Equipos cargados",JOptionPane.INFORMATION_MESSAGE);
    }else{
        JOptionPane.showMessageDialog(null,"La opcion seleccionada es erronea","Error",JOptionPane.INFORMATION_MESSAGE);
    }
}

    // Metodo para crear un jugador y que este use el metodo "elegirEquipo"
public static Jugador elegirEquipo(ArrayList<Equipo>listaDeEquipos){
        // Creo un objeto tipo "Jugador"
        Jugador jugador =new Jugador();
        //Uso el metodo "jugador.elegirEquipo"
        jugador.elegirEquipo(listaDeEquipos);
        return jugador;
}
    // Metodo para crear un objeto tipo llave para el toneo "izquierda"
public static Llave crearLlaveDerecha(ArrayList<Equipo> listaDeEquipos){
        Llave llaveDerecha = new Llave();
        llaveDerecha.armarLlave(listaDeEquipos,0);
        return llaveDerecha;
}
    // Metodo para crear un objeto tipo llave para el toneo "izquierda"
public static Llave crearLlaveIzquierda(ArrayList<Equipo> listaDeEquipos) {
    Llave llaveIzquierda = new Llave();
    llaveIzquierda.armarLlave(listaDeEquipos, 4);
    return llaveIzquierda;
}
    // Metodo para crear un objeto tipo Ronda.
public static Ronda crearRondas(){
        Ronda ronda =new Ronda();
        return ronda;
}
    // Metodo para ejecutar el torneo.
public static void jugarTorneo(Ronda ronda,Llave llaveDerecha,Llave llaveIzquierda,Jugador jugador){
        //creo los "cuartos de final"
        ronda.cuartosDeFinal(llaveDerecha,llaveIzquierda);

        jugador.sumarPuntos();

        //creo las "semifinales"
        ronda.semiFinal(llaveDerecha,llaveIzquierda);

        jugador.sumarPuntos();

        //creo la "final"1
        ronda.finalDelTorneo(llaveDerecha,llaveIzquierda);

        jugador.sumarPuntos();
        return ;
}
    // Metodo para mostrar el resultado del equipo seleccionado al usuario
public static void resultadoDelTorneo(Jugador jugador){
    JOptionPane.showMessageDialog(null,"Los puntos totales del equipo: "+jugador.getEquipoSeleccionado().getNombre()+"\n son:"+
            jugador.getPuntaje(),"Resultado",JOptionPane.INFORMATION_MESSAGE);
}


}

