package carcassonne.model;

/**
 * @author Fabianexe
 *
 */
public class Spieler {
	
	protected int punkte;
	protected String name;
	
	public Spieler(String name) {
		super();
		this.punkte = 0;
		this.name = name;
	}
	public int getPunkte() {
		return punkte;
	}
	public void addPunkte(int punkte) {
		this.punkte += punkte;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
