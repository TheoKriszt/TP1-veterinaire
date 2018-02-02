package clinique;


@SuppressWarnings("serial")
public class EspeceProtegee extends Espece{


	public EspeceProtegee(String n, int v) {
		super(n, v);
	}

	public String infos()
	{
		return ("(protegée) "+super.infos());
	}
}
