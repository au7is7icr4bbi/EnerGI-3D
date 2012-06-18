/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Audio;
import energi.Core.Event;
import energi.Core.EventHandler;

/**
 * Custom event subclass for audio events
 * @author Andrew
 */
public class AudioEvent extends Event 
{
    public enum EventType
    {
        AudioBegin, // beginning of a track
        AudioEnd, // end of a track, regardless of looping
        AudioStopped, // audio stopped playing
        AudioPlaying // audio started playing, regardless of position
    }
    EventType type;
    
    public AudioEvent(EventType e, EventHandler h)
    {
        handler = h;
        type = e;
    }
    
    public void triggerEvent()
    {
        handler.handleEvent();
    }
}
