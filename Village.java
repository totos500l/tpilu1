package personnages;


import personnages.Chef;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois=0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void ajouterHabitant(Gaulois habitant) {
		villageois[nbVillageois] = habitant;
		nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef"+chef.getNom()+" vivent les legendaires gaulois :");
		for (int i=0; i<nbVillageois; i++) {
			System.out.println("-"+villageois[i].getNom());
		}
	}
	
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irreductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);
		//Out of bounds
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix",8);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Obelix",25);
		village.ajouterHabitant(obelix);
		Gaulois gaulois = village.trouverHabitant(1);
		System.out.println(gaulois);
		//null c'est en [0] qu'asterix est stocké
		village.afficherVillageois();

	}
}