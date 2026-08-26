/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package TandaPenaltis;
import Dominio.SimuladorTanda;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.HashMap;

/**
 *
 * @author samuito
 */
public class Main {

    public static void main(String[] args) {

        InterfazConsola consola = new InterfazConsola();

        Jugador miDelantero = consola.pedirDatosJugador("Delantero");

        Jugador miMediocampista = consola.pedirDatosJugador("Mediocampista");

        Jugador miArquero = consola.pedirDatosJugador("Arquero");


        GestorPlantilla plantilla = new GestorPlantilla();

        plantilla.agregarJugador(miDelantero);
        plantilla.agregarJugador(miMediocampista);
        plantilla.agregarJugador(miArquero);

            int dorsalElegido = consola.pedirDorsalJugador();
            Jugador mejorTirador = plantilla.buscarJugador(dorsalElegido);
            String nombreTirador;
            
            if(mejorTirador != null){
                System.out.println("El DT ha escogido a "+mejorTirador.getNombre()+" para patear el penalti!!");
            }   else{
                System.out.println("¡Dorsal no encontrado! Por defecto, el Delantero " + miDelantero.getNombre() + " tomará la responsabilidad.");
                mejorTirador = miDelantero;
            }

            SimuladorTanda arbitro = new SimuladorTanda();
            arbitro.ejecutarTanda(mejorTirador, miArquero);

    } 
}

