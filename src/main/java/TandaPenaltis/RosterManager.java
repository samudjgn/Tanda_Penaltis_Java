package TandaPenaltis;

import java.util.HashMap;

public class RosterManager {
    private HashMap<Integer, Player> roster = new HashMap<>();

    public void addPlayer(Player player){
        roster.put(player.getnumberShirt(), player);
    }

    public Player searchPlayer(int dorsalBusqueda){
        return roster.get(dorsalBusqueda);
    }
}
