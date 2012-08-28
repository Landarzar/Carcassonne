package carcassonne.model;

import java.util.LinkedList;

/**
 * @author Fabianexe
 *
 */
public class Wiese  extends SpielObjekt {

	public Wiese(Karte karte) {
		super(karte);
		
		this.städte = new LinkedList<Stadt>();
	}
	
	protected LinkedList<Stadt> städte;


	@Override
	public void merge(SpielObjekt other) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void Scoring(boolean ende) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isComplete() {
		return false;
	}

}
