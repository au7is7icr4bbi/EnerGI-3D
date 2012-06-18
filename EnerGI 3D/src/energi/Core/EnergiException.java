/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Core;
import org.lwjgl.LWJGLException;
import java.io.IOException;

/**
 * Encapsulates all exception types
 * @author Andrew
 */
public class EnergiException extends Throwable
{
    public enum Action
    {
        CONTINUE,
        EXIT,
        CUSTOM
    }
    private EventHandler handler;
    private Action action;
    private String message;
    public EnergiException(Throwable t)
    {
        if (t instanceof LWJGLException)
            this.message = "LWJGL Exception: " + t.getMessage();
        else
            this.message = "IO Exception: " + t.getMessage();
        this.handler = null;
        this.action = Action.EXIT;
    }
    
    public EnergiException(String message, Action a, EventHandler e)
    {
        handler = e;
        action = a;
        this.message = "EnerGI Exception: " + message;
    }
    
    @Override
    public String getMessage()
    {
        return message;
    }
    
    public Action getAction()
    {
        return action;
    }
    
    public void handleEvent()
    {
        handler.handleEvent();
    }
}
