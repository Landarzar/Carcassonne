/**
 * 
 */
package carcassonne.gui;

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

	public HUD(Node guiNode, BitmapFont guiFont, GUIManager app, SpielScreen screen)
	{
		this.guiNode = guiNode;
		this.guiFont = guiFont;
		this.app = app;
		this.screen = screen;

		app.setDisplayFps(true);
		app.setDisplayStatView(false);

		initObjects(app.getAssetManager());
	}

	private Node guiNode;
	private BitmapFont guiFont;
	private GUIManager app;
	private SpielScreen screen;

	private Material material;
	private Geometry geometry;
	private Mesh shape;
	private BitmapText hudText;

	/**
	 * Inititialisiert die GUI objekte
	 */
	private void initObjects(AssetManager assetManager)
	{
		int width = app.getWidth();
		int height = app.getHeight();
		float size = 100f;

		// Test 3d Objekte in der GUI.
		shape = new Box(new Vector3f((float) width - size, (float) height - size, 0f), size, size, 0f);
		geometry = new Geometry("muh", shape);
		material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		material.setTexture("ColorMap", GUIKarte.getRandomTexture());
		material.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
		geometry.setMaterial(material);

		guiNode.attachChild(geometry);

		/** Test HUD */
		hudText = new BitmapText(guiFont, false);
		hudText.setSize(guiFont.getCharSet().getRenderedSize()); // font size
		hudText.setColor(ColorRGBA.Red); // font color
		hudText.setText("72"); // the text
		hudText.setLocalTranslation((float) width - 2 * size, (float) height - 2 * size, 0); // position
		guiNode.attachChild(hudText);
	}

	public void onUpdate()
	{
		GUIKarte card = (GUIKarte) screen.getSpiel().getAktuelleKarte();
		material.setTexture("ColorMap", card.getTexture());
		
		hudText.setText("" +(screen.getSpiel().getKarten().size()-1));
	}
}
