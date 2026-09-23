/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package TandaPenaltis;
import Database.ConexionDB;
import Dominio.PenaltyShotooutSimulator;

import java.util.ArrayList;

/**
 *
 * @author samuito
 */
public class Main {

    public static void main(String[] args) {

        ConexionDB.getConnection();

        ConsoleUI console = new ConsoleUI();

        Player myStriker = console.requestPlayerData("Striker");

        Player myMidfielder = console.requestPlayerData("Midfielder");

        Player myGoalkeeper = console.requestPlayerData("Goalkeeper");

        ArrayList<PenaltyShotooutRegister> matchHistory = new ArrayList<>();

        boolean keepPlaying;

        RosterManager roster = new RosterManager();

        roster.addPlayer(myStriker);
        roster.addPlayer(myMidfielder);
        roster.addPlayer(myGoalkeeper);

        do {

            int dorsalPicked = console.RequestJerseyNumber();
            Player bestKicker = roster.searchPlayer(dorsalPicked);
            String nameKicker;

            if (bestKicker != null) {
                System.out.println("El DT ha escogido a " + bestKicker.getName() + " para patear el penalti!!");
            } else {
                System.out.println("¡Dorsal no encontrado! Por defecto, el Striker " + myStriker.getName() + " tomará la responsabilidad.");
                bestKicker = myStriker;
            }

            PenaltyShotooutSimulator referee = new PenaltyShotooutSimulator();

            PenaltyShotooutRegister finalRecord = referee.runPenaltyShotoout(bestKicker, myGoalkeeper);

            matchHistory.add(finalRecord);

            int firstgameGoals = matchHistory.get(0).getGoals();

            System.out.println("Los goles del primer juego fueron: " + firstgameGoals);

            keepPlaying = console.askAnotherRound();

        }while(keepPlaying);
    } 
}

