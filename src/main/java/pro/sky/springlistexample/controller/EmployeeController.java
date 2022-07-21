package pro.sky.springlistexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.springlistexample.domain.Employee;
import pro.sky.springlistexample.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(name = "firstName") String firstName,
                                @RequestParam(name = "lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(name = "firstName") String firstName,
                                 @RequestParam(name = "lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(name = "firstName") String firstName,
                                   @RequestParam(name = "lastName") String lastName) {

            return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/print")
    public List<Employee> printEmployees() {
        return employeeService.printAllEmployees();
    }
}
