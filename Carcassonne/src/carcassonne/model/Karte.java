/**
 * 
 */
package carcassonne.model;

/**
 * @author landarzar
 *
 */
public abstract class Karte {

	private int x;
	private int y;
	private SpielObjekt[][] sides = new SpielObjekt[4][3];

	private SpielObjekt middle;
	private int richtung ;
	
	public void setRichtung(int richtung) {
		this.richtung = richtung;	
	}
	
	public void setKordinaten(int x, int y) {
		this.x = x;
		this.y = y;
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
				for(int i=0;i<4;i++) {
					this.sides[j][i].merge(otherside[i]);
				}
			}
		}
	}
}
