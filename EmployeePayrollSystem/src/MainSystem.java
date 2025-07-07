import java.util.Scanner;

public class MainSystem extends PayrollSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MainSystem obj = new MainSystem();
        String choice = "";

        while (!choice.equals("7")) {
            System.out.println("\n\t\t\t##############################################");
            System.out.println("\t\t\t#      WELCOME TO EMPLOYEE PAYROLL SYSTEM    #");
            System.out.println("\t\t\t##############################################");
            System.out.println("\t\t\t#   1. Add employee                          #");
            System.out.println("\t\t\t#   2. Display current employees             #");
            System.out.println("\t\t\t#   3. Add overtime                          #");
            System.out.println("\t\t\t#   4. Update total salary + bonus           #");
            System.out.println("\t\t\t#   5. Delete employee                       #");
            System.out.println("\t\t\t#   6. Search for employee                   #");
            System.out.println("\t\t\t#   7. End program                           #");
            System.out.println("\t\t\t##############################################");

            System.out.print("Enter your choice: ");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Employee ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Employee Position: ");
                    String position = sc.nextLine();
                    System.out.print("Enter Total Hours Worked (per month): ");
                    double hours = sc.nextDouble();
                    sc.nextLine();
                    obj.addEmployee(name, id, position, hours, 0);
                    break;

                case "2":
                    obj.displayPayroll();
                    break;

                case "3":
                    System.out.print("Enter Employee ID: ");
                    String empID = sc.nextLine();
                    System.out.print("Enter Overtime (Hours): ");
                    double overtime = sc.nextDouble();
                    sc.nextLine();
                    EmployeeDatabase employee = obj.searchEmployee(empID);
                    if (employee != null) {
                        employee.addOvertimeHours(overtime);
                        System.out.println("Overtime added for " + employee.name + " = " + employee.overtime + " hours");
                    }
                    break;

                case "4":
                    System.out.print("Enter Employee Name: ");
                    String empName = sc.nextLine();
                    obj.bonus(empName);
                    break;

                case "5":
                    System.out.print("Enter Employee Name to Delete: ");
                    String delName = sc.nextLine();
                    obj.deleteEmployee(delName);
                    break;

                case "6":
                    System.out.print("Enter Employee ID to Search: ");
                    String searchID = sc.nextLine();
                    obj.searchEmployee(searchID);
                    break;

                case "7":
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid command, please try again.");
            }
        }

        sc.close();
    }
}