package clinique;

import java.rmi.RemoteException;
import java.util.Hashtable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Veterinaire extends UnicastRemoteObject implements IVeterinaire{

//	private Hashtable<String, Animal> list;

	private String name;
	public Veterinaire(String n) throws RemoteException
	{
		this.name = n;
//		list = new Hashtable<String, Animal>();
//		list.put("Purrito", new Animal("Purrito","Crazy Cat Lady", "Tout va bien!!! :)", new Espece("Cat",10)));
//		list.put("Medor", new Animal("Medor","John Cena", "Tout va bien!!! :)",new Espece("Chien",13)));
	}
	
//	public void addAnimal(String k, String n, String m, String s, String ne, int v) throws RemoteException
//	{
//		try{
////		Registry registry = LocateRegistry.getRegistry(1098);
////		IReport stub = (IReport) registry.lookup("Rep");
//
//		Animal a = new Animal(n,m,s, new Espece(ne,v));
//
//		list.put(k, a);
//		if (list.size() >= 3)
//			{
////				stub.report("Plus de 3 patients!");
//			}
//		}catch (Exception e){
//			System.out.println("bug");
//		}
//	}
	
//	public IAnimal getAnimalByName(String key) throws RemoteException {
//
//
//		Animal a = list.get(key);
//
//		 return (IAnimal)a;
//	}

	@Override
	public String getName() throws RemoteException {
		return name;
	}

	@Override
	public void alerte(String s) throws RemoteException {

	}


}
