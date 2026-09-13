package TandaPenaltis;

public class Midfielder extends Player implements ReactionPenalty {
    
    public Midfielder(String name, int numberShirt, int levelSkill) {
    super(name, numberShirt, levelSkill);
    }
    
    @Override
    public int executeAction(){
        int precisionShoot = getlevelSkill() + 7;
        
        System.out.println("El nivel de precision del mediocampista es de "+ precisionShoot);
        System.out.println("El dorsal del mediocampista es: "+ getnumberShirt());
        
        return precisionShoot;
    }
    
    @Override
    public void celebrateSuccess(){
        System.out.println(getName()+"Se tira al cesped celebrando la anotación y corre hacia sus compañeros a darles confianza");
    }

    @Override
    public void lamentFailure() {
        System.out.println(getName()+"Se va lentamente hacia el centro del campo y pide perdon a la aficion");
    }
}

