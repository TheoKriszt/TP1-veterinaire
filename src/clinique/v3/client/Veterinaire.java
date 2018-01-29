package clinique.v3.client;

import clinique.v3.interfaces.IVeterinaire;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Veterinaire extends UnicastRemoteObject implements IVeterinaire{

    private  String name;

    public Veterinaire(String name) throws RemoteException{
        this.name = name;
    }

    @Override
    public void alerte(String msg) {
        System.out.println("[ALERTE VETERINAIRE] :: Veterinaire " + name + " => " + msg);
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }
}
