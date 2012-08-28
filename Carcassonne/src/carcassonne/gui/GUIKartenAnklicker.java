/**
 * 
 */
package carcassonne.gui;

import java.awt.Point;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.shape.Box;

/**
 * @author Landarzar
 * 
 */
public class GUIKartenAnklicker
{

	public GUIKartenAnklicker(Point pos, GUIManager gui)
	{
		this.pos = pos;
		
		mesh = new Box(new Vector3f(pos.x * 0.62f, pos.y * 0.62f, 8f), 0.3f, 0.3f, 0.01f);
		geo = new Geometry("muH", mesh);
		material = new Material(gui.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
		material.setColor("Color", ColorRGBA.Blue);
		
		geo.setMaterial(material);
	}

	public Point getPoint()
	{
		return pos;
	}

	/**
	 * @return the pos
	 */
	public Point getPos()
	{
		return pos;
	}

	/**
	 * @param pos the pos to set
	 */
	public void setPos(Point pos)
	{
		this.pos = pos;
	}

	/**
	 * @return the geo
	 */
	public Geometry getGeo()
	{
		return geo;
	}

	/**
	 * @param geo the geo to set
	 */
	public void setGeo(Geometry geo)
	{
		this.geo = geo;
	}

	/**
	 * @return the material
	 */
	public Material getMaterial()
	{
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(Material material)
	{
		this.material = material;
	}

	/**
	 * @return the mesh
	 */
	public Mesh getMesh()
	{
		return mesh;
	}

	/**
	 * @param mesh the mesh to set
	 */
	public void setMesh(Mesh mesh)
	{
		this.mesh = mesh;
	}

	private Point pos;
	private Geometry geo;
	private Material material;
	private Mesh  mesh;
}
