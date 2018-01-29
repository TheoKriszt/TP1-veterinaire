package clinique.v3.interfaces;

import clinique.v3.serveur.Espece;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote{

    void printInfos() throws RemoteException;
    String returnInfos() throws RemoteException;

    Espece getBreed() throws RemoteException;

    String getName() throws RemoteException;
}
