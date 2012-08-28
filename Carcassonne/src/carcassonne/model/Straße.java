package carcassonne.model;

/**
 * @author Fabianexe
 *
 */
public class Straße  extends SpielObjekt {
	
	private boolean wirtshaus;
	
	public Straße(Karte karte) {
		super(karte);
		this.wirtshaus = false;
		this.typ = 2;
	}
	
	public Straße(Karte karte, boolean wirtshaus) {
		super(karte);
		this.wirtshaus = wirtshaus;
		this.typ = 2;
	}
	
	protected boolean isWirtshaus() {
		return wirtshaus;
	}

	@Override
	public void merge(SpielObjekt other) {
		if (this == other) return;
		for (Karte kat:other.getKarten()) {
			if (!this.karten.contains(kat)) {
				this.karten.add(kat);
			}
		}
		if (this.wirtshaus || ((Straße)other).isWirtshaus()) {
			this.wirtshaus = true;
		}
		else {
			this.wirtshaus = false;
		}
		this.changeref(other);
		
		
	}


	@Override
	public void Scoring(boolean ende) {
		if (this.isscored) return;
		int sum = 0;
		if (ende) {
			if(!this.wirtshaus) {
				sum  = this.karten.size();
			}
		}
		else {
			sum  = this.karten.size();
			if (this.wirtshaus) {
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
		
	


	@Override
	public boolean isComplete() {
		for(Karte ka:this.karten) {
			for(SpielObjekt[] sOs:ka.getopenSides()){
				for (int i=0;i<3;i++) {
					if (sOs[i] == this) return false;
				}
			}
		}
		return true;
	}

}
