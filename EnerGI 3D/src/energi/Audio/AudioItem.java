/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;
import energi.Core.EnergiException;
import java.io.IOException;
import org.newdawn.slick.openal.Audio;

/**
 *
 * @author Andrew
 */
public class AudioItem
{
    Audio audio;
    boolean looping;
    
    public AudioItem(String filename, String type, boolean loop) throws EnergiException
    {
        try
        {
            audio = AudioLoader.getAudio(type, ResourceLoader.getResourceAsStream(filename));
        }
        catch (IOException e)
        {
            throw new EnergiException(e);
        }
        looping = loop;
    }
    
    public void play()
    {
        audio.playAsMusic(0, 0, looping);
    }
    
    public void pause()
    {
        audio.stop();
    }
}
