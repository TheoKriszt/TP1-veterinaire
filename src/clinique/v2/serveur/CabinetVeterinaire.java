package clinique.v2.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CabinetVeterinaire extends UnicastRemoteObject implements ICabinet{

    protected ArrayList<IAnimal> patients = new ArrayList<>();


    protected CabinetVeterinaire() throws RemoteException {
        patients.add(new Animal("Patient V3_1", "Chépa", "SPA", new Espece("Chien")));
        patients.add(new Animal("Patient 2", "Bouboule", "M. Gerard", new Espece("Chat")));
        patients.add(new Animal("Patient 3", "Fido", "M. Gerard", new Espece("Chien")));
    }

    @Override
    public IAnimal findAnimal(String n) throws RemoteException{

        for (IAnimal a : patients){
            if (a.getName().equals(n)){
                return a;
            }
        }

        return null;
    }

}
