/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TandaPenaltis;

/**
 *
 * @author samuito
 */
public class Goalkeeper extends Player implements ReactionPenalty {
    
    public Goalkeeper(String name, int jerseyNumber, int skillLevel) {
        super(name, jerseyNumber, skillLevel);
    }

    @Override
    public int executeAction() {
        
        int luckyFactor = (int) (Math.random() * 20);
        
        int finalReflexes = getSkillLevel() + luckyFactor;
        System.out.println("Nivel de portero: "+ getSkillLevel());
        System.out.println("Factor de suerte: "+luckyFactor);
        return finalReflexes;
    }

    @Override
    public void celebrateSuccess() {
        System.out.println(getName()+" Alza el puño celebrando la atajada, y celebra con los aficionados");
    }

    @Override
    public void lamentFailure() {
        System.out.println(getName()+" Se dirige triste hacia la esquina, a esperar al siguiente penalti");
    }
    
}
