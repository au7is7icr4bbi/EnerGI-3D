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
import energi.Core.Asset;

/**
 * Represents an audio item loaded from a system resource
 * @author Andrew
 */
public class AudioItem
{
    Audio audio;
    boolean looping;
    
    /**
     * Create a new audio item from a system resource. Called by
     * @param filename The audio file name
     * @param type The file type
     * @param loop Boolean indicating if the sound will loop
     * @throws EnergiException 
     */
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
    
    /**
     * Play the audio
     */
    public void play()
    {
        audio.playAsMusic(0, 0, looping);
    }
    
    /**
     * Pause the audio
     */
    public void pause()
    {
        audio.stop();
    }
}
