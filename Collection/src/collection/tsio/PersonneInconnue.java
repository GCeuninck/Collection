package collection.tsio;

public class PersonneInconnue extends Exception {

	Personne personne;
	
	public PersonneInconnue(Personne p) {
		super("Personne incconue");
		this.personne = p;
	}
	
	public Personne getPersonne() {
		return this.personne;
	}
}
