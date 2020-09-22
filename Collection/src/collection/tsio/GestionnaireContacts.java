package collection.tsio;

import java.io.PrintStream;
import java.util.*;

public class GestionnaireContacts {
	
	String nom;
	HashMap<Personne, Contact> gc;
	//HashMap<Personne, List<Contact>> gc;
	
	public GestionnaireContacts(String nom) {
		this.nom = nom;
		this.gc = new HashMap<Personne, Contact>();
	}
	
	public void ajouter(Personne p, Contact c) throws PersonneExistantDeja {
		if (!this.gc.containsKey(p)) {
			this.gc.put(p, c);
		}
		else {
			throw new PersonneExistantDeja(p);
		}
	}
	
	public Contact contacts(Personne p){
		return this.gc.get(p);
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void modifier(Personne p, Contact c) throws PersonneInconnue {
		if (this.gc.containsKey(p)) {
			this.gc.put(p, c);
		}
		else {
			throw new PersonneInconnue(p);
		}
	}
	
	public Set<Personne> personnes(){
		return this.gc.keySet();
	}
	
	public Set<Personne> personnes(String prefix){
		Set<Personne> res = new HashSet<Personne>();
		for(Personne p : personnes()) {
			if(p.getNom().startsWith(prefix)) {
				res.add(p);
			}
		}
		return res;
	}
	
	public void supprimer(Personne p) throws PersonneInconnue {
		Contact rc = this.gc.remove(p);
		if (rc == null) {
			throw new PersonneInconnue(p);
		}
	}
	
	public void afficher(PrintStream ps) {
		for (Map.Entry<Personne, Contact> entry: gc.entrySet()) {
			ps.println(entry.getKey() + " => " + entry.getValue());
		}
	}
	
}
