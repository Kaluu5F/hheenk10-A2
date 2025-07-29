public class Ride {
    private String rideName;
    private int minHeightRequirement;
    private Employee rideOperator;

    public Ride() {
    }

    public Ride(String rideName, int minHeightRequirement, Employee rideOperator) {
        this.rideName = rideName;
        this.minHeightRequirement = minHeightRequirement;
        this.rideOperator = rideOperator;
    }

    // Getters and setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getMinHeightRequirement() {
        return minHeightRequirement;
    }

    public void setMinHeightRequirement(int minHeightRequirement) {
        this.minHeightRequirement = minHeightRequirement;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }
}
