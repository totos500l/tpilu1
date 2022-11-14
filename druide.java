package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion=1;
	
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
	this.nom = nom;
	this.effetPotionMin = effetPotionMin;
	this.effetPotionMax = effetPotionMax;
	parler("Bonjour, je suis le druide " + nom +
			" et ma potion peut aller d'une force " + 
			effetPotionMin + " � "+ effetPotionMax + ".");
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void preparerPotion() {
		Random random=new Random();
		forcePotion=effetPotionMin+random.nextInt(effetPotionMax-effetPotionMin+1);
		if (forcePotion>7) {
			this.parler("J'ai prepare une super potion de force");
		}
		else {
			this.parler("je n'ai pas trouve tous les ingredients, "
					+ "ma potion est seulement de force");
		}
	}
	
	public void	booster(Gaulois gaulois) {
		if (gaulois.getNom()=="Obelix"){
				parler("Non, Obelix... "
				+ "Tu n�auras pas de potion magique ! ");
		}
		else {
		gaulois.boirePotion(forcePotion);
		}
	}
		
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();
		System.out.println(panoramix.forcePotion);
	}
	

}