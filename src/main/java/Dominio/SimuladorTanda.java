package Dominio;

import TandaPenaltis.Jugador;
import TandaPenaltis.RegistroTanda;

public class SimuladorTanda {

    public RegistroTanda ejecutarTanda (Jugador tirador, Jugador portero){
        int goles=0;
        int atajadas=0;
        int palos = 0;

        String nombreTirador = tirador.getNombre();
        String nombrePortero = portero.getNombre();

        for(int i = 1; i<=5; i++){

            System.out.println("Cobro "+i+"!!");

            int poderShotFinal = tirador.ejecutarAccion();
            int poderAtajadaFinal = portero.ejecutarAccion();

            if(poderShotFinal>poderAtajadaFinal){
                System.out.println("GOOOL DE "+nombreTirador+"!!");
                goles++;

                tirador.celebrarExito();
                portero.lamentarFracaso();
            }else if(poderShotFinal<poderAtajadaFinal){
                System.out.println("ATAJADON DE "+nombrePortero+"!!" );
                atajadas++;

                portero.celebrarExito();
                tirador.lamentarFracaso();
            }else{
                System.out.println("Palo!!");
                palos++;

                tirador.lamentarFracaso();
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

        RegistroTanda recibo = new RegistroTanda(tirador, portero, goles, atajadas);

        return recibo;
    }
}
