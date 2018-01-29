package clinique;

public class Serveurs {
    public static void main(String[] args) {
//        System.out.println("Clinique veterinaire :");
//        System.out.println("-----------------------\n\n");

        clinique.v1.serveur.Serveur.main(null);
        System.out.println("Serveurs version V3_1 lancé");

        clinique.v2.serveur.Serveur.main(null);
        System.out.println("Serveurs version 2 lancé");

        clinique.v3.serveur.Serveur.main(null);
        System.out.println("Serveurs version 3 lancé");


    }
}