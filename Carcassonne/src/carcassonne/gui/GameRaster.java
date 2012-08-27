/**
 * 
 */
package carcassonne.gui;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import java.util.HashMap;

/**
 *
 * @author landarzar
 */
public class GameRaster {

    private HashMap<Integer, CardView> map;
    private static final int MOD = 1000;
    private AssetManager assetManager;

    private static Integer calcKey(int x, int y) {
        return (Integer) (MOD * x) + y;
    }
    
    private Node node;

    public GameRaster(AssetManager assetM, Node node) {
        map = new HashMap<Integer, CardView>();
        this.assetManager = assetM;
        this.node = node;
    }

    public boolean insert(int x, int y, CardView card) {
        if (isSet(x, y)) {
            return false;
        }
        
        card.initCard(assetManager, node, x * 0.62f, y * 0.62f);

        return true;
    }

    public void remove(int x, int y) {
        map.remove(calcKey(x, y));
    }

    public void remove(CardView view) {
        // TODO: implement

        throw new UnsupportedOperationException("Not implemented jet");
    }

    public boolean isSet(int x, int y) {
        return map.containsKey(calcKey(x, y));
    }

    public CardView get(int x, int y) {
        return map.get(calcKey(x, y));
    }

    public boolean contains(CardView view) {
        return map.containsValue(view);
    }
    
    public void update()
    {
    }
}
