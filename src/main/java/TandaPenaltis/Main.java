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
           

        
        int habilidad = 0;
        boolean datoCorrecto = false;
        
        while(!datoCorrecto){
            try {
               System.out.print("Introduzca la habilidad");
               sc.nextInt();
               datoCorrecto = true;
            } catch (InputMismatchException e){
                System.out.println("Error, por favor introduzca solo numeros");
                sc.nextLine();
            }
        }
        
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        
        Delantero nuevoDelantero = new Delantero(nombreDelantero, dorsalDelantero, habilidadDelantero);
 
        listaJugadores.add(nuevoDelantero);
        
        Delantero james = new Delantero("James Rodriguez", 10, 90);
        Delantero messi = new Delantero("Lionel Messi", 10, 96);
        Delantero cr7 = new Delantero("Cristiano Ronaldo", 7, 97);
        Delantero neymar = new Delantero("Neymar Junior", 11, 94);
        Delantero vinijr = new Delantero("Vinicius Junior", 7, 93);
        
        listaJugadores.add(james);
        listaJugadores.add(messi);
        listaJugadores.add(cr7);
        listaJugadores.add(neymar);
        listaJugadores.add(vinijr);        
        
        int length = listaJugadores.size();
        


        // Primer bucle: recorre la lista desde el inicio hasta el final
        for (int i = 0; i < length - 1; i++) {

            // Segundo bucle: recorre los elementos que están *después* de i
            for (int j = i + 1; j < length; j++) {

                // 👉 AQUÍ VA TU MAGIA: 
                // 1. Obtén el jugador en 'i' y el jugador en 'j' usando .get()
                Jugador jugadorPresente = listaJugadores.get(i);
                Jugador jugadorSiguiente = listaJugadores.get(j);
                // 2. Compara sus niveles de habilidad (queremos ordenar de MAYOR a menor)
                if(jugadorSiguiente.getnivelHabilidad() > jugadorPresente.getnivelHabilidad()){
                    Jugador temp = jugadorPresente;
                    
                    listaJugadores.set(i, jugadorSiguiente);
                    
                    listaJugadores.set(j, temp);
                }
                // 3. Si el de 'j' es mayor que el de 'i', haz el intercambio usando .set(...)
                
            }
        }
        
        System.out.println("Jugadores registrados :");
        for (Jugador j : listaJugadores) {
            System.out.println("- " + j.getNombre());
        }
        
    } 
}

