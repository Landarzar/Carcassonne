/**
 * 
 */
package carcassonne.model;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Fabianexe
 *
 */
public class Spiel {

	HashMap<Integer, Karte> map;
	
	private static final int MOD = 1000;
	private Stack<Karte> kartenstapel;
	
	public Spiel(Stack<Karte> kartenstapel) {
		map = new HashMap<Integer, Karte>();
		this.kartenstapel = kartenstapel;
		this.insertKarte(0, 0, this.kartenstapel.pop());
	}
	
	private void insertKarte(int x, int y,Karte karte)
	{

		map.put(calcKey(x, y), karte);
	}

    private static Integer calcKey(int x, int y) {
        return (Integer) (MOD * x) + y;
    }
    
    public Karte getAktuelleKarte() {
		return this.kartenstapel.peek();
	}
    /**
     Legt die aktuelle karte auf position x,y mit ausrichtung z und entfernt sie vom kartenstapel
     @param x ist die x Kordinate der aktuellen Karte
     @param y ist die y Karte der aktullen Karte
     @param z ist die Ausrichtung der aktuellen Karte wobei 0 nicht gedreht ist und x ist x mal nach rechts gedreht.
     @return true wenn einf�gen erfolgreich ansonsten False
    **/
    public boolean put(int x, int y, int z) {
    	if(map.containsKey(calcKey(x, y)))
			return false;
		
    	Karte aktKarte = this.kartenstapel.pop();
    	aktKarte.setRichtung(z);
    	this.insertKarte(x, y, aktKarte);
    	aktKarte.setKordinaten(x, y);
		Karte[] nachbarn = new Karte[4];
		if(map.containsKey(calcKey(x, y-1))) 
			nachbarn[0] = null;
		else nachbarn[0] =map.get(calcKey(x, y-1));
		if(map.containsKey(calcKey(x+1, y))) 
			nachbarn[1] = null;
		else nachbarn[1] =map.get(calcKey(x+1, y));
		if(map.containsKey(calcKey(x, y+1))) 
			nachbarn[2] = null;
		else nachbarn[2] =map.get(calcKey(x, y+1));
		if(map.containsKey(calcKey(x-1, y))) 
			nachbarn[3] = null;
		else nachbarn[3] =map.get(calcKey(x-1, y));
		
    	aktKarte.merge(nachbarn);
		return true;
	}
}
