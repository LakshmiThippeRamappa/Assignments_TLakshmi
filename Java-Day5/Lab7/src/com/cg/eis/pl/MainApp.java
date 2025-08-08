package com.cg.eis.pl;

import java.util.Scanner;
import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeServiceImpl();
        int choice;

        do {
            System.out.println("\n--- Employee Insurance System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees by Insurance Scheme");
            System.out.println("3. Delete Employee by ID");
            System.out.println("4. Display All Employees Sorted by Salary");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Designation: ");
                    String designation = sc.nextLine();
                    Employee emp = new Employee(id, name, salary, designation);
                    service.addEmployee(emp);
                    break;

                case 2:
                    System.out.print("Enter Insurance Scheme: ");
                    String scheme = sc.nextLine();
                    service.displayEmployeeByScheme(scheme);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    if (service.deleteEmployee(empId)) {
                        System.out.println("Employee deleted.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    service.displaySortedBySalary();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
