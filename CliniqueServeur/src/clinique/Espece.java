package clinique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Espece implements Serializable {

	protected String nom;
	protected int vieMoy;
	
	public Espece (String n, int v)
	{
		nom = n;
		vieMoy = v;
	}
	
	public String infos()
	{
		return nom+" Durée de vie moyenne: "+vieMoy;
	}
	
}
