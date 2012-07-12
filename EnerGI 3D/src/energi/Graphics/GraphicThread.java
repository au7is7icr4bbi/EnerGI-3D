/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Graphics;
import java.util.Vector;

/**
 * Handles the rendering thread
 * @author Andrew
 */
public class GraphicThread extends Thread
{
    /**
     * Execute the rendering thread
     */
    static Vector<Texture2D> textures;
    @Override
    public void run()
    {
        // draw graphics here
        for (Texture2D t : textures)
            t.Draw();
    }
}
