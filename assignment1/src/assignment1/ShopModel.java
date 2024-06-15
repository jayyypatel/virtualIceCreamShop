package assignment1;

import java.util.ArrayList;
import java.util.Formatter;


/**
 * this class handle the multiple methods which is used for statistics
 * @author @harsh
 */
public class ShopModel {
    private ArrayList<CustomerGroup> groups = new ArrayList<>();
    private ArrayList<CustomerGroup> history = new ArrayList<>();
    private int nextId = 0;
    private int numGroups = 0;
    private int numSeats;
    private int numServed = 0;
    private int lostBusiness = 0;

    public ShopModel(int numSeats) {
        this.numSeats = numSeats;
    }
    
    public void addGroup (CustomerGroup g){
        groups.add(g);
        numGroups++;
    }
    
    public void logGroup (CustomerGroup g){
        history.add(g);
    }
     
    public int getNextId(){
         return nextId++;    
    }
    
    public int getNumberServed(){
        return numServed;
    }

    public int getLostBusiness() {
        return lostBusiness;
    }
    
    /**
     * Writes the list of customer groups in the shop at the end of the simulation to a file.
     * @param outputFormatter The formatter to write the data to the file.
     */
    public void showGroups(Formatter outputFormatter) {
        for (CustomerGroup group : groups) {
            outputFormatter.format("%s%n", group);
        }
    }
    
    /**
     * Writes the log of customer groups that arrived during the simulation to a file.
     * @param outputFormatter The formatter to write the data to the file.
     */
    public void showLog(Formatter outputFormatter) {
        for (CustomerGroup group : history) {
            outputFormatter.format("%s%n", group);
        }
    }

    
    /**
     * Serves an ice cream order for the specified customer group at the given time.
     * @param time The time when the order is served.
     * @param g The customer group for which the order is served.
     */
    public void serveOrder(int time, CustomerGroup g) {
        System.out.println("t = " + time + ": Order served for Group " + g.getId());
        numServed += g.getNumberInGroup();
    }
    
    /**
     * Removes the specified customer group from the shop, prints a leave message,
     * and decrements the number of groups in the shop.
     * @param time The time when the group leaves.
     * @param g The customer group leaving the shop.
     */
    public void leave(int time, CustomerGroup g) {
        System.out.println("t = " + time + ": Group " + g.getId() + " leaves");
        numSeats += g.getNumberInGroup();
        groups.remove(g);
        numGroups--;
    }
    
    public boolean canSeat(int time, CustomerGroup group) {
    if (group.getNumberInGroup() <= numSeats) {
        numSeats -= group.getNumberInGroup(); // Decrement the number of available seats
        return true;
    } else {
        lostBusiness += group.getNumberInGroup(); // Increment lost business by the number of people in the group
        return false;
    }
}
}
