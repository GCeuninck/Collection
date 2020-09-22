package collection.tsio;

public class Mail extends Contact {
	
	protected String identifiant;
	protected String domaine;
	
	public Mail(String identifiant, String domaine) {
		super();
		this.identifiant = identifiant;
		this.domaine = domaine;
	}
	
	public String toString() {
		return identifiant + "@" + domaine;
	}
}
