package clinique;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote{
	
	public String doc() throws RemoteException;
	
	public void setEspece(Espece e) throws RemoteException;

	public void changeSuivi(String string) throws RemoteException;

	String getName()  throws RemoteException;

	Espece getBreed()  throws RemoteException;

//	String toString() throws RemoteException;
}
