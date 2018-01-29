package clinique.v2.client;

import clinique.v2.serveur.Animal;
import clinique.v2.serveur.IAnimal;
import clinique.v2.serveur.ICabinet;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry(1100);
            ICabinet cabinet = (ICabinet) registry.lookup("cabinet");
            System.out.println("Objet distant cabinet recupéré." );

            IAnimal nai;
            for (int i = 1; i < 5; i++){
                System.out.println("Recherche du patient " + i);
                nai = (IAnimal) cabinet.findAnimal("Patient " + i);

                if (nai != null){
                    System.out.println("patient trouvé : " + nai.getName() + ", espèce : (" + nai.getBreed() + ")");
                }else {
                    System.err.println("Le patient " + i + " n'existe pas");
                }
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
