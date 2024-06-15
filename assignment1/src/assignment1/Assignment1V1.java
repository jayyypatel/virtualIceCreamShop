package assignment1;
import java.util.ArrayList;
/**
 *
 * @author @harsh
 */
public class Assignment1V1 {

    /**
     * @param args the command line arguments
     * this method is main brain of the program
     */
    public static void main(String[] args) {
        ShopModel shopModel = new ShopModel(8);
        Simulator simulator = new Simulator(shopModel);
        ArrayList<Event> events = new ArrayList<>();

        // Add first ArrivalEvent at time 0
        events.add(new ArrivalEvent(0));
        System.out.println("Simulation Trace:");
        System.out.println("================");
        simulator.initialize(events);
        simulator.run(20); // Run simulation for 20 time units
    }
    
}
