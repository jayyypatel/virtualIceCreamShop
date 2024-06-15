package assignment1;

/**
 * Represents a leave event in the ice cream shop simulation.
 * Leave events occur after customer groups have received their orders and exit the shop.
 * @author harsh
 */
public class LeaveEvent extends Event {
     private CustomerGroup group;
     
     /**
     * Constructs a LeaveEvent for the specified time and customer group.
     * @param time The time of the leave event.
     * @param group The customer group associated with the leave event.
     */
    public LeaveEvent(int time, CustomerGroup group) {
        super(time);
        this.group = group;
    }
    
     /**
     * Processes the leave event, making the associated customer group to leave the shop.
     * @param shopModel The shop model to update.
     * @param scheduler The scheduler to schedule future events.
     */
    @Override
    public void process(ShopModel shopModel, IScheduler scheduler) {
        shopModel.leave(getTime(), group);
    }
     
}
