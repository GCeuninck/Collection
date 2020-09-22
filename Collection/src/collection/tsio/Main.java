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
	
	static float ageMoyen(Collection<Personne> cp) {
		Date today = new Date();
		long denum = 31536000000L; //nb de ms dans 1 année
		float sumAge = 0;
		Iterator<Personne> iterator = cp.iterator();
		while(iterator.hasNext()) {
			Personne p = iterator.next();
			Date anniv = p.getAnniversaire().getTime();
			long delta = today.getTime() - anniv.getTime();
			float age = delta / denum;
			sumAge += age;
		}
		return sumAge / cp.size();
	}
	
	static void partie2() {
		
	}

	public static void main(String[] args) {
		
		partie1();
	}

}
