package clinique;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


@SuppressWarnings("serial")
public class Animal extends UnicastRemoteObject implements IAnimal{

	private String nom;
	private String maitre;
	private Espece espece;
	private DossierSuivi suivi = new DossierSuivi();

	public Animal(String n, String m, String s, Espece e) throws RemoteException
	{
		nom =n;
		maitre = m;
		espece = e;
		suivi.setSuivi(s);
	}

	public Animal(String n, String m, Espece e) throws RemoteException
	{
		nom =n;
		maitre = m;
		espece = e;
	}
	
	public void setEspece(Espece e) throws RemoteException
	{
		espece = e;
	}
	
//	public Animal(String n, String m, String s) throws RemoteException
//	{
//		nom =n;
//		maitre = m;
//		espece = null;
//		suivi.setSuivi(s);
//	}
	
	public String doc() throws RemoteException
	{
		return("Nom: "+nom+"  Maitre: "+maitre+"  Espece: "+espece.infos()+" Suivi: "+suivi.getSuivi());
	}

	
	public void changeSuivi(String s) throws RemoteException
	{
		suivi.suivi=s;
	}

	@Override
	public String getName() throws RemoteException {
		return this.nom;
	}

	@Override
	public Espece getBreed() throws RemoteException {
		return this.espece;
	}
}
