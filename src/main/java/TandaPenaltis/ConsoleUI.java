package TandaPenaltis;

import java.util.Scanner;

public class ConsoleUI {

    private Scanner sc = new Scanner(System.in);

    public Player requestPlayerData(String namePosition){

        System.out.println("Ingrese el nombre del "+namePosition);
        String name = sc.nextLine();

        System.out.println("Ingrese el dorsal del "+namePosition);
        int dorsal = sc.nextInt();

        System.out.println("Ingrese el nivel de habilidad del "+namePosition);
        int skill = sc.nextInt();

        sc.nextLine();

        if (namePosition.equalsIgnoreCase("Striker")) {
            return new Striker(name, dorsal, skill);
        }else if(namePosition.equalsIgnoreCase("Midfielder")){
            return new Midfielder(name, dorsal, skill);
        }else{
            return new Goalkeeper(name, dorsal, skill);
        }
    }

    public int RequestJerseyNumber(){

        System.out.println("Digite el dorsal del jugador que va a patear: ");

        return sc.nextInt();
    }

    public boolean askAnotherRound(){
        System.out.println("¿Desea jugar de nuevo? Ingrese (S/N)");
        String request = sc.next();

        return request.equalsIgnoreCase("S");
    }
}
