package carcassonne.model;

import java.util.LinkedList;

/**
 * @author Fabianexe
 *
 */
public class Wiese  extends SpielObjekt {

	public Wiese(Karte karte) {
		super(karte);
		
		this.städte = new LinkedList<Stadt>();
		this.typ = 1;
	}
	
	protected LinkedList<Stadt> städte;


	@Override
	public void merge(SpielObjekt other) {
		if (this == other) return;
		for (Karte kat:other.getKarten()) {
			if (!this.karten.contains(kat)) {
				this.karten.add(kat);
			}
		}
		for (Stadt st:((Wiese)other).getStädte()) {
			if (!this.städte.contains(st)) {
				this.städte.add(st);
			}
		}
		for(Stadt st:this.städte) {
			if (st.getWiesen().contains(other)) st.getWiesen().remove(other);
			if(!st.getWiesen().contains(this)) st.getWiesen().add(this);
		}
		
		this.changeref(other);
	}
		


	public void setStädte(Stadt[] städte) {
		for(Stadt st:städte) {
			this.städte.add(st);
		}
	}


	protected LinkedList<Stadt> getStädte() {
		return städte;
	}


	@Override
	public void Scoring(boolean ende) {
		if (this.isscored) return;
		int sum = 0;
		for(Stadt st:this.städte) {
			if (st.getComplet()){
				sum += 3;
			}
		}
		
		
		for(Spieler sp:this.getBesitzer()) {
			sp.addPunkte(sum);
		}
		for(Männchen man:this.männchen) {
			man.release();
		}
		this.isscored = true;
		
	}


	@Override
	public boolean isComplete() {
		return false;
	}

}
