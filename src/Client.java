
class Client {

	private String nom;
	private double credit;

	public Client(String nom, double credit) {
		this.nom = nom;
		this.credit = credit;
	}

	public void augmenterCredit(double montant) {
		credit = credit + montant;
	}

	public void diminuerCredit(double montant) {
		credit = credit - montant;
	}

	public double getCredit() {
		return credit;
	}


	public String getNom() {
		return nom;
	}
}