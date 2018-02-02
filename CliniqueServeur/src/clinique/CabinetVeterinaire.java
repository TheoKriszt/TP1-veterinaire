package clinique;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CabinetVeterinaire extends UnicastRemoteObject implements ICabinet {

    protected ArrayList<IAnimal> patients = new ArrayList<>();
    protected ArrayList<IVeterinaire> veterinaires = new ArrayList<>();


    public CabinetVeterinaire() throws RemoteException {
        System.out.println("Cabinet créé. Seuils d'alertes à 5, 10 et 100 patients");
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
    public void printInfosEspece(Espece monEspece) throws RemoteException {
        System.out.println(monEspece.toString());
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
        System.out.println("Animal ajouté : " + a.doc());
//        System.out.println("Espece : " + a.getBreed().infos());
        if (patients.size() == 100 || patients.size() == 10 || patients.size() == 5){
            alerte();
        }
    }

    @Override
    public boolean removeAnimal(IAnimal a) throws RemoteException {
        String n = a.getName();
        IAnimal toRemove = findAnimal(n);
        if (toRemove != null){
            System.out.println("L'animal " + n +" est retiré des patients");
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
                System.out.println(e.getMessage());
                System.err.println("Impossible de joindre le vétérinaire");
            }

        }
    }


}
