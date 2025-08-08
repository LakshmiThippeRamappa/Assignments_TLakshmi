package com.cg.eis.service;

import com.cg.eis.bean.Employee;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {

    HashMap<Integer, Employee> list = new HashMap<>();

    public void determineInsuranceScheme(Employee emp) {
        double salary = emp.getSalary();
        String designation = emp.getDesignation().toLowerCase();
        String scheme;

        if (salary > 50000 && designation.equals("manager")) {
            scheme = "Platinum";
        } else if (salary > 20000 && designation.equals("programmer")) {
            scheme = "Gold";
        } else if (salary >= 5000 && designation.equals("clerk")) {
            scheme = "Silver";
        } else {
            scheme = "No Scheme";
        }

        emp.setInsuranceScheme(scheme);
    }

    @Override
    public void addEmployee(Employee emp) {
        determineInsuranceScheme(emp);
        list.put(emp.getId(), emp);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return list.remove(id) != null;
    }

    @Override
    public void displayEmployeeByScheme(String scheme) {
        boolean found = false;
        for (Employee emp : list.values()) {
            if (emp.getInsuranceScheme().equalsIgnoreCase(scheme)) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found for scheme: " + scheme);
        }
    }

    @Override
    public void displaySortedBySalary() {
        List<Employee> sortedList = new ArrayList<>(list.values());

        // Manual Comparator implementation
        Collections.sort(sortedList, new SalaryComparator());

        System.out.println("Employees sorted by salary:");
        for (Employee emp : sortedList) {
            System.out.println(emp);
        }
    }

    // Manual comparator class
    class SalaryComparator implements Comparator<Employee> {
        public int compare(Employee e1, Employee e2) {
            return Double.compare(e1.getSalary(), e2.getSalary());
        }
    }
}
