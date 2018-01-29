package clinique.V3_1.client;

import clinique.V3_1.interfaces.ICabinet;
import clinique.V3_1.interfaces.IVeterinaire;
import clinique.V3_1.serveur.Animal;
import clinique.V3_1.serveur.Espece;

import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private static final String pathToCompiledClasses = "/auto_home/tkriszt/IdeaProjects/nTiers/TP1 - veterinaire/out/production/TP1 - veterinaire/clinique/v3/";
//    private static final String pathToCompiledClasses = "/out/production/TP1 - veterinaire/clinique/v3/serveur/";
    public static void main(String[] args) {

        System.out.println("Path : " + System.getProperty("user.dir"));

        System.setProperty("rmi.server.useCodebaseOnly", "false");
        System.setProperty("rmi.server.codebase", pathToCompiledClasses);
        System.setProperty("security.policy", "client.policy");



        try {

            IVeterinaire veto = (IVeterinaire) new Veterinaire("Veterinaire principal");
            IVeterinaire veto2 = (IVeterinaire) new Veterinaire("Veterinaire de nuit");

            Registry registry = LocateRegistry.getRegistry(1102);
            ICabinet monCabinet = (ICabinet) registry.lookup("cabinet");
            System.out.println("Objet distant cabinet récupéré");

            monCabinet.connect(veto);
            monCabinet.connect(veto2);

            monCabinet.addAnimal(new Animal("Civet", "Lapin nain", "Mme Ginette", new Espece("Lapin")));
            monCabinet.addAnimal(new Animal("Gigot", "Agneau", "Mme Ginette", new Espece("Mouton")));

            System.out.println("Passage en horaires de nuit : le véto principal se déconnecte");
            monCabinet.disconnect(veto);

            monCabinet.removeAnimal("Civet");
            monCabinet.removeAnimal("Gigot");






        }catch (ConnectException e){
            System.err.println("Erreur de connexion au serveur : \n" + e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }


}
