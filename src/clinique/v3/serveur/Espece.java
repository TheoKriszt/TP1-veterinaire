package clinique.v3.serveur;

import java.io.Serializable;
import java.util.Random;

public class Espece implements Serializable{
    protected String name;
    protected int lifeSpan;

    public Espece(String n){
        this.name = n;
        Random r = new Random();
        lifeSpan = r.nextInt(50);
    }

    @Override
    public String toString() {
        return "Nom : " + name + ", esperance : " + lifeSpan;
    }
}
