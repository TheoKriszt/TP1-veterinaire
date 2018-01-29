package clinique.v3.client;

import clinique.v3.interfaces.IAnimal;
import clinique.v3.interfaces.ICabinet;
import clinique.v3.serveur.Espece;

import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client {
    private static final String pathToCompiledClasses = "/auto_home/tkriszt/IdeaProjects/nTiers/TP1 - veterinaire/out/production/TP1 - veterinaire/clinique/v3/";
    public static void main(String[] args) {

        System.setProperty("security.policy", "server.policy");
//        System.setProperty("rmi.server.useCodebaseOnly", "false");
//        System.setProperty("rmi.server.codebase", pathToCompiledClasses);
//        System.setSecurityManager(new RMISecurityManager());

        try {

            Registry registry = LocateRegistry.getRegistry(1101);
            ICabinet monCabinet = (ICabinet) registry.lookup("cabinet");
            System.out.println("Objet distant cabinet récupéré");

            IAnimal animal  = (IAnimal) monCabinet.findAnimal("Patient 4");
            Espece e = animal.getBreed();
            System.out.println(e);


        }catch (ConnectException e){
            System.err.println("Erreur de connexion au serveur : \n" + e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }


}
