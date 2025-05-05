package knight.brian.restcruddemo.dao;

import knight.brian.restcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
