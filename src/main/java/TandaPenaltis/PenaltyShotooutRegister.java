package TandaPenaltis;

public class PenaltyShotooutRegister {

    private Player tirador;
    private Player portero;
    private int goles;
    private int atajadas;

    public PenaltyShotooutRegister(Player tirador, Player portero, int goles, int atajadas) {
        this.tirador = tirador;
        this.portero = portero;
        this.goles = goles;
        this.atajadas = atajadas;
    }

    public Player getTirador() {
        return tirador;
    }

    public Player getPortero() {
        return portero;
    }

    public int getGoals() {
        return goles;
    }

    public int getAtajadas() {
        return atajadas;
    }

    public void setTirador(Player tirador) {
        this.tirador = tirador;
    }

    public void setPortero(Player portero) {
        this.portero = portero;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public void setatajadas(int atajadas) {
        this.atajadas = atajadas;
    }
}
