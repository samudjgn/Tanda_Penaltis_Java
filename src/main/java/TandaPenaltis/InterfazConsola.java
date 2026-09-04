package TandaPenaltis;

import java.util.Scanner;

public class InterfazConsola {

    private Scanner sc = new Scanner(System.in);

    public Jugador pedirDatosJugador(String nombrePosicion){

        System.out.println("Ingrese el nombre del "+nombrePosicion);
        String nombre = sc.nextLine();

        System.out.println("Ingrese el dorsal del "+nombrePosicion);
        int dorsal = sc.nextInt();

        System.out.println("Ingrese el nivel de habilidad del "+nombrePosicion);
        int habilidad = sc.nextInt();

        sc.nextLine();

        if (nombrePosicion.equalsIgnoreCase("Delantero")) {
            return new Delantero(nombre, dorsal, habilidad);
        }else if(nombrePosicion.equalsIgnoreCase("Mediocampista")){
            return new Mediocampista(nombre, dorsal, habilidad);
        }else{
            return new Arquero(nombre, dorsal, habilidad);
        }
    }

    public int pedirDorsalJugador(){

        System.out.println("Digite el dorsal del jugador que va a patear: ");

        return sc.nextInt();
    }

    public boolean preguntaOtraTanda (){
        System.out.println("¿Desea jugar de nuevo? Ingrese (S/N)");
        String respuesta = sc.next();

        return respuesta.equalsIgnoreCase("S");
    }
}
