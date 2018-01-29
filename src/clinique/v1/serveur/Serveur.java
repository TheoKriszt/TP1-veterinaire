package clinique.v1.serveur;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {
    public static void main(String[] args){
        System.out.println("Server started v1...");


        System.setProperty( "java.security.policy", "server.policy");

        System.setSecurityManager(new RMISecurityManager());


        try {
            Animal obj = new Animal("Hypo","Européen", "Mr Dupont", new Espece("Chat"));
            Registry registry = LocateRegistry.createRegistry(1099);

            if (registry == null){
                System.err.println("Registry not found !");
            }else {
                registry.rebind("hypo", obj);
                System.out.println("Objet animal _\"hypo\" binded");
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }



    }
}
