package clinique.V3_1.serveur;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {
    private  static final String jarPath = "";


    public static void main(String[] args){
        System.out.println("Server started clinique.v3...");



        System.setProperty( "java.security.policy", "server.policy");
        System.setProperty("java.rmi.server.codebase", jarPath);

//        System.setSecurityManager(new SecurityManager());
        System.setSecurityManager(new RMISecurityManager());

        try {

            CabinetVeterinaire cabinetVeterinaire = new CabinetVeterinaire();
//            ICabinet stub = (ICabinet) UnicastRemoteObject.exportObject(cabinetVeterinaire, 0);

            Registry registry = LocateRegistry.createRegistry(1102);

            if (registry == null){
                System.err.println("Registry not found !");
            }else {
                registry.rebind("cabinet", cabinetVeterinaire);
                System.out.println("Cabinet binded");
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }



    }
}
