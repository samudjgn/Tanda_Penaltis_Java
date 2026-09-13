package Dominio;

import TandaPenaltis.Player;
import TandaPenaltis.PenaltyShotooutRegister;

public class PenaltyShotooutSimulator {

    public PenaltyShotooutRegister runPenaltyShotoout(Player striker, Player goalkeeper){
        int goals=0;
        int saves=0;
        int posts = 0;

        String nameShooter = striker.getName();
        String nameGK = goalkeeper.getName();

        for(int i = 1; i<=5; i++){

            System.out.println("Cobro "+i+"!!");

            int finalShotPower = striker.executeAction();
            int finalSaveLevel = goalkeeper.executeAction();

            if(finalShotPower>finalSaveLevel){
                System.out.println("GOOOL DE "+nameShooter+"!!");
                goals++;

                striker.celebrateSuccess();
                goalkeeper.lamentFailure();
            }else if(finalShotPower<finalSaveLevel){
                System.out.println("ATAJADON DE "+nameGK+"!!" );
                saves++;

                goalkeeper.celebrateSuccess();
                striker.lamentFailure();
            }else{
                System.out.println("Palo!!");
                posts++;

                striker.lamentFailure();
            }
        }

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Goles: " + goals + " | Atajadas: " + saves + " | Palos: " + posts);

        if (goals > saves) {
            System.out.println("¡Gana el pateador!");
        } else if (saves > goals) {
            System.out.println("¡Gana el Goalkeeper!");
        } else {
            System.out.println("¡Es un empate!");
        }

        PenaltyShotooutRegister record = new PenaltyShotooutRegister(striker, goalkeeper, goals, saves);

        return record;
    }
}
