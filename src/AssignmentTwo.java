public class AssignmentTwo {
    public static void main(String[] args) {
        System.out.println("Theme Park Visitor Management System");
        AssignmentTwo a2 = new AssignmentTwo();
        a2.partThree();
    }

    public void partThree() {
    Employee operator = new Employee("Alex", 30, "123456789", "E001", "Ride Operator");
    Ride rollerCoaster = new Ride("Thunderbolt", 120, operator);

    Visitor v1 = new Visitor("Tom", 25, "111-1111", "T001", false);
    Visitor v2 = new Visitor("Jerry", 22, "222-2222", "T002", true);
    Visitor v3 = new Visitor("Anna", 28, "333-3333", "T003", true);
    Visitor v4 = new Visitor("Lisa", 19, "444-4444", "T004", false);
    Visitor v5 = new Visitor("Sam", 21, "555-5555", "T005", false);

    rollerCoaster.addVisitorToQueue(v1);
    rollerCoaster.addVisitorToQueue(v2);
    rollerCoaster.addVisitorToQueue(v3);
    rollerCoaster.addVisitorToQueue(v4);
    rollerCoaster.addVisitorToQueue(v5);

    rollerCoaster.removeVisitorFromQueue(); // Removes Tom
    rollerCoaster.printQueue(); // Prints Jerry to Sam
}

    public void partFourA() {
    }

    public void partFourB() {
    }

    public void partFive() {
    }

    public void partSix() {
    }

    public void partSeven() {
    }
}
