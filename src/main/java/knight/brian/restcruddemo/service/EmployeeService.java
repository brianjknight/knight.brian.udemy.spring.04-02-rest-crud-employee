package knight.brian.restcruddemo.service;

import knight.brian.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

}
