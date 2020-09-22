package collection.tsio;

public class PersonneExistantDeja extends Exception {

	Personne personne;
	
	public PersonneExistantDeja(Personne p) {
		super("Personne existant deja");
		this.personne = p;
	}
	
	public Personne getPersonne() {
		return this.personne;
	}
}
