public class EmployeeDatabase {
    String name;
    String Employee_ID;
    String position;
    double HoursWork;
    double overtime;
    EmployeeDatabase next;

    public EmployeeDatabase(String name, String id, String position, double hours, double overtime) {
        this.name = name;
        this.Employee_ID = id;
        this.position = position;
        this.HoursWork = hours * 7; // Assuming 7 days per week work
        this.overtime = overtime;
        this.next = null;
    }

    public void addOvertimeHours(double overtime) {
        this.overtime += overtime;
    }
}