/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package TandaPenaltis;
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




            HashMap<Integer, Jugador> plantillaEquipo = new HashMap<>();
            
            plantillaEquipo.put(dorsalDelantero, miDelantero);
            plantillaEquipo.put(dorsalMediocampista, miMediocampista);
            plantillaEquipo.put(dorsalArquero, miArquero);
    
            System.out.println("-------------------------------------------------------------");
            System.out.println("----------------EL DT DEBE ESCOGER AL COBRADOR---------------");
            System.out.println("-------------------------------------------------------------");
            
            System.out.println("Dorsales disponibles: ");
            System.out.println("Delantero: "+ miDelantero.getNombre()+". Con el dorsal: #"+ dorsalDelantero);
            System.out.println("Mediocampista: "+ miMediocampista.getNombre()+". Con el dorsal: #"+dorsalMediocampista);
            
            System.out.println("Digite el dorsal del jugador que va a patear: ");
            int dorsalElegido = sc.nextInt();
            sc.nextLine();
            
            Jugador mejorTirador = plantillaEquipo.get(dorsalElegido);
            String nombreTirador;
            
            if(mejorTirador != null){
                nombreTirador = mejorTirador.getNombre(); 
                System.out.println("El DT ha escogido a "+nombreTirador+" para patear el penalti!!");
            }   else{
                System.out.println("¡Dorsal no encontrado! Por defecto, el Delantero " + nombreDelantero + " tomará la responsabilidad.");
                mejorTirador = miDelantero;
                nombreTirador = nombreDelantero;
            }
           
            int goles=0;
            int atajadas=0;
            int palos = 0;
            
        for(int i = 1; i<=5; i++){
            
            System.out.println("Cobro "+i+"!!");
            
            int poderShotFinal = mejorTirador.ejecutarAccion();
            int poderAtajadaFinal = miArquero.ejecutarAccion(); 
            
            if(poderShotFinal>poderAtajadaFinal){
                System.out.println("GOOOL DE "+nombreTirador+"!!");
                goles++;
                
                mejorTirador.celebrarExito();
                miArquero.lamentarFracaso();
            }else if(poderShotFinal<poderAtajadaFinal){
                System.out.println("ATAJADON DE "+nombreArquero+"!!" );
                atajadas++;
                
                miArquero.celebrarExito();
                mejorTirador.lamentarFracaso();
            }else{
                System.out.println("Palo!!");
                palos++;
                
                mejorTirador.lamentarFracaso();
            }
        }
        
            System.out.println("\n--- RESULTADOS ---");
            System.out.println("Goles: " + goles + " | Atajadas: " + atajadas + " | Palos: " + palos);
            
                    if (goles > atajadas) {
                System.out.println("¡Gana el pateador!");
            } else if (atajadas > goles) {
                System.out.println("¡Gana el Arquero!");
            } else {
                System.out.println("¡Es un empate!");
            }
        
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

