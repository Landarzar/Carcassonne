/**
 * 
 */
package carcassonne.model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Fabianexe
 *
 */
public abstract class SpielObjekt {

	protected LinkedList<Karte> karten;
	protected LinkedList<Männchen> männchen;
	
	protected boolean isscored = false;
	
	protected SpielObjekt(Karte karte)
	{
		this.karten.add(karte);
		this.männchen = new LinkedList<Männchen>();
	}
	
	
	public LinkedList<Karte> getKarten() {
		return karten;
	}


	public abstract void Scoring(boolean ende);
	
	public abstract void merge(SpielObjekt other);
	
	public abstract boolean isComplete();
	
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
				map.put(man.getSpieler(), map.get(man.getSpieler())+man.getWert());
			}
			else {
				map.put(man.getSpieler(), man.getWert());
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
	protected void changeref(SpielObjekt other) {
		for (Karte kat:other.getKarten()) {
			for (int i =0; i< 4; i++) {
				for(int j =0;i<3;j++) {
					if (kat.getSide(i)[j] == other) kat.getSide(i)[j] = this;
				}
			}
			if (kat.getMiddle() == other) kat.setMiddle(this);
		}
	}
	
}
