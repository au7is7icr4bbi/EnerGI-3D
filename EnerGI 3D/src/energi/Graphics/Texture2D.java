/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Graphics;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.opengl.Texture;
import energi.Core.EnergiException;
import java.io.IOException;

/**
 * Represents a texture for a bounding shape
 * @author Andrew
 */
public class Texture2D
{
    Texture texture;
    
    public Texture2D(String filename, String type) throws EnergiException
    {
        try
        {
            texture = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream(filename));
        }
        catch (IOException e)
        {
            throw new EnergiException(e);
        }
    }
    
    public void Draw()
    {
        texture.bind();
        
        // draw the shape, using the texture coordinates, here
    }
    
    public void destroy()
    {
        texture.release();
    }
}