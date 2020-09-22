package collection.tsio;

public class Adresse extends Contact {
	
	protected int numero;
	protected int codepostal;
	protected String rue;
	protected String ville; 
	
	public Adresse(int numero, String rue, int codepostal, String ville) {
		this.numero = numero;
		this.codepostal = codepostal;
		this.rue = rue;
		this.ville = ville;
	}

	public int getNumero() {
		return numero;
	}

	public int getCodepostal() {
		return codepostal;
	}

	public String getRue() {
		return rue;
	} 
	
	public String getVille() {
		return ville;
	}
	
	@Override
	public String toString() {
		return numero + "," + rue + ":" + codepostal + " " + ville; 
	}
}
