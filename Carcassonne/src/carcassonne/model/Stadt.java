package carcassonne.model;

import java.util.LinkedList;

/**
 * @author Fabianexe
 *
 */
public class Stadt  extends SpielObjekt{
	protected LinkedList<Wiese> wiesen;
	private boolean kathedrale;
	private int wappen;
	
	
	public Stadt(Karte karte, int wappen, Wiese[] wiesen) {
		super(karte);

		this.wiesen = new LinkedList<Wiese>();
		for (Wiese wi:wiesen) {
			this.wiesen.add(wi);
		}
		this.wappen = wappen;
		this.kathedrale = false;
	}
	
	public Stadt(Karte karte, int wappen, boolean kathedrale) {
		super(karte);

		this.wiesen = new LinkedList<Wiese>();
		this.wappen = wappen;
	}
	
	public boolean isComplete()
	{
		for(Karte ka:this.karten) {
			for(SpielObjekt[] sOs:ka.getopenSides()){
				for (int i=0;i<3;i++) {
					if (sOs[i] == this) return false;
				}
			}
		}
		return true;
	}


	@Override
	public void merge(SpielObjekt other) {
		if (this == other) return;
		for (Karte kat:other.getKarten()) {
			if (!this.karten.contains(kat)) {
				this.karten.add(kat);
			}
		}
		for (Wiese wi:((Stadt)other).getWiesen()) {
			if (!this.wiesen.contains(wi)) {
				this.wiesen.add(wi);
			}
		}
		this.wappen += ((Stadt)other).getWappen();
		if (this.kathedrale || ((Stadt)other).isKathedrale()) {
			this.kathedrale = true;
		}
		else {
			this.kathedrale = false;
		}
		this.changeref(other);
	}

	@Override
	public void Scoring(boolean ende) {
		if (this.isscored) return;
		int sum = 0;
		if (ende) {
			if(!this.kathedrale) {
				sum  = this.wappen +this.karten.size();
			}
		}
		else {
			sum  = this.wappen +this.karten.size();
			if (this.kathedrale) {
				sum *= 3;
			}
			else {
				sum *= 2;
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

	protected LinkedList<Wiese> getWiesen() {
		return wiesen;
	}

	protected int getWappen() {
		return wappen;
	}

	protected boolean isKathedrale() {
		return kathedrale;
	}
	
	
}