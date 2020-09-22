package collection.tsio;

import java.util.*;

public class Main {
	
	static void partie1() {
		
		List<Personne> personnes = new LinkedList<Personne>();
		
		Calendar c1 = Calendar.getInstance();
		c1.set(2002, 5, 23); 
		Personne paul = new Personne("ochon", "paul", c1);
		
		Calendar c2 = Calendar.getInstance();
		c2.set(2010, 11, 24);  
		Personne jean = new Personne("dupont", "jean", c2);
		
		Calendar c3 = Calendar.getInstance();
		c3.set(1967, 1, 26);  
		Personne jacques = new Personne("dubois", "jacques", c3);
		
		
		personnes.add(paul);
		personnes.add(jean);
		personnes.add(jacques);

		System.out.println("Avec List");
		
		afficherPersonnes(personnes);
		System.out.println("------");
		
		reversePersonnes(personnes);
		afficherPersonnes(personnes);
		System.out.println("------");
		
		shufflePersonnes(personnes);
		afficherPersonnes(personnes);
		System.out.println("------");
		
		Set<Personne> personnes2 = new HashSet<Personne>();
		personnes2.add(paul);
		personnes2.add(jean);
		personnes2.add(jacques);
		
		System.out.println("Avec HashSet");
		afficherPersonnes(personnes2);
		System.out.println("------");
		personnes2.add(jacques);
		afficherPersonnes(personnes2);
		System.out.println("------");
		
		System.out.println("age moyen :" + ageMoyen(personnes));
	
		Set<Personne> personnes3 = new TreeSet<Personne>();
		personnes3.add(paul);
		personnes3.add(jean);
		personnes3.add(jacques);
		
		System.out.println("Avec TreeSet");	
		afficherPersonnes(personnes3);
		System.out.println("------");
		
		Set<Personne> personnes4 = new TreeSet<Personne>(new ComparatorPersonneAnniversaire());
		
		personnes4.add(paul);
		personnes4.add(jean);
		personnes4.add(jacques);
		
		System.out.println("Avec CompareAnniv");	
		afficherPersonnes(personnes4);
		System.out.println("------");
		
		Set<Personne> jeunes = ageInferieur(personnes4, 20);
		afficherPersonnes(jeunes);
	}
	
	static void afficherPersonnes(Collection<Personne> cp) {
		
		Iterator<Personne> iterator = cp.iterator();
		
		while(iterator.hasNext()) {
			Personne p = iterator.next();
			System.out.println("[" + p + "]");
		}
	}
	
	static void afficherPersonnes2(Collection<Personne> cp) {
		
		for(Personne p: cp) {
			System.out.println("[" + p + "]");
			}
		}
	
	static void afficherPersonnes3(List<Personne> lp) {
		ListIterator<Personne> iterator = lp.listIterator();
		while(iterator.hasNext()) {
			Personne p = iterator.next();
			int index = iterator.nextIndex();
			System.out.println(index + ": [" + p + "]");
		}
	}
	
	static void reversePersonnes(List<Personne> cp) {
		
		Collections.reverse(cp);
	}
	
	static void shufflePersonnes(List<Personne> cp) {
		
		Collections.shuffle(cp);
	}
	
	static float getAge(Personne p) {
		Date today = new Date();
		long denum = 31536000000L; //nb de ms dans 1 année
		
		Date anniv = p.getAnniversaire().getTime();
		long delta = today.getTime() - anniv.getTime();
		float age = delta / denum;
		
		return age;
	}
	
	static float ageMoyen(Collection<Personne> cp) {
		float sumAge = 0;
		Iterator<Personne> iterator = cp.iterator();
		while(iterator.hasNext()) {
			Personne p = iterator.next();
			sumAge += getAge(p);
		}
		return sumAge / cp.size();
	}
	
	static Set<Personne> ageInferieur(Collection<Personne> cp, int age){
		Set<Personne> res = new HashSet<Personne>();
		for(Personne p : cp) {
			if(getAge(p) < age) {
				res.add(p);
			}
		}
		return res;
	}
	
	static void partie2() {
				
		Calendar c1 = Calendar.getInstance();
		c1.set(2002, 5, 23); 
		Personne paul = new Personne("ochon", "paul", c1);
		
		Calendar c2 = Calendar.getInstance();
		c2.set(2010, 11, 24);  
		Personne jean = new Personne("dupont", "jean", c2);
		Contact jeanContact = new Mail("jean.dupont", "imt-lille-douai.fr");
		
		Calendar c3 = Calendar.getInstance();
		c3.set(1967, 1, 26);  
		Personne jacques = new Personne("dubois", "jacques", c3);
		Contact jacquesContact = new NumTel("060504030201", NumTel.TypeTel.FIXEPROF);
		
		GestionnaireContacts gcpub = new GestionnaireContacts("Private");
		Contact paulContact = new Adresse(2, "rue marconi", 59655, "Villeneuve d'Ascq");
		
		try {
			gcpub.ajouter(jean, jeanContact);
			gcpub.ajouter(paul, paulContact);
			gcpub.ajouter(jacques, jacquesContact);
			gcpub.afficher(System.out);
			System.out.println("------");
			
			gcpub.modifier(paul, new Mail("paulochon", "gmail.com"));
			gcpub.afficher(System.out);
			System.out.println("------");
			
			afficherPersonnes(gcpub.personnes());
			System.out.println("------");
			afficherPersonnes(gcpub.personnes("o"));
			System.out.println("------");
			
			gcpub.ajouter(paul, new NumTel("0607080901", NumTel.TypeTel.FIXEDOM));
			gcpub.afficher(System.out);
			System.out.println("------");
			
			gcpub.supprimer(paul);
			gcpub.afficher(System.out);
			System.out.println("------");
		} catch (PersonneExistantDeja e) {
			System.out.println(e.getMessage());
			System.out.println(e.getPersonne());
			//e.printStackTrace();
		} catch (PersonneInconnue e) {
			System.out.println(e.getMessage());
			System.out.println(e.getPersonne());
			//e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		//partie1();
		partie2();
	}

}
