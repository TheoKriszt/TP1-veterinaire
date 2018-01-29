package clinique.v2.serveur;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {
    public static void main(String[] args){
        System.out.println("Server started clinique.v3...");


        System.setProperty( "java.security.policy", "server.policy");

        System.setSecurityManager(new RMISecurityManager());

        try {
            CabinetVeterinaire cabinetVeterinaire = new CabinetVeterinaire();

            Registry registry = LocateRegistry.createRegistry(1100);

            if (registry == null){
                System.err.println("Registry not found !");
            }else {
                registry.rebind("cabinet", cabinetVeterinaire);
                System.out.println("Objet cabinet binded");
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }



    }
}
