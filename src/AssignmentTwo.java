public class AssignmentTwo {
    public static void main(String[] args) {
        System.out.println("Theme Park Visitor Management System");
        AssignmentTwo a2 = new AssignmentTwo();
        a2.partThree();
        a2.partFourA();
        a2.partFourB();
        a2.partFive();
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
    Employee operator = new Employee("Ella", 32, "8888888", "EMP002", "Ride Attendant");
    Ride ride = new Ride("Sky Screamer", 130, operator);

    Visitor v1 = new Visitor("Zane", 21, "111", "T100", false);
    Visitor v2 = new Visitor("Amy", 24, "222", "T101", true);
    Visitor v3 = new Visitor("Ben", 27, "333", "T102", false);
    Visitor v4 = new Visitor("Clara", 20, "444", "T103", true);
    Visitor v5 = new Visitor("Dylan", 22, "555", "T104", false);

    ride.addVisitorToHistory(v1);
    ride.addVisitorToHistory(v2);
    ride.addVisitorToHistory(v3);
    ride.addVisitorToHistory(v4);
    ride.addVisitorToHistory(v5);

    ride.checkVisitorFromHistory(v3); // Should print found
    System.out.println("Number of visitors in ride history: " + ride.numberOfVisitors());
    ride.printRideHistory();
}


    public void partFourB() {
    Employee operator = new Employee("Jake", 29, "9999999", "EMP003", "Operator");
    Ride ride = new Ride("Mega Drop", 140, operator);

    Visitor v1 = new Visitor("Emily", 26, "666", "T200", true);
    Visitor v2 = new Visitor("Brian", 23, "777", "T201", false);
    Visitor v3 = new Visitor("Liam", 28, "888", "T202", true);
    Visitor v4 = new Visitor("Nina", 22, "999", "T203", false);
    Visitor v5 = new Visitor("Olive", 25, "000", "T204", true);

    ride.addVisitorToHistory(v1);
    ride.addVisitorToHistory(v2);
    ride.addVisitorToHistory(v3);
    ride.addVisitorToHistory(v4);
    ride.addVisitorToHistory(v5);

    System.out.println("Before sorting:");
    ride.printRideHistory();

    ride.sortRideHistory(new VisitorComparator());

    System.out.println("After sorting:");
    ride.printRideHistory();
}


    public void partFive() {
        Employee operator = new Employee("Sarah", 34, "777888999", "EMP004", "Operator");
        Ride ride = new Ride("Vortex Spin", 125, operator, 4); // 4 visitors per cycle

        // Add 10 visitors
        ride.addVisitorToQueue(new Visitor("Alice", 22, "0001", "V001", false));
        ride.addVisitorToQueue(new Visitor("Bob", 24, "0002", "V002", true));
        ride.addVisitorToQueue(new Visitor("Charlie", 20, "0003", "V003", false));
        ride.addVisitorToQueue(new Visitor("Daisy", 23, "0004", "V004", false));
        ride.addVisitorToQueue(new Visitor("Ethan", 26, "0005", "V005", true));
        ride.addVisitorToQueue(new Visitor("Fiona", 21, "0006", "V006", true));
        ride.addVisitorToQueue(new Visitor("George", 25, "0007", "V007", false));
        ride.addVisitorToQueue(new Visitor("Hannah", 27, "0008", "V008", true));
        ride.addVisitorToQueue(new Visitor("Ian", 28, "0009", "V009", false));
        ride.addVisitorToQueue(new Visitor("Julia", 19, "0010", "V010", false));

        System.out.println("\n--- Queue before running the ride ---");
        ride.printQueue();

        System.out.println("\n--- Running one ride cycle ---");
        ride.runOneCycle();

        System.out.println("\n--- Queue after running the ride ---");
        ride.printQueue();

        System.out.println("\n--- Visitors who completed the ride ---");
        ride.printRideHistory();
    }


    public void partSix() {
    }

    public void partSeven() {
    }
}
