package clinique;

public class Clients {
    public static void main(String[] args) {
        System.out.println("Clinique veterinaire :");
        System.out.println("-----------------------\n\n");

        System.out.println("Version V3_1 : Animal simple, gestionnaire de sécurité, dossier de suivi et espèce");
        clinique.v1.client.Client.main(null);

        System.out.println("\n*****************************************************\n");

        System.out.println("Version 2 : classe distribuée représentant le cabinet vétérinaire");
        clinique.v2.client.Client.main(null);

        System.out.println("\n*****************************************************\n");

        System.out.println("Version 3 : Alerte distante aux vétérinaires sur le nombre de patients (seuils de 5, 10 et 100)\n");
        clinique.v3.client.Client.main(null);

    }
}