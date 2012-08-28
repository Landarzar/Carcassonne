/**
 * 
 */
package carcassonne.model;

/**
 * @author Fabianexe
 * 
 */
public class Kloster extends SpielObjekt {

	/**
	 * @param karte
	 */
	public Kloster(Karte karte) {
		super(karte);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see carcassonne.model.SpielObjekt#Scoring()
	 */
	@Override
	public void Scoring(boolean ende) {
		if (this.isscored) return;
		int[] kordinaten = this.karten.getFirst().getKordinaten();
		int sum = 1;
		if (Spiel.getInstance().hasPosi(kordinaten[0]-1, kordinaten[1]-1)) sum +=1;
		if (Spiel.getInstance().hasPosi(kordinaten[0], kordinaten[1]-1)) sum +=1;
		if (Spiel.getInstance().hasPosi(kordinaten[0]+1, kordinaten[1]-1)) sum +=1;
		if (Spiel.getInstance().hasPosi(kordinaten[0]-1, kordinaten[1])) sum +=1;
		if (Spiel.getInstance().hasPosi(kordinaten[0]+1, kordinaten[1])) sum +=1;
		if (Spiel.getInstance().hasPosi(kordinaten[0]-1, kordinaten[1]+1)) sum +=1;
		if (Spiel.getInstance().hasPosi(kordinaten[0], kordinaten[1]+1)) sum +=1;
		if (Spiel.getInstance().hasPosi(kordinaten[0]+1, kordinaten[1]+1)) sum +=1;
		for(Spieler sp:this.getBesitzer()) {
			sp.addPunkte(sum);
		}
		for(Männchen man:this.männchen) {
			man.release();
		}
		this.isscored = true;
	}

	@Override
	public void merge(SpielObjekt other) {
		// Gibt es nicht und wenn doch hast du das Spiel nicht verstanden!

	}

	@Override
	public boolean isComplete() {
		int[] kordinaten = this.karten.getFirst().getKordinaten();
		if (!Spiel.getInstance().hasPosi(kordinaten[0]-1, kordinaten[1]-1)) return false;
		if (!Spiel.getInstance().hasPosi(kordinaten[0], kordinaten[1]-1)) return false;
		if (!Spiel.getInstance().hasPosi(kordinaten[0]+1, kordinaten[1]-1)) return false;
		if (!Spiel.getInstance().hasPosi(kordinaten[0]-1, kordinaten[1])) return false;
		if (!Spiel.getInstance().hasPosi(kordinaten[0]+1, kordinaten[1])) return false;
		if (!Spiel.getInstance().hasPosi(kordinaten[0]-1, kordinaten[1]+1)) return false;
		if (!Spiel.getInstance().hasPosi(kordinaten[0], kordinaten[1]+1)) return false;
		if (!Spiel.getInstance().hasPosi(kordinaten[0]+1, kordinaten[1]+1)) return false;
		return true;
	}

}
