/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Core;
import java.util.Vector;
import org.lwjgl.opengl.Display;
import org.lwjgl.LWJGLException;
import energi.Input.InputDevice;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import static org.lwjgl.opengl.GL11.*;

/**
 * Represents the game instance
 * @author Andrew
 */
public abstract class Game extends DrawableGameObject
{
    Vector <GameObject> gameObjects;
    boolean redisplay = true;
    /**
     * Initialize the game and all registered game objects
     * @throws EnergiException 
     */
    @Override
    public void Initialize() throws EnergiException
    {
        try
        {
            Display.create();
            AL.create();
        }
        catch (LWJGLException e)
        {
            throw new EnergiException(e);
        }
        InputDevice.Initialize();
        
        for (GameObject g : gameObjects)
            g.Initialize();
        
        GLInit();
    }
    
    private void GLInit()
    {
        glOrtho(-300.0f, 300.0f, -300.0f, 300.0f, 300.0f, -300.0f);
    }
    
    @Override
    public void Update()
    {
        for (GameObject g : gameObjects)
            g.Update();
    }
    
    @Override
    public void Draw() throws EnergiException
    {
        for (GameObject g : gameObjects)
            if (g instanceof DrawableGameObject)
                ((DrawableGameObject)g).Draw();
        Display.update();
        Display.sync(60);
        redisplay = false;
    }
    
    /**
     * Run the game loop until the display is closed
     */
    public final void run()
    {
        try
        {
            Initialize();
            while (!Display.isCloseRequested())
            {
                Update();
                
                // only redisplay if the game has been flagged for view redisplay.
                // Any visible object movement (or camera movement) will 
                // necessitate a redisplay
                if (redisplay)
                    Draw();
            }
        }
        catch (EnergiException e)
        {
            System.out.println(e.getMessage());
            if (e.getAction() == EnergiException.Action.EXIT)
                // call our custom exit command to properly destroy the resources
                exit(-1);
            else if (e.getAction() == EnergiException.Action.CUSTOM)
                // utilise a custom event handler. Ideal for managing deallocations
                e.handleEvent();
            // otherwise, it continues regardless. Ideal for trivial errors that
            // are unlikely to break the game
        }
        Display.destroy();
        Keyboard.destroy();
        Mouse.destroy();
        AL.destroy();
    }
    
    private void exit(int retVal)
    {
        Display.destroy();
        Keyboard.destroy();
        Mouse.destroy();
        AL.destroy();
        System.exit(retVal);
    }
}
