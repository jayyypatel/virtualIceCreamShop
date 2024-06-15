package assignment1;

/**
 * Represents an order event in the ice cream shop simulation.
 * Orders are scheduled after customer groups arrive and enter the shop
 * @author harsh
 */
public class OrderEvent extends Event {
    private CustomerGroup group;
    private int leaveLowerBound = 5;
    private int leaveGeneratorBound = 12;
    
    /**
     * Constructs an OrderEvent for the specified time and customer group.
     * @param time The time of the order event.
     * @param group The customer group associated with the order.
     */
    public OrderEvent(int time, CustomerGroup group) {
        super(time);
        this.group = group;
    }
    
    /**
     * Processes the order event, serving ice cream for the related customer group
     * and scheduling a leave event for the group 10 time units later.
     * @param shopModel The shop model to serve the order.
     * @param scheduler The scheduler to schedule future events.
     */
    @Override
    public void process(ShopModel shopModel, IScheduler scheduler) {
        shopModel.serveOrder(getTime(), group);
        scheduler.schedule(new LeaveEvent(getTime() + (generator.nextInt(leaveGeneratorBound) + leaveLowerBound), group));
    }
}
