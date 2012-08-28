package carcassonne.model;

/**
 * @author Fabianexe
 *
 */
public class Männchen {
	private Spieler spieler;
	private SpielObjekt objekt;
	private int wert;

	public Männchen(Spieler spieler) {
		this.spieler = spieler;
		this.wert = 1;
	}
	
	public Männchen(Spieler spieler, int wert) {
		this.spieler = spieler;
		this.wert = wert;
	}
	
	public Spieler getSpieler(){
		return this.spieler;
	}
	public void setObjekt(SpielObjekt objekt) {
		this.objekt = objekt;
	}
	
	public SpielObjekt getObjekt() {
		return this.objekt;
	}
	public void release() {
		
	}

	public int getWert() {
		return this.wert;
	}
	 
}
