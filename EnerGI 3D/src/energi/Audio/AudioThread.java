/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Audio;
import java.util.concurrent.ArrayBlockingQueue;
import energi.Core.EventHandler;
import energi.Core.EnergiException;

/**
 * Audio playback thread
 * @author Andrew
 */
public class AudioThread extends Thread
{
    boolean terminate = false;
    ArrayBlockingQueue<AudioEvent> eventQueue;
    EventHandler handlers[];
    
    public AudioThread()
    {
        eventQueue = new ArrayBlockingQueue<>(20, false);
        handlers = new EventHandler[4];
    }
    @Override
    public void run()
    {
        try
        {
            // start playing audio, and flag the event as begun
            AudioPlayer.play();
            startEvents();
            // loop for audio events
            while (!terminate)
            {
            }
        }
        catch (EnergiException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private void startEvents() throws EnergiException
    {
        try
        {
            eventQueue.put(new AudioEvent(AudioEvent.EventType.AudioBegin, handlers[0]));
            eventQueue.put(new AudioEvent(AudioEvent.EventType.AudioPlaying, handlers[2]));
        }
        catch (InterruptedException e)
        {
            throw new EnergiException(e);
        }
    }
}
