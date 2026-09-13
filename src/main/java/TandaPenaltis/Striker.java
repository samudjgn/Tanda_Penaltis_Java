/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TandaPenaltis;

/**
 *
 * @author samuito
 */
public class Striker extends Player implements ReactionPenalty {
    
    public Striker(String name, int numberShirt, int levelSkill) {
        super(name, numberShirt, levelSkill);
    }
      
   @Override
   public int executeAction(){
       
       int luckyFactor = (int) (Math.random()* 20);
       
       int finalShoot = getlevelSkill() + luckyFactor;
       System.out.println("Nivel de habilidad del delantero: "+ getlevelSkill());
       System.out.println("Nivel de suerte: "+luckyFactor);
       return finalShoot;
   }

    @Override
    public void celebrateSuccess() {
        System.out.println(getName()+" Se va hacia sus compañeros, alza las manos mirando hacia la aficion y le da confianza a los siguientes pateadores de su equipo");
    }
    
    
    @Override
    public void lamentFailure() {
        System.out.println(getName()+" Se sube la camiseta a la cara, mostrando verguenza despues de haber fallado el penalti");
    }
    
}
