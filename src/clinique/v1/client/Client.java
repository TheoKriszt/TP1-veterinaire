package clinique.v1.client;

import clinique.v1.serveur.IAnimal;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);

            IAnimal obj = (IAnimal) registry.lookup("hypo");

            System.out.println("Objet animal : " + obj.returnInfos());

            System.out.println("Espece : " + obj.getBreed());

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
