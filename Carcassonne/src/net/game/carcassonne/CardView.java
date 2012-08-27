package net.game.carcassonne;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.material.RenderState.BlendMode;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;

/**
 *
 * @author Landarzar
 */
public class CardView {

    private Box shape;
    private Geometry geometry;
    private Material material;
    private Texture texture;

    public Geometry getGeometry() {
        return geometry;
    }

    public Material getMaterial() {
        return material;
    }

    public Box getShape() {
        return shape;
    }

    public Texture getTexture() {
        return texture;
    }

    public CardView(Texture texture) {
        this.texture = texture;
        this.init = false;
    }
    
    private boolean init = false;

    public void initCard(AssetManager assetManager, Node node, float x, float y) {
        shape = new Box(new Vector3f(x, y, 8f), 0.3f, 0.3f, 0.01f);
        geometry = new Geometry(texture.getName(), shape);
        material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setTexture("ColorMap", texture);
        material.getAdditionalRenderState().setBlendMode(BlendMode.Alpha);
        geometry.setMaterial(material);
        init = true;
        
        node.attachChild(geometry);
    }

    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
