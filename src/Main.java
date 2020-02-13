import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws NbMedicamentNegException {

//les clients et les médicaments sont rangés dans des listes

		ArrayList<Client> listClient = new ArrayList<Client>();

		listClient.add(new Client("dupond", 200));
		listClient.add(new Client("durand", 500));
		listClient.add(new Client("delaporte", 300));
		listClient.add(new Client("duris", 100));

		double maxCredit = 0;
		int i = 0;
		int iMax = 0;

		Iterator<Client> it = listClient.iterator();

		while (it.hasNext()) {
			Client nom = it.next();
			i++;

			if (maxCredit < nom.getCredit()) {
				maxCredit = nom.getCredit();
				iMax = i;
			}
		}

		ArrayList<Medicament> listMedicament = new ArrayList<Medicament>();

		listMedicament.add(new Medicament("Spedifen", 4.5, 2200));
		listMedicament.add(new Medicament("Efferalgan", 2.5, 1500));
		listMedicament.add(new Medicament("Doliprane", 5, 2500));
		listMedicament.add(new Medicament("Upfen", 6, 3000));

		double maxPrix2 = 0;
		int i2 = 0;
		int iMax2 = 0;

		new ArrayList<Integer>();

		Iterator<Medicament> it2 = listMedicament.iterator();
		while (it2.hasNext()) {
			Medicament nom = it2.next();
			i2++;

			if (maxPrix2 < nom.getPrix()) {
				maxPrix2 = nom.getPrix();
				iMax2 = i2;
			}

		}
		System.out.println("Credit max des clients: " + maxCredit + " pour l'indice iMax: " + iMax);
		System.out.println("prix max des medicaments: " + maxPrix2 + " pour l'indice iMax: " + iMax2);

		int choix;

		do {
			choix = menu();
			switch (choix) {
			case 1:
				// achat();
				
				System.out.println("veuillez saisir le nom du client: ");
				String nomClient = Lire.S();

				Client client = lireClient(nomClient, listClient);
				// System.out.println(medicament.getNom());
				if (client == null) {
					System.out.println("client inconnu");

				}
				System.out.println("veuillez saisir le nom du medicament: ");
				String nomMedicament = Lire.S();

				Medicament medicament = lireMedicament(nomMedicament, listMedicament);
				// System.out.println(medicament.getNom());
				if (medicament == null) {
					System.out.println("medicament inconnu");
				}

				System.out.println("quelle quantité de medicament voulez vous acheter? ");
				int nbunites = Lire.i();

				try {
					medicament.diminuerStock(nbunites);
					System.out.println("afficher le nouveau stock: " + medicament.getStock());
				} catch (NbMedicamentNegException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				double montant= nbunites * medicament.getPrix();
				client.diminuerCredit(montant);
				
				System.out.println("afficher le nouveau credit: " + client.getCredit());
				
				
				break;
			case 2:

				Medicament medicament2;

				System.out.println("veuillez saisir le nom du medicament: ");
				String nom = Lire.S();

				medicament2 = lireMedicament(nom, listMedicament);
				// System.out.println(medicament.getNom());
				if (medicament2 == null) {
					System.out.println("medicament inconnu");
				}
				System.out.println("quelle quantité ajoutez vous au stock? ");
				int nbunites2 = Lire.i();

				medicament2.approvisionner(nbunites2);
				System.out.println("afficher le nouveau stock: " + medicament2.getStock());

				break;
			case 3:
				affichage(listClient, listMedicament);

				break;
			case 4:
				quitter(listClient);

			}
		} while (choix < 4);
	}

	public static int menu() {
		int choix = 0;
		System.out.println();
		System.out.println();
		System.out.println("1 : Achat de médicament");
		System.out.println("2 : Approvisionnement en médicaments");
		System.out.println("3 : Etats des stocks et des crédits");
		System.out.println("4 : Quitter");
		while ((choix != 1) && (choix != 2) && (choix != 3) && (choix != 4)) {
			choix = Lire.i();
		}
		return choix;
	}

	static void affichage(ArrayList<Client> client, ArrayList<Medicament> medicament) {

		System.out.println("Affichage des stocks");
		for (int i = 0; i < medicament.size(); i++) {
			System.out
					.println("Stock du médicament " + medicament.get(i).getNom() + " :" + medicament.get(i).getStock());
		}

		System.out.println("Affichage des crédits");
		for (int i = 0; i < client.size(); i++) {
			System.out.println("Crédit du client " + client.get(i).getNom() + " :" + client.get(i).getCredit());
		}
	}

	public static Medicament lireMedicament(String nom, ArrayList<Medicament> list) {
		Medicament m;
		for (int i = 0; i < list.size(); i++) {
			m = list.get(i);

			if (m.getNom().equals(nom)) {

				return m;

			}

		}
		return null;

	}

	public static Client lireClient(String nom, ArrayList<Client> list) {
		Client c;
		for (int i = 0; i < list.size(); i++) {
			c = list.get(i);

			if (c.getNom().equals(nom)) {

				return c;

			}

		}
		return null;

	}

	private static void quitter(ArrayList <Client>liste) {
		// TODO Auto-generated method stub
		System.out.println("fin de l'application!");
		creationFichierClient(liste);
	}
	
	public static void creationFichierClient(ArrayList<Client>liste ) {
		
		try {
		FileWriter file= new FileWriter("fichierClient.csv");
		PrintWriter ecriture= new PrintWriter(file);
		
		for (int i= 0; i<liste.size(); i++) 	
		
		{ Client c = liste.get(i);
			String t= c.getNom() + " " + c.getCredit();
			ecriture.println(t);  
		}
		ecriture.close();
		
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

}
}
