package personnages;

public class Romain {
	
	
	private String nom;
	private int force;
	private Equipement[] equipements= new Equipement[2];
	private int nbEquipement=0;

	
	public Romain(String nom, int force) {
	this.nom = nom;
	this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
	System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	private String prendreParole() {
	return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//	force -= forceCoup;
//	if (force > 0) {
//		parler("A�e");
//		}
//	else {
//		parler("J'abandonne...");
//		}
//	}
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("A�e");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force==0) {
			
				parler("Aie");
		}else {
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
		}
				
			// post condition la force � diminuer
		assert force < oldForce;
		return equipementEjecte;
		}
	
	
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if ((nbEquipement != 0)) {
			texte += "\nMais heureusement, grace a mon equipement sa force est diminue de ";
			for (int i = 0; i < nbEquipement; i++) {
//				if ((equipements[i] != null &&
//					equipements[i].equals(Equipement.BOUCLIER))) {
//					resistanceEquipement += 8;
//				} else {
//					System.out.println("Equipement casque");
//					resistanceEquipement += 5;
//					}
				if(equipements[i]!=null) {
					switch (equipements[i])
						{
						case BOUCLIER:
							resistanceEquipement+=8;
							break;
						
						case CASQUE: 
							resistanceEquipement+=5;
							break;
						
						default: 
							break;
						}	
					}
				}
				texte += resistanceEquipement + "!";
			}
			parler(texte);
			forceCoup -= resistanceEquipement;
			return forceCoup;
		}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'equipement de " + nom + "s envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
			}
			return equipementEjecte;
		}

	public void sEquiper(Equipement equipement) {
			switch (nbEquipement) 
			{		
				case 0 :
					equipements[0]=equipement;
					System.out.println("Le soldat "+nom+" s'equipe d'un "+equipement.toString());
					nbEquipement=1;
					break;
				case 1:
					if (equipements[0].toString()==equipement.toString())
					{
						System.out.println("Le soldat "+nom+" possede deja� un "+equipement.toString());
					}
					else {
						equipements[1]= equipement;;
						nbEquipement=2;
						System.out.println("Le soldat "+nom+" s'equipe d'un "+equipement.toString());
					}
					break;
					
				default:
					System.out.println("Le soldat "+nom+" est d�j� bien prot�g�");
					break;
			}		
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		
		//Test prendreParole
		System.out.println(minus.prendreParole());
		
		//Test parler
		minus.parler("Bonjour");
		
		//Test frapper
		minus.recevoirCoup(2);
		minus.recevoirCoup(1000);
		
		//Test sEquiper
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
