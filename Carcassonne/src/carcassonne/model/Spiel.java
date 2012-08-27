/**
 * 
 */
package carcassonne.model;

import java.util.HashMap;

/**
 * @author landarzar
 *
 */
public class Spiel {

	public Spiel() {
		map = new HashMap<Integer, Karte>();
	}
	
	HashMap<Integer, Karte> map;
	
	private static final int MOD = 1000;
	
	public boolean insertKarte(int x, int y,Karte karte)
	{
		if(map.containsKey(calcKey(x, y)))
			return false;
		
		map.put(calcKey(x, y), karte);
		return true;
	}

    private static Integer calcKey(int x, int y) {
        return (Integer) (MOD * x) + y;
    }
}
