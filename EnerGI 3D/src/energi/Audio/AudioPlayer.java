/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Audio;
import java.util.LinkedList;

/**
 * Stores a queue of audio items for sequential playback
 * @author Andrew
 */
public class AudioPlayer
{
    static LinkedList<AudioItem> audio;
    static int pos;
    
    private AudioPlayer() {
        audio = new LinkedList<>();
        pos = 0;
    }
    
    public static AudioPlayer getInstance() {
        return AudioPlayerHolder.INSTANCE;
    }
    
    private static class AudioPlayerHolder {

        private static final AudioPlayer INSTANCE = new AudioPlayer();
    }
    
    /**
     * Start playback of the item at the top of the queue
     */
    public static void play()
    {
        audio.get(pos).play();
    }
    
    /**
     * Stop playback of a particular audio item in the queue
     * @param position the position in the queue
     */
    public static void stop(int position)
    {
        audio.get(pos).pause();
    }
    
    /**
     * Stop playback of all sounds
     */
    public static void stopAll()
    {
        for (AudioItem i : audio)
        {
            i.pause();
        }
    }
}
