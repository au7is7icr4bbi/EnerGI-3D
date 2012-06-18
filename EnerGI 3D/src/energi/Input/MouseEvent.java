/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Input;
import energi.Core.*;

/**
 * Encapsulates all mouse events (Buttons, Axis movements)
 * @author Andrew
 */
public class MouseEvent extends Event
{
    public enum ButtonEvent
    {
        LeftButton,
        RightButton,
        MiddleButton,
    }
    
    public enum AxisEvent
    {
        DeltaX,
        DeltaY,
        AbsX,
        AbsY,
        Wheel
    }
    
    public enum ButtonAction
    {
        BUTTONUP,
        BUTTONDOWN
    }
    ButtonAction action;
    AxisEvent aEvent;
    ButtonEvent bEvent;
    
    /**
     * Called when a mouse button event is registered
     * @param handler Event handler
     * @param event The event to look for
     * @param action The event action (ie. button up or button down)
     */
    public MouseEvent(EventHandler handler, ButtonEvent event, ButtonAction action)
    {
        this.handler = handler;
        bEvent = event;
        aEvent = null;
        this.action = action;
    }
    
    /**
     * Called when a mouse axis movement event is registered
     * @param handler Event handler
     * @param event Mouse axis event
     */
    public MouseEvent(EventHandler handler, AxisEvent event)
    {
        action = null;
        this.handler = handler;
        aEvent = event;
        bEvent = null;
    }
    
    public void triggerEvent()
    {
        handleEvent();
    }
}
