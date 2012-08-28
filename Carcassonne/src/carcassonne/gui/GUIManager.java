package carcassonne.gui;

import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapFont;
import com.jme3.input.MouseInput;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;

public class GUIManager extends SimpleApplication
{

	public GUIManager(AppSettings settings)
	{
		this.settings = settings;
		spielScreen = new SpielScreen(this);
	}
	
    public int getHeight()
    {
    	return settings.getHeight();
    }
    
    public int getWidth()
    {
    	return settings.getWidth();
    }
    
    private SpielScreen spielScreen;
    
    public BitmapFont getGUIFont()
    {
    	return this.guiFont;
    }
    
    public MouseInput getMouseInput()
    {
    	return mouseInput;    	
    }
    
    Node n,n2;

	@Override
	public void simpleInitApp()
	{
        flyCam.setEnabled(false);
		spielScreen.init(this.guiFont);
	}
	
    @Override
    public void simpleUpdate(float tpf) 
    {	
    	this.rootNode.updateGeometricState();
    	spielScreen.simpleUpdate(tpf);

    }	
}
