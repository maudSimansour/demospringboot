

class Medicament {

	private String nom;
	private double prix;
	private int stock;

	public Medicament(String nom, double prix, int stock)
	throws NbMedicamentNegException
	{
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
	}

	
	
	
	public void augmenterStock(int quantite) {
		stock = stock + quantite;
	}

	public void diminuerStock(int quantite) throws NbMedicamentNegException {
		
		int i = stock - quantite;
		
	if(i<0)
	{
	throw new NbMedicamentNegException();
	}
	stock = stock - quantite;
	}
	
	public void approvisionner(int quantite) {
		this.augmenterStock(quantite);

	}



	public int getStock() {
		return stock;
	}
	

	public double getPrix() {
		return prix;
	}

	public String getNom() {
		return nom;
	}
}