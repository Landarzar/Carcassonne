/**
 * 
 */
package carcassonne.model;

/**
 * @author landarzar
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
		int[] kordinaten = this.karte.getKordinaten();
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
	}

	@Override
	public void merge(SpielObjekt other) {
		// Gibt es nicht und wenn doch hast du das Spiel nicht verstanden!

	}

}
