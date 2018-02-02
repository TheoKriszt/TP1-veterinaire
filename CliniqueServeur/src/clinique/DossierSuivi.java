package clinique;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class DossierSuivi extends UnicastRemoteObject{

	protected String suivi;
	
	public DossierSuivi() throws RemoteException
	{
		suivi = "";
	}
	
	public void setSuivi(String s) throws RemoteException
	{
		suivi = s;
	}
	
	public String getSuivi() throws RemoteException
	{
		return suivi.equals("") ? "(aucun suivi pour le moment)" : suivi ;
	}
	
}
