package TandaPenaltis;


import Database.ConexionDB;
import Dominio.PenaltyShotooutSimulator;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private ConsoleUI console = new ConsoleUI();
    private ArrayList<PenaltyShotooutRegister> matchHistory = new ArrayList<>();


        public void startGame(){


            List<MatchHistoryDTO> history = DatabaseManager.getMatchHistory();

            if(history.isEmpty()){
                System.out.println("No historical matches found");
            }

            for(MatchHistoryDTO historical : history){
                System.out.println("Tirador: " + historical.getKickerName() + " - Goles: " + historical.getGoals() + " | vs | Arquero : "
                        + historical.getGoalkeeperName() + " - Atajadas: " + historical.getSaves());
            }
            System.out.println(" ");

            Player myStriker = console.requestPlayerData("Striker");

            Player myMidfielder = console.requestPlayerData("Midfielder");

            Player myGoalkeeper = console.requestPlayerData("Goalkeeper");

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

                DatabaseManager.savePenaltyShotoout(finalRecord);
                keepPlaying = console.askAnotherRound();

            }while(keepPlaying);
        }
}
