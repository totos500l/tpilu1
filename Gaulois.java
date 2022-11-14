package personnages;

public class Gaulois {
	
	private String nom;
	private int effetPotion=1;
	private int force;
	private int nb_trophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}


	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+ texte+">>");
	}
	
//	public String prendreParole() {
//		return "Le Gaulois"+nom+":";
//	}
	private String prendreParole() {
		return  "Le gaulois " + nom + " : ";
		}

	
//	public void frapper(Romain romain) {
//		System.out.println(nom+ "envoie un grand coup dans la m�choire de " 
//				+ romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		Equipement[] butin = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; butin != null && i < butin.length; i++,nb_trophees++) {
			this.trophees[nb_trophees] = butin[i];
		}
		
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion=forcePotion;
		parler("Merci Druide, je sens que ma force est "+forcePotion+ " fois decuplee." );
	}
	
	public void faireUneDonation(Musee musee) {
		if (nb_trophees!=0) {
			parler("Je donne au musee tous mes trophees :");
			for (int i=0; i<nb_trophees;i++) {
				System.out.println(trophees[i]);
				musee.donnerTrophee(this, trophees[i]);
			}
		}
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
	Gaulois asterix = new Gaulois("Ast�rix",8);
	System.out.println(asterix);
	
	//Test prendreParole
	System.out.println(asterix.prendreParole());
	
	//Test parler
	asterix.parler("Bonjour");
	
	//Test frapper
	Romain testRomain = new Romain("Test",6);
	asterix.frapper(testRomain);
	
	//Test boirePotion
	Romain testRomain2 = new Romain("Test",6);
	asterix.boirePotion(10);
	asterix.frapper(testRomain2);
	}
}