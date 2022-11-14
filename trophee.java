package personnages;

import personnages.Equipement;
import personnages.Gaulois;
public class trophee {
	private Gaulois gaulois;
	private Equipement equipement;
	public Gaulois getGaulois() {
		return gaulois;
	}
	
	public Equipement getEquipement() {
		return equipement;
	}
	
	public trophee(Gaulois gaulois, Equipement equipement) {
		super();
		this.gaulois = gaulois;
		this.equipement = equipement;
	}
	public String donnerNom() {
		return gaulois.getNom();
	}
}