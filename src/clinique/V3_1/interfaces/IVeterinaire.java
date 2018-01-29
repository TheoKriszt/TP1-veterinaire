package clinique.V3_1.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IVeterinaire extends Remote {

    void alerte(String msg) throws RemoteException;

    String getName() throws RemoteException;
}
