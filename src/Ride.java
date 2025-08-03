import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Ride implements RideInterface {
    private String rideName;
    private int minHeightRequirement;
    private Employee rideOperator;
    private int maxRider;
    private int numOfCycles = 0;


    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory; // Changed to LinkedList

    public Ride() {
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 1;
    }

    public Ride(String rideName, int minHeightRequirement, Employee rideOperator) {
        this.rideName = rideName;
        this.minHeightRequirement = minHeightRequirement;
        this.rideOperator = rideOperator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    public Ride(String rideName, int minHeightRequirement, Employee rideOperator, int maxRider) {
        this.rideName = rideName;
        this.minHeightRequirement = minHeightRequirement;
        this.rideOperator = rideOperator;
        this.maxRider = Math.max(1, maxRider); // ensure at least 1
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Getters and setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public int getMinHeightRequirement() { return minHeightRequirement; }
    public void setMinHeightRequirement(int minHeightRequirement) { this.minHeightRequirement = minHeightRequirement; }

    public Employee getRideOperator() { return rideOperator; }
    public void setRideOperator(Employee rideOperator) { this.rideOperator = rideOperator; }

    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = Math.max(1, maxRider); }

    public int getNumOfCycles() { return numOfCycles; }

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
        System.out.println("Added " + visitor.getName() + " to ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor);
        System.out.println(visitor.getName() + (found ? " is " : " is not ") + "in the ride history.");
        return found;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors in ride history.");
        } else {
            System.out.println("Ride History:");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor v = iterator.next();
                System.out.println("- " + v.getName() + ", Ticket: " + v.getTicketNumber());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println("Ride cannot run: No operator assigned.");
            return;
        }

        if (visitorQueue.isEmpty()) {
            System.out.println("Ride cannot run: No visitors in the queue.");
            return;
        }

        int ridersThisCycle = Math.min(maxRider, visitorQueue.size());

        System.out.println("Running ride cycle #" + (numOfCycles + 1) + " with " + ridersThisCycle + " visitors:");

        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor visitor = visitorQueue.poll();
            if (visitor != null) {
                addVisitorToHistory(visitor);
                System.out.println("- " + visitor.getName() + " took the ride.");
            }
        }

        numOfCycles++;
    }


    public void sortRideHistory(Comparator<Visitor> comparator) {
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history sorted.");
    }

    public void exportRideHistory(String fileName) {
        if (rideHistory.isEmpty()) {
            System.out.println("No ride history to export.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Visitor visitor : rideHistory) {
                // Format: name,age,contactNumber,ticketNumber,hasMembership
                String line = visitor.getName() + "," +
                            visitor.getAge() + "," +
                            visitor.getContactNumber() + "," +
                            visitor.getTicketNumber() + "," +
                            visitor.isHasMembership();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Ride history exported successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error exporting ride history: " + e.getMessage());
        }
    }

    public void importRideHistory(String fileName) {
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        int count = 0;

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            if (fields.length == 5) {
                String name = fields[0];
                int age = Integer.parseInt(fields[1]);
                String contact = fields[2];
                String ticket = fields[3];
                boolean hasMembership = Boolean.parseBoolean(fields[4]);

                Visitor visitor = new Visitor(name, age, contact, ticket, hasMembership);
                rideHistory.add(visitor);
                count++;
            } else {
                System.out.println("Invalid data format: " + line);
            }
        }

        System.out.println("Successfully imported " + count + " visitors from file.");
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + fileName);
    } catch (IOException e) {
        System.out.println("Error reading from file: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error parsing numeric data: " + e.getMessage());
    }
}


}
