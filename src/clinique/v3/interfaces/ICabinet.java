package clinique.v3.interfaces;


import clinique.v3.serveur.Espece;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICabinet extends Remote {


    IAnimal findAnimal(String n) throws RemoteException;
    void addAnimal(IAnimal a) throws RemoteException;
    boolean removeAnimal(String n) throws RemoteException;
    void alerte() throws RemoteException;
    void connect(IVeterinaire veto) throws RemoteException;
    void disconnect(IVeterinaire veto) throws RemoteException;

    void printInfosEspece(Espece monEspece) throws RemoteException;
}
