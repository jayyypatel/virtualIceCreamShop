package assignment1;

/**
 * Represents a customer group that arrives at the ice cream shop.
 * Each group has a unique ID, a number of people in the group, and an arrival time.
 * @author @harsh
 */
public class CustomerGroup {
    private int id;
    private int numberInGroup;
    private int arrivalTime;
    
    /**
    constructor used to assign unique id and total number of persons in group 
    and arrival time
    * @param id unique id 
    * @param number total number of people in group
    * @param time arrival time
    */
    public CustomerGroup(int id, int number, int time){
        this.id = id;
        this.numberInGroup = number;
        this.arrivalTime = time;
    }
    
    public int getId(){
       return id;
    }     
    
    public int getNumberInGroup(){
       return numberInGroup;
    }  
    
    public int getArrivalTime(){
       return arrivalTime;
    }
       
    /**
    this toString method overrides the method which is used when 
    we try to print that object
    */
    @Override
           public String toString(){
               return String.format("Group %d (%d people) arrived at t = %d", id, numberInGroup, arrivalTime);  
       }  
}
