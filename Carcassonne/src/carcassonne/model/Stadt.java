package carcassonne.model;

import java.util.LinkedList;

/**
 * @author Fabianexe
 *
 */
public class Stadt  extends SpielObjekt{
	
	public Stadt(Karte karte) {
		super(karte);

		this.wiesen = new LinkedList<Wiese>();
	}
	
	protected LinkedList<Wiese> wiesen;

	public boolean isComplete()
	{
		throw new UnsupportedOperationException("Not implemented jet.");
	}


	@Override
	public void merge(SpielObjekt other) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Scoring(boolean ende) {
		// TODO Auto-generated method stub
		
	}
}