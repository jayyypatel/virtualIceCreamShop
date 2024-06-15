package assignment1;


/**
 * @author @harsh
 */
public class ArrivalEvent extends Event{
    private int groupLowerBound = 1;
    private int groupGeneratorBound = 4;
    private int orderLowerBound = 1;
    private int orderGeneratorBound = 5;
    /**
    * Constructs an ArrivalEvent with the specified time.
    * @param time The time of the arrival event.
    */
    public ArrivalEvent (int time){
        super(time);
    }
    
    /**
    * Processes the arrival event, adding a new customer group to the shop model,
    * add to logGroup and addGroup it, and scheduling the next arrival event.
    * @param shopModel The shop model to update.
    * @param scheduler The scheduler to schedule the next event.
    */
    @Override
    public void process(ShopModel shopModel, IScheduler scheduler){
        int groupId = shopModel.getNextId();
        CustomerGroup newGroup = new CustomerGroup(groupId, generator.nextInt(groupGeneratorBound) + groupLowerBound, getTime());
        shopModel.logGroup(newGroup);
        shopModel.addGroup(newGroup);
        System.out.println("t = " + getTime() + ": group " + groupId + " <" + newGroup.getNumberInGroup() + " people> arrived");

        // Check if there are enough seats available
        if (shopModel.canSeat(getTime(), newGroup)) {
            // If there are enough seats, seat the group
            System.out.println("t = " + getTime() + ": Group " + groupId + " (" + newGroup.getNumberInGroup() + " people) seated");
            // Schedule the OrderEvent one time unit after the group arrives
            scheduler.schedule(new OrderEvent(getTime() + (generator.nextInt(orderGeneratorBound) + orderLowerBound), newGroup));
        } else {
            // If there are insufficient seats, the group leaves
            System.out.println("t = " + getTime() + ": Group " + groupId + " (" + newGroup.getNumberInGroup() + " people) leaves as there are insufficient seats for the group");
        }
        // Schedule the next arrival event
        scheduler.schedule(new ArrivalEvent(getTime() + 2));
    }


}
