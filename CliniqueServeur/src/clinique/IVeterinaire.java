package clinique;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IVeterinaire extends Remote{
	
//	public void addAnimal(String k, String n, String m, String s, String ne, int v) throws RemoteException;
	
//	public IAnimal getAnimalByName(String n) throws RemoteException;

    String getName()  throws RemoteException;

	void alerte(String s) throws RemoteException;
}
