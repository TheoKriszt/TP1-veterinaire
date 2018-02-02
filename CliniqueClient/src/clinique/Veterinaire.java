package clinique;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Veterinaire extends UnicastRemoteObject implements IVeterinaire {

	private String name;
	public Veterinaire(String n) throws RemoteException
	{
		this.name = n;
	}

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
	public void alerte(String msg) throws RemoteException {

		System.out.println("[Veterinaire "+ name + "] : " + msg);

	}
}
