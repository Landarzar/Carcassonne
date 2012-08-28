/**
 * 
 */
package carcassonne.gui;

/**
 * @author Landarzar
 * 
 */
public class GUIKartenAnklicker extends Triangle
{

	public GUIKartenAnklicker(GUIKarte karte, int seite, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3)
	{
		super(x1, y1, z1, x2, y2, z2, x3, y3, z3);

		this.karte = karte;
		this.seite = seite;
	}

	public GUIKarte getKarte()
	{
		return karte;
	}

	public void setKarte(GUIKarte karte)
	{
		this.karte = karte;
	}

	public int getSeite()
	{
		return seite;
	}

	public void setSeite(int seite)
	{
		this.seite = seite;
	}

	private GUIKarte karte;
	private int seite;
}
