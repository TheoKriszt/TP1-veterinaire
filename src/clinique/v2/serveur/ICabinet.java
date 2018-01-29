package clinique.v2.serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICabinet extends Remote {


    IAnimal findAnimal(String n) throws RemoteException;

}
