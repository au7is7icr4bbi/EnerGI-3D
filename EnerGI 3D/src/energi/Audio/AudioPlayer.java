/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Audio;
import java.util.LinkedList;
import energi.Core.EnergiException;

/**
 * Stores a queue of audio items for sequential playback
 * @author Andrew
 */
public final class AudioPlayer
{
    static LinkedList<AudioItem> audio;
    static int pos;
    static AudioThread thread;
    
    /**
     * Initialise the audio player
     */
    private AudioPlayer(AudioThread t) {
        thread = t;
        audio = new LinkedList<>();
        pos = 0;
    }
    
    /**
     * Initialize the audio player and audio event thread
     */
    public static void Initialize()
    {
        thread = new AudioThread();
        audio = new LinkedList<>();
        pos = 0;
        thread.start();
    }
    
    /**
     * Start playback of the item at the top of the queue, and send a playing event
     */
    public static void play() throws EnergiException
    {
        audio.get(pos).play();
        thread.sendEvent(AudioThread.EventType.AudioPlaying);
    }
    
    /**
     * Stop playback of a particular audio item in the queue, and send a stopped event
     * @param position the position in the queue
     */
    public static void stop(int position) throws EnergiException
    {
        audio.get(pos).pause();
        thread.sendEvent(AudioThread.EventType.AudioStopped);
    }
    
    /**
     * Stop playback of all sounds, and send a stopped event
     */
    public static void stopAll() throws EnergiException
    {
        for (AudioItem i : audio)
        {
            i.pause();
        }
        thread.sendEvent(AudioThread.EventType.AudioStopped);
    }
    
    /**
     * Move to the next song, sending the necessary events
     * @throws EnergiException 
     */
    public void nextSong() throws EnergiException
    {
        audio.get(pos).pause();
        thread.sendEvent(AudioThread.EventType.AudioEnd);
        pos++;
        audio.get(pos).play();
        thread.sendEvent(AudioThread.EventType.AudioBegin);
        thread.sendEvent(AudioThread.EventType.AudioPlaying);
    }
}
