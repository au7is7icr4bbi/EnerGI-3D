/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Core;

/**
 *
 * @author Andrew
 */
public abstract class Event
{
    protected EventHandler handler;
    protected boolean triggered;
    protected void handleEvent()
    {
        if (triggered)
            handler.handleEvent();
    }
}
