/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Audio;
import java.util.concurrent.ArrayBlockingQueue;
import energi.Core.EventHandler;
import energi.Core.EnergiException;
import energi.Core.Event;

/**
 * Audio playback thread. Manages the audio event loop
 * @author Andrew
 */
public class AudioThread extends Thread
{
    /**
     * Represents the types of events created in this thread
     */
    public enum EventType
    {
        /**
         * Beginning of a track
         */
        AudioBegin,
        /**
         * End of a track
         */
        AudioEnd,
        /**
         * Player stopped
         */
        AudioStopped,
        /**
         * Player started/resumed
         */
        AudioPlaying
    }
    
    boolean terminate = false;
    ArrayBlockingQueue<AudioEvent> eventQueue;
    EventHandler handlers[];
    
    /**
     * Initialize the audio event thread
     */
    public AudioThread()
    {
        eventQueue = new ArrayBlockingQueue<>(20, false);
        handlers = new EventHandler[4];
    }
    
    /**
     * Run the audio event loop in this asynchronous thread
     */
    @Override
    public void run()
    {
        try
        {
            // start playing audio, and send a begin and playing event
            AudioPlayer.play();
            startEvents();
            
            // loop for audio events
            while (!terminate)
            {
                processEvent();
            }
        }
        catch (EnergiException e)
        {
            System.out.println(e.getMessage());
            interrupt();
        }
    }
    
    /**
     * Place the starting events
     * @throws EnergiException 
     */
    private void startEvents() throws EnergiException
    {
        try
        {
            eventQueue.put(new AudioEvent(EventType.AudioBegin, handlers[0]));
            eventQueue.put(new AudioEvent(EventType.AudioPlaying, handlers[2]));
        }
        catch (InterruptedException e)
        {
            throw new EnergiException(e);
        }
    }
    
    /**
     * Process a single event. Blocks while the queue is empty
     * @throws EnergiException 
     */
    private void processEvent() throws EnergiException
    {
        try
        {
            AudioEvent event = eventQueue.take();
            event.triggerEvent();
        }
        catch (InterruptedException e)
        {
            throw new EnergiException(e);
        }
    }
    
    /**
     * Register a new event handler
     * @param e The event handler
     * @param type The audio event you wish to handle
     */
    public void registerEvent(EventHandler e, EventType type)
    {
        switch (type)
        {
            case AudioBegin:
                handlers[0] = e;
                break;
            case AudioEnd:
                handlers[1] = e;
                break;
            case AudioPlaying:
                handlers[3] = e;
                break;
            case AudioStopped:
                handlers[2] = e;
                break;
        }
    }
    
    /**
     * Send an event to the thread from the audio player.
     * @param type The event type
     * @throws EnergiException 
     */
    public void sendEvent(EventType type) throws EnergiException
    {
        try
        {
            eventQueue.put(new AudioEvent(type, handlers[type.ordinal()]));
        }
        catch (InterruptedException e)
        {
            throw new EnergiException(e);
        }
    }
}

/**
 * Custom event subclass for audio events
 * @author Andrew
 */
class AudioEvent extends Event 
{
    /**
     * Defines the event types
     */
    AudioThread.EventType type;
    
    /**
     * Create a new audio event
     * @param e The 
     * @param h 
     */
    public AudioEvent(AudioThread.EventType e, EventHandler h)
    {
        handler = h;
        type = e;
    }
    
    /**
     * Trigger the event handler if there is one
     */
    public void triggerEvent()
    {
        if (handler != null)
            handler.handleEvent();
    }
}
