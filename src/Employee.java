public class Employee extends Person {
    private String employeeId;
    private String position;

    public Employee() {
    }

    public Employee(String name, int age, String contactNumber, String employeeId, String position) {
        super(name, age, contactNumber);
        this.employeeId = employeeId;
        this.position = position;
    }

    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
