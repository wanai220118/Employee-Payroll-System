public class PayrollSystem {
    private EmployeeDatabase head;

    public PayrollSystem() {
        this.head = null;
    }

    public void addEmployee(String name, String id, String position, double hours, double overtime) {
        EmployeeDatabase emp = new EmployeeDatabase(name, id, position, hours, overtime);
        if (head == null) {
            head = emp;
        } else {
            EmployeeDatabase temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = emp;
        }
    }

    public void deleteEmployee(String name) {
        if (head == null) {
            System.out.println("Payroll is empty.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("Employee " + name + " deleted.");
            return;
        }

        EmployeeDatabase temp = head;
        EmployeeDatabase prev = null;

        while (temp != null && !temp.name.equals(name)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Employee " + name + " not found.");
        } else {
            prev.next = temp.next;
            System.out.println("Employee " + name + " deleted.");
        }
    }

    public void displayPayroll() {
        EmployeeDatabase temp = head;
        if (temp == null) {
            System.out.println("No employee records found.");
            return;
        }

        System.out.println("\n================================================================================");
        System.out.println("|\tName\t|\tID\t|\tPosition\t|\tTotal Salary\t|");
        System.out.println("================================================================================");

        while (temp != null) {
            double bonus = temp.overtime * 1.5;
            double total = temp.HoursWork + bonus;
            System.out.printf("|\t%s\t|\t%s\t|\t%s\t|\tRM %.2f\t|\n", temp.name, temp.Employee_ID, temp.position, total);
            temp = temp.next;
        }
    }

    public void bonus(String name) {
        EmployeeDatabase temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                double bonus = temp.overtime * 1.5;
                double total = temp.HoursWork + bonus;
                System.out.printf("Total Salary for %s (with Overtime Bonus): RM %.2f\n", temp.name, total);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Employee not found.");
    }

    public EmployeeDatabase searchEmployee(String id) {
        EmployeeDatabase temp = head;
        while (temp != null) {
            if (temp.Employee_ID.equals(id)) {
                System.out.printf("Employee %s found. Salary: RM %.2f\n", temp.name, temp.HoursWork);
                return temp;
            }
            temp = temp.next;
        }
        System.out.println("Employee not found.");
        return null;
    }
}