/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package energi.Input;
import energi.Core.Event;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Vector;
import energi.Core.EnergiException;

/**
 * Represents the input handling thread
 * @author Andrew
 */
final class InputThread extends Thread 
{
    ArrayBlockingQueue<Event> events;
    private boolean terminate = false;
    
    /**
     * Initialise a new InputThread
     */
    public InputThread()
    {
        events = new ArrayBlockingQueue<>(20);
    }
    
    /**
     * Run the input event loop asynchronously
     */
    @Override
    public void run()
    {
        while (!terminate)
        {
            try
            {
                InputDevice.scanEvents();
                processEvent();
            }
            catch (EnergiException e)
            {
                System.out.println(e.getMessage());
                interrupt();
            }
        }
    }

    private void processEvent() throws EnergiException
    {
        try
        {
            Event event = events.take();
            event.triggerEvent();
        }
        catch (InterruptedException e)
        {
            throw new EnergiException(e);
        }
    }
}
