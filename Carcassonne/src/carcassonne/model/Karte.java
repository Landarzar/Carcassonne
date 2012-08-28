/**
 * 
 */
package carcassonne.model;

import java.util.LinkedList;

/**
 * @author Fabianexe
 *
 */
public abstract class Karte {

	private int x;
	private int y;
	private SpielObjekt[][] sides = new SpielObjekt[4][3];

	private SpielObjekt middle;
	private int richtung ;
	private boolean[] opensides;
	
	public Karte() {
		this.opensides = new boolean[4];
		for (int i =0; i<4;i++) {
			this.opensides[i] = true;
		}
		this.richtung = 0;
	}
	
	public Karte(SpielObjekt[][] sides, SpielObjekt middle) {
		this.opensides = new boolean[4];
		for (int i =0; i<4;i++) {
			this.opensides[i] = true;
		}
		this.sides = sides;
		this.middle = middle;
		this.richtung = 0;
	}
	
	public void closeSide(int side) {
		this.opensides[side] = false;
	}
	
	
	protected boolean isOside(int kante) {
		return opensides[kante];
	}

	public void setRichtung(int richtung) {
		this.richtung = richtung;	
	}
	
	public void setKordinaten(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int[] getKordinaten() {
		int [] ret = new int[2];
		ret[0] = this.x;
		ret[1] = this.y;
		return ret;
	}
	
	public SpielObjekt[] getSide(int kante)
	{
		int side = (4+kante - this.richtung)%4;
		return this.sides[side];
	}
	
	public SpielObjekt getMiddle() {
		return this.middle;
	}
	/**
	 * @param side0 the side0 to set
	 */
	public void setSide0(SpielObjekt[] side0) {
		this.sides[0] = side0;
	}

	/**
	 * @param side1 the side1 to set
	 */
	public void setSide1(SpielObjekt[] side1) {
		this.sides[1] = side1;
	}

	/**
	 * @param side2 the side2 to set
	 */
	public void setSide2(SpielObjekt[] side2) {
		this.sides[2] = side2;
	}

	/**
	 * @param side3 the side3 to set
	 */
	public void setSide3(SpielObjekt[] side3) {
		this.sides[3] = side3;
	}

	/**
	 * @param middle the middle to set
	 */
	public void setMiddle(SpielObjekt middle) {
		this.middle = middle;
	}
	
	public void merge(Karte[] nachbarn) {
		for(int j=0;j<4;j++) {
			if (nachbarn[j] != null) {
				SpielObjekt[] otherside = nachbarn[j].getSide((2+j)%4);
				for(int i=0;i<3;i++) {
					this.getSide(j)[i].merge(otherside[2-i]);
				}
				this.opensides[j] = false;
			}
		}
	}
	
	protected LinkedList<SpielObjekt[]> getopenSides() {
		LinkedList<SpielObjekt[]> ret = new LinkedList<SpielObjekt[]>();
		for (int i=0; i<4;i++) {
			if (this.opensides[i]) {
				ret.add(this.getSide(i));
			}
		}
		return ret;
	}
	
	protected void scoreAllComplet() {
		for (int i=0; i<4;i++) {
			if (!this.opensides[i]) {
				for (int j=0;j<3;j++) {
					if(this.getSide(i)[j].isComplete()) this.getSide(i)[j].Scoring(false);
				}
				
			}
		} 
	}
	
	protected void scoreAll() {
		for (int i=0; i<4;i++) {
			for (int j=0;j<3;j++) {
				this.sides[i][j].Scoring(true);
			}
		} 
	}
}
