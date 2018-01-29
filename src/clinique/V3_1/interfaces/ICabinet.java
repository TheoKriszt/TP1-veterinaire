package clinique.V3_1.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICabinet extends Remote {


    IAnimal findAnimal(String n) throws RemoteException;
    void addAnimal(IAnimal a) throws RemoteException;
    boolean removeAnimal(String n) throws RemoteException;
    void alerte() throws RemoteException;
    void connect(IVeterinaire veto) throws RemoteException;
    void disconnect(IVeterinaire veto) throws RemoteException;

}
