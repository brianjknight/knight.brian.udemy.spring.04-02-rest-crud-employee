package knight.brian.restcruddemo.rest;

import knight.brian.restcruddemo.entity.Employee;
import knight.brian.restcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        if (employee == null ) {
            throw new RuntimeException("Employee ID: %d not found.".formatted(employeeId));
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        // set id to 0 to make sure we are saving a new employee
        employee.setId(0);

        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {

        Employee updatedEmployee = employeeService.save(employee);

        return updatedEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public void delete() {

    }

}
