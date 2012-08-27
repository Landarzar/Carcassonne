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
	private SpielObjekt[] side0;
	private SpielObjekt[] side1;
	private SpielObjekt[] side2;
	private SpielObjekt[] side3;
	private SpielObjekt middle;
	
	public SpielObjekt[] getSide0()
	{
		return side0;
	}
	
	public SpielObjekt[] getSide1()
	{
		return side1;
	}
	
	public SpielObjekt[] getSide2()
	{
		return side2;
	}
	
	public SpielObjekt[] getSide3()
	{
		return side3;
	}
	
	public SpielObjekt getMiddle()
	{
		return middle;
	}

	/**
	 * @param side0 the side0 to set
	 */
	public void setSide0(SpielObjekt[] side0) {
		this.side0 = side0;
	}

	/**
	 * @param side1 the side1 to set
	 */
	public void setSide1(SpielObjekt[] side1) {
		this.side1 = side1;
	}

	/**
	 * @param side2 the side2 to set
	 */
	public void setSide2(SpielObjekt[] side2) {
		this.side2 = side2;
	}

	/**
	 * @param side3 the side3 to set
	 */
	public void setSide3(SpielObjekt[] side3) {
		this.side3 = side3;
	}

	/**
	 * @param middle the middle to set
	 */
	public void setMiddle(SpielObjekt middle) {
		this.middle = middle;
	}
}
