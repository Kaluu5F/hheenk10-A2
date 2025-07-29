public class Visitor extends Person {
    private String ticketNumber;
    private boolean hasMembership;

    public Visitor() {
    }

    public Visitor(String name, int age, String contactNumber, String ticketNumber, boolean hasMembership) {
        super(name, age, contactNumber);
        this.ticketNumber = ticketNumber;
        this.hasMembership = hasMembership;
    }

    // Getters and setters
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public boolean isHasMembership() {
        return hasMembership;
    }

    public void setHasMembership(boolean hasMembership) {
        this.hasMembership = hasMembership;
    }
}
