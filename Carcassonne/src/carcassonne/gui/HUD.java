/**
 * 
 */
package carcassonne.gui;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.input.controls.ActionListener;
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

	public HUD(Node guiNode, BitmapFont guiFont, GUIManager app)
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
	private GUIManager app;

	/**
	 * Inititialisiert die GUI objekte
	 */
	private void initObjects(AssetManager assetManager)
	{
		int width = app.getWidth();
		int height = app.getHeight();
		float size = 100f;

		// Test 3d Objekte in der GUI.
		Mesh shape = new Box(new Vector3f((float)width - size, (float)height - size, 0f), size, size, 0f);
		Geometry geometry = new Geometry("muh", shape);
		Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		material.setTexture("ColorMap", GUIKarte.getRandomTexture());
		material.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
		geometry.setMaterial(material);
		
		guiNode.attachChild(geometry);
		
		/** Test HUD */
		BitmapText hudText = new BitmapText(guiFont, false);
		hudText.setSize(guiFont.getCharSet().getRenderedSize()); // font size
		hudText.setColor(ColorRGBA.Red); // font color
		hudText.setText("72"); // the text
		hudText.setLocalTranslation((float)width - 2 * size, (float)height - 2 * size, 0); // position
		guiNode.attachChild(hudText);
	}
	
	public void onUpdate()
	{

	}
}
