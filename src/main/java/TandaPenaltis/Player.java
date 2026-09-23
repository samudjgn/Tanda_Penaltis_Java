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
    private int jerseyNumber;
    private int skillLevel; //Habilidad base del 1 al 100
    
    public abstract int executeAction();
    
    public Player(String name, int jerseyNumber, int skillLevel){
        this.skillLevel = skillLevel;
        this.name = name;
        this.jerseyNumber = jerseyNumber;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public int getJerseyNumber(){
        return jerseyNumber;
    }
    
    public void setjerseyNumber(int numberShirt){
        this.jerseyNumber = jerseyNumber;
    }
    
    public int getSkillLevel(){
        return skillLevel;
    }
    
    public void setlevelSkill(int levelSkill){
        this.skillLevel = skillLevel;
    }
}
