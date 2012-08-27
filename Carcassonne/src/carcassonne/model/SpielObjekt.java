/**
 * 
 */
package carcassonne.model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author landarzar
 *
 */
public abstract class SpielObjekt {

	protected Karte karte;
	protected LinkedList<Männchen> männchen;
	
	protected SpielObjekt(Karte karte)
	{
		this.karte = karte;
		this.männchen = new LinkedList<Männchen>();
	}
	
	
	public abstract void Scoring();
	
	public abstract void merge(SpielObjekt other);
	public boolean isBelegbar()
	{
		return männchen.isEmpty();
	}
	public void addMännchen(Männchen man) {
		this.männchen.add(man);
	}
	protected LinkedList<Spieler> getBesitzer() {
		HashMap<Spieler, Integer> map = new HashMap<Spieler, Integer>();
		for (Männchen man:this.männchen) {
			if (map.containsKey(man.getSpieler())) {
				map.put(man.getSpieler(), map.get(man.getSpieler())+1);
			}
			else {
				map.put(man.getSpieler(), 1);
			}
		}
		LinkedList<Spieler> bestP = new LinkedList<Spieler>();
		int best = 0;
		for(Spieler sp:map.keySet()) {
			if (map.get(sp)>best) {
				best = map.get(sp);
				bestP = new LinkedList<Spieler>();
				bestP.add(sp);
			}
			else if (map.get(sp) == best) {
				bestP.add(sp);
			}
		}
		return bestP;
		
	}
	
}
