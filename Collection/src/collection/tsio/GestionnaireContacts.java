package collection.tsio;

import java.io.PrintStream;
import java.util.*;

public class GestionnaireContacts {
	
	String nom;
	HashMap<Personne, Contact> gc;
	
	public GestionnaireContacts(String nom) {
		this.nom = nom;
		this.gc = new HashMap<Personne, Contact>();
	}
	
	public boolean ajouter(Personne p, Contact c) {
		boolean res = false;
		if (!this.gc.containsKey(p)) {
			this.gc.put(p, c);
			res = true;
		}
		return res;
	}
	
	public Contact contacts(Personne p){
		return this.gc.get(p);
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public boolean modifier(Personne p, Contact c) {
		boolean res = false;
		if (this.gc.containsKey(p)) {
			this.gc.put(p, c);
			res = true;
		}
		return res;
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
	
	public boolean supprimer(Personne p) {
		boolean res = false;
		if (this.gc.containsKey(p)) {
			this.gc.remove(p);
			res = true;
		}
		return res;
	}
	
	public void afficher(PrintStream ps) {
		for (Map.Entry<Personne, Contact> entry: gc.entrySet()) {
			ps.println(entry.getKey() + " => " + entry.getValue());
		}
	}
	
}
