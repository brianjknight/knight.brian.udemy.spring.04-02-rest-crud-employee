package knight.brian.restcruddemo.dao;

import knight.brian.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
}
