package pro.sky.springlistexample.service;

import org.springframework.stereotype.Service;
import pro.sky.springlistexample.domain.Employee;
import pro.sky.springlistexample.exception.EmployeeAlreadyAddedException;
import pro.sky.springlistexample.exception.EmployeeNotFoundException;
import pro.sky.springlistexample.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private final int MAX_EMPLOYEES_QUANTITY = 10;

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (isEmployeeExist(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен");
        }

        if (employees.size() >= MAX_EMPLOYEES_QUANTITY) {
            throw new EmployeeStorageIsFullException("Переполнение массива");
        }
        employees.add(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (isEmployeeExist(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!isEmployeeExist(employee)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employees.remove(employee);
        return employee;
    }

    private boolean isEmployeeExist(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee)) {
                return true;
            }
        }
        return false;
    }

    public List<Employee> printAllEmployees() {
        return employees;
    }
}
