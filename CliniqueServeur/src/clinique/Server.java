package clinique;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server {

    /**
     * Le Server sers un stub de IVeterinaire bindé sur la clé "Veto"
     */
	public Server() {}


	public static void main(String args[]) {
		//security
		// ne pas oublier de spécifier file:/my/path/to/compiled/sources/ (avec "/" de fin)
		// charger les bins depuis le dossier de l'autre projet
		System.setProperty("java.security.policy", "file:C:\\Users\\Utilisateur\\IdeaProjects\\CliniqueServeur\\src\\clinique\\helloServer.policy");
		System.setProperty("java.rmi.server.codebase","file:C:\\Users\\Utilisateur\\IdeaProjects\\CliniqueClient\\bin\\");
		System.setSecurityManager(new SecurityManager());
		
		//server
		try {

			CabinetVeterinaire cabinetVeterinaire = new CabinetVeterinaire();
            Espece echat = new Espece("Chat", 14);
            Espece echien = new Espece("Chien", 12);
//            list.put("Purrito", new Animal("Purrito","Crazy Cat Lady", "Tout va bien!!! :)", new Espece("Cat",10)));
//            list.put("Medor", new Animal("Medor","John Cena", "Tout va bien!!! :)",new Espece("Chien",13)));

            cabinetVeterinaire.addAnimal(new Animal("Bretzel", "SPA de montpellier", echien));
            cabinetVeterinaire.addAnimal(new Animal("Oreo", "The crazy cat lady", "Trop gras, doit faire un régime", echat));
            cabinetVeterinaire.addAnimal(new Animal("Lassie", "M. Gerard", "Rappel de vaccin :  mi-fevrier", echien));

			Registry registry = LocateRegistry.createRegistry(1099);

//			Registry registry = LocateRegistry.getRegistry();
			if (registry == null){
				System.err.println("Registry not found");
				return;
			}else{
                registry.rebind("cabinet", cabinetVeterinaire);
                System.out.println("\ncabinetVeterinaire binded on \"cabinet\"");
//                registry.rebind("Veto", vetoPrincipal);
//				registry.rebind("VetoNuit", vetoDeNuit);
				System.out.println("Server ready");
			}
		} catch (Exception e) {
			System.err.println("Server exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
