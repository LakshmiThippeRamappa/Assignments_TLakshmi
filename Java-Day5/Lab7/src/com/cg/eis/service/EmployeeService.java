package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public interface EmployeeService {
    void addEmployee(Employee emp);
    boolean deleteEmployee(int id);
    void displayEmployeeByScheme(String scheme);
    void displaySortedBySalary();
}
