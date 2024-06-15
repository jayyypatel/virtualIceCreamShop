package assignment1;

/**
 * this class represents the simulation which we have created
 * @author @harsh
 */
import java.util.ArrayList;
import java.io.IOException;
import java.util.Formatter;

public class Simulator implements IScheduler{
    private ArrayList<Event> Events = new ArrayList<>();
    private int clock;
    private ShopModel model;
    
    public Simulator(ShopModel model){
        this.model = model;
    }
    
    public void initialize(ArrayList events){
        this.Events = events;
    }
    
    /**
     * this method will pass model and current object this to process method
     * @param stopTime how much time to end the function
     */
    public void run (int stopTime){
        if (Events == null || Events.isEmpty()){
           return;
        }
        
        Event e = Events.remove(0);
        clock = e.getTime();
        while (clock <= stopTime) {
           
            e.process(model, this);
            if (!Events.isEmpty()) {
                e = Events.remove(0);
                clock = e.getTime();
            }
        }
        
        try (Formatter formatter = new Formatter("statistics.txt")) {
            // Write simulation statistics to the file
            formatter.format("Statistics%n");
            formatter.format("==========%n");
            formatter.format("The Number of people served = %d%n", model.getNumberServed());
            formatter.format("The lost business = %d people %n%n", model.getLostBusiness());
            formatter.format("The following groups are in the shop:%n");
            formatter.format("=====================================%n");
            model.showGroups(formatter);
            formatter.format("%n%nThe following groups are in the history/log:%n");
            formatter.format("===============================================%n");
            model.showLog(formatter);
        } catch (IOException ex) {
            System.err.println("Error writing statistics to file: " + ex.getMessage());
            System.exit(1);
        }
    }
    
    @Override
    public void schedule(Event e) {
        int i = 0;
        while (i < Events.size() && Events.get(i).getTime() <= e.getTime()) {
            i++;
        }
        Events.add(i, e);
    }
}
