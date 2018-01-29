package clinique.V3_1.interfaces;

import clinique.V3_1.serveur.Espece;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote{

    void printInfos() throws RemoteException;
    String returnInfos() throws RemoteException;

    Espece getBreed() throws RemoteException;

    String getName() throws RemoteException;
}
