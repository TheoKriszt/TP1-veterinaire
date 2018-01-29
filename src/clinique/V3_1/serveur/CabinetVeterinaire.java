package clinique.V3_1.serveur;

import clinique.V3_1.interfaces.IAnimal;
import clinique.V3_1.interfaces.ICabinet;
import clinique.V3_1.interfaces.IVeterinaire;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CabinetVeterinaire extends UnicastRemoteObject implements ICabinet {

    protected ArrayList<IAnimal> patients = new ArrayList<>();
    protected ArrayList<IVeterinaire> veterinaires = new ArrayList<>();


    public CabinetVeterinaire() throws RemoteException {
        patients.add(new Animal("Patient V3_1", "Chépa", "SPA", new Espece("Chien")));
        patients.add(new Animal("Patient 2", "Bouboule", "M. Gerard", new Espece("Chat")));
        patients.add(new Animal("Patient 3", "Fido", "M. Gerard", new Espece("Chien")));
    }

    @Override
    public void connect(IVeterinaire veto) {
        if (!veterinaires.contains(veto)){
            veterinaires.add(veto);
            try {
                System.out.println("[CABINET] :: " + veto.getName() + " est connecté");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void disconnect(IVeterinaire veto) {
        veterinaires.remove(veto);
        try {
            System.out.println("[CABINET] :: " + veto.getName() + " est déconnecté");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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

    @Override
    public void addAnimal(IAnimal a) throws RemoteException {
        patients.add(a);
        if (patients.size() == 100 || patients.size() == 10 || patients.size() == 5){
            alerte();
        }
    }

    @Override
    public boolean removeAnimal(String n) throws RemoteException {
        IAnimal toRemove = findAnimal(n);
        if (toRemove != null){
            patients.remove(toRemove);
            if (patients.size() == 99 || patients.size() == 9 || patients.size() == 4){
                alerte();
            }
            return true;
        }
        return false;
    }

    public void alerte() throws RemoteException {
        for (IVeterinaire v : veterinaires){
            try {
                v.alerte("Nouveau seuil atteint : " + patients.size() + " patients");
            }catch (Exception e){
                System.err.println("Impossible de joindre le vétérinaire");
            }

        }
    }


}
