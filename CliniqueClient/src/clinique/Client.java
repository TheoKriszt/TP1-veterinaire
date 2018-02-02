package clinique;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	private Client() {}

	public static void main(String[] args) {

		//security
		System.setProperty("java.security.policy", "file:C:\\Users\\Utilisateur\\IdeaProjects\\CliniqueClient\\src\\clinique\\helloClient.policy");
		System.setSecurityManager(new SecurityManager()); // RMISecurityManager is deprecated
		
		//serveur codeBase
		try {
			//creation serveur de report
			Registry registryRep = LocateRegistry.createRegistry(1098);
//			IReport report = new Report();
			if (registryRep==null){
				System.err.println("Registry not found");
			}else{
			
			//client
                Registry registry = LocateRegistry.getRegistry();
                ICabinet monCabinet = (ICabinet) registry.lookup("cabinet");

                System.out.println("Objet ICabinetVeterinaire distant récupéré");

                IAnimal bretzel  = (IAnimal) monCabinet.findAnimal("Bretzel");
                IAnimal oreo  = (IAnimal) monCabinet.findAnimal("Oreo");
                IAnimal lassie  = (IAnimal) monCabinet.findAnimal("Lassie");

                System.out.println("Animaux récupérés : ");
                System.out.println(bretzel.doc());
                System.out.println(oreo.doc());
                System.out.println(lassie.doc());

                IVeterinaire vetoPrincipal = new Veterinaire("Veterinaire principal");
                IVeterinaire vetoDeNuit = new Veterinaire("Veterinaire de garde");

                monCabinet.connect(vetoPrincipal);
                monCabinet.connect(vetoDeNuit);

                // La classe EspeceProtegee est inconnue pour le serveur distant : sera sérialisée
                EspeceProtegee barbastelle = new EspeceProtegee("Barbastelle", 4); // mammifère protégé de la famille des chauves-souris

                IAnimal protege = new Animal("Batty", "Bruce Wayne", barbastelle);

                monCabinet.addAnimal(protege); // addAnimal s'affiche sur le stdout du Serveur

                IAnimal spidey= new Animal("Spidey", "Peter Parker", new Espece("Araignée", 1));
                monCabinet.addAnimal(spidey);

                monCabinet.disconnect(vetoPrincipal);
			}
		}
		catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}