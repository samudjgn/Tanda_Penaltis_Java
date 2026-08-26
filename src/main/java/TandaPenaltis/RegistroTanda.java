package TandaPenaltis;

public class RegistroTanda {

    private Jugador tirador;
    private Jugador portero;
    private int goles;
    private int atajadas;

    public RegistroTanda(Jugador tirador, Jugador portero, int goles, int atajadas) {
        this.tirador = tirador;
        this.portero = portero;
        this.goles = goles;
        this.atajadas = atajadas;
    }

    public Jugador getTirador() {
        return tirador;
    }

    public Jugador getPortero() {
        return portero;
    }

    public int getGoles() {
        return goles;
    }

    public int getAtajadas() {
        return atajadas;
    }

    public void setTirador(Jugador tirador) {
        this.tirador = tirador;
    }

    public void setPortero(Jugador portero) {
        this.portero = portero;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public void setatajadas(int atajadas) {
        this.atajadas = atajadas;
    }
}
