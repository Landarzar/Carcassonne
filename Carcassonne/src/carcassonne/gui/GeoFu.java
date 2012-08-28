package carcassonne.gui;

import java.awt.Point;

import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;

public class GeoFu extends Geometry
{

	public GeoFu(Point pos, String name, Mesh mesh)
	{
		super(name, mesh);
		this.pos = pos;
	}

	private Point pos;

	/**
	 * @return the karte
	 */
	public Point getPosition()
	{
		return pos;
	}

}
