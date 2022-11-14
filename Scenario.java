package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gaulois asterix = new Gaulois ("Astérix",8);
		Gaulois obelix = new Gaulois ("Obélix",100);		
//		System.out.println(asterix);
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		panoramix.booster(asterix);
		Romain minus=new Romain("Minus",40);
		asterix.parler( "Bonjour ");
		minus.parler( "UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);

	}

}