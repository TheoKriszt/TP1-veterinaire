package clinique.V3_1.serveur;

import clinique.V3_1.interfaces.IAnimal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Animal extends UnicastRemoteObject implements IAnimal {

    protected String maitre;
    protected String nom;
    protected Espece espece;
    protected String race;

    protected DossierMedical dossierMedical;



    public Animal(String n, String r, String m, Espece e) throws RemoteException {
        nom = n;
        espece = e;
        race = r;
        maitre = m;
        dossierMedical = new DossierMedical();

    }

    @Override
    public String toString() {
        return ""
                + "Nom : " + nom
                + ", Maitre : " + maitre
                + ", Espece : " + espece
                + ", Race : " + race
                + "\n Dossier : " + dossierMedical
                ;
    }

    public void printInfos() throws RemoteException{
        System.out.println(this);
    }

    public String returnInfos() throws RemoteException{
        return this.toString();
    }

    @Override
    public Espece getBreed() throws RemoteException {
        return espece;
    }

    @Override
    public String getName() {
        return nom;
    }
}
