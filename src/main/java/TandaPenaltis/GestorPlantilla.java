package TandaPenaltis;

import java.util.HashMap;

public class GestorPlantilla {
    private HashMap<Integer, Jugador> plantilla = new HashMap<>();

    public void agregarJugador(Jugador jugador){
        plantilla.put(jugador.getnumeroCamiseta(), jugador);
    }

    public Jugador buscarJugador(int dorsalBusqueda){
        return plantilla.get(dorsalBusqueda);
    }
}
