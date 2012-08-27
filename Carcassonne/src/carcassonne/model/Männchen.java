/**
 * 
 */
package carcassonne.model;

/**
 * @author landarzar
 *
 */
public class Männchen {
	private Spieler spieler;
	private SpielObjekt objekt;

	public Männchen(Spieler spieler) {
		this.spieler = spieler;
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
}
