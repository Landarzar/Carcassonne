/**
 * 
 */
package carcassonne.gui;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 * 
 * Diese Klasse repräsentiert das HUD
 * 
 * @author Landarzar
 * 
 */
public class HUD
{

	public HUD(Node guiNode, BitmapFont guiFont, Main app)
	{
		this.guiNode = guiNode;
		this.guiFont = guiFont;
		this.app = app;

		app.setDisplayFps(true);
		app.setDisplayStatView(false);

		initObjects(app.getAssetManager());
	}

	private Node guiNode;
	private BitmapFont guiFont;
	private Main app;

	/**
	 * Inititialisiert die GUI objekte
	 */
	private void initObjects(AssetManager assetManager)
	{
		/** Test HUD */
		BitmapText hudText = new BitmapText(guiFont, false);
		hudText.setSize(guiFont.getCharSet().getRenderedSize()); // font size
		hudText.setColor(ColorRGBA.Blue); // font color
		hudText.setText("You can write any string here"); // the text
		hudText.setLocalTranslation(300, hudText.getLineHeight(), 0); // position
		guiNode.attachChild(hudText);

		int width = app.getWidth();
		int height = app.getHeight();
		float size = 100f;

		// Test 3d Objekte in der GUI.
		Mesh shape = new Box(new Vector3f((float)width - size, (float)height - size, 0f), size, size, 0f);
		Geometry geometry = new Geometry("muh", shape);
		Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		material.setTexture("ColorMap", CardFactory.getTexture());
		material.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
		geometry.setMaterial(material);
		
		guiNode.attachChild(geometry);
	}

	public void onUpdate()
	{

	}
}
