package assignment1;
import java.util.Random;

/**
 * Represents an event in the ice cream shop simulation.
 * Events include arrivals, orders, and leave
 * @author @harsh
 */
public abstract class Event {
    private int time;
    protected static Random generator = new Random(1);

    public Event(int time){
        this.time= time;
    }
    
    public int getTime(){
        return time;
    }
    
    public Random getGenerator() {
        return generator;
    }
    
    /**
     * this is abstract method which will be used in all child classes of 
     * event class
     * @param shopModel
     * @param scheduler 
     */
    public abstract void process(ShopModel shopModel, IScheduler scheduler);
        
    
}
