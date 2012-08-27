/**
 * 
 */
package carcassonne.model;

import java.util.LinkedList;

/**
 * @author landarzar
 *
 */
public abstract class SpielObjekt {

	protected Karte karte;
	protected LinkedList<Männchen> männchen;
	
	protected SpielObjekt(Karte karte)
	{
		this.karte = karte;
		this.männchen = new LinkedList<Männchen>();
	}
	
	
	public abstract void Scoring();
}
