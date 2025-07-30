import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;


public class Ride implements RideInterface {
    private String rideName;
    private int minHeightRequirement;
    private Employee rideOperator;

    private Queue<Visitor> visitorQueue;
    private List<Visitor> rideHistory;

    public Ride() {
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }

    public Ride(String rideName, int minHeightRequirement, Employee rideOperator) {
        this.rideName = rideName;
        this.minHeightRequirement = minHeightRequirement;
        this.rideOperator = rideOperator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }

    // Getters and setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public int getMinHeightRequirement() { return minHeightRequirement; }
    public void setMinHeightRequirement(int minHeightRequirement) { this.minHeightRequirement = minHeightRequirement; }

    public Employee getRideOperator() { return rideOperator; }
    public void setRideOperator(Employee rideOperator) { this.rideOperator = rideOperator; }

    // Interface method implementations
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to queue.");
    }

    @Override
    public void removeVisitorFromQueue() {
        Visitor removed = visitorQueue.poll();
        if (removed != null) {
            System.out.println("Visitor " + removed.getName() + " removed from queue.");
        } else {
            System.out.println("Queue is empty. No visitor to remove.");
        }
    }

    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in the queue.");
        } else {
            System.out.println("Visitors in the queue:");
            for (Visitor v : visitorQueue) {
                System.out.println("- " + v.getName() + ", Ticket: " + v.getTicketNumber());
            }
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No ride history yet.");
        } else {
            System.out.println("Ride history:");
            for (Visitor v : rideHistory) {
                System.out.println("- " + v.getName() + ", Ticket: " + v.getTicketNumber());
            }
        }
    }

    @Override
    public void runOneCycle() {
        System.out.println("Running one ride cycle...");
        Visitor v = visitorQueue.poll();
        if (v != null) {
            addVisitorToHistory(v);
            System.out.println("Visitor " + v.getName() + " completed the ride.");
        } else {
            System.out.println("No visitors in queue to run ride.");
        }
    }
}
