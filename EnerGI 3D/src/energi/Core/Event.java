/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Core;

/**
 * Abstract base class for all events
 * @author Andrew
 */
public abstract class Event
{
    /**
     * Event handler
     */
    protected EventHandler handler;
    /**
     * Indicates if the event has been triggered
     */
    protected boolean triggered;
    
    public abstract void triggerEvent();
}
