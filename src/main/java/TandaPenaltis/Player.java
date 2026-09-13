/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TandaPenaltis;

/**
 *
 * @author samuito
 */
public abstract class Player implements ReactionPenalty {
    private String name;
    private int numberShirt;
    private int levelSkill; //Habilidad base del 1 al 100
    
    public abstract int executeAction();
    
    public Player(String name, int numberShirt, int levelSkill){
        this.levelSkill = levelSkill;
        this.name = name;
        this.numberShirt = numberShirt;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public int getnumberShirt(){
        return numberShirt;
    }
    
    public void setnumberShirt(int numberShirt){
        this.numberShirt = numberShirt;
    }
    
    public int getlevelSkill(){
        return levelSkill;
    }
    
    public void setlevelSkill(int levelSkill){
        this.levelSkill = levelSkill;
    }
}
