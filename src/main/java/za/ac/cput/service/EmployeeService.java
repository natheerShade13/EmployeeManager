package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.exceptions.UserNotFoundException;
import za.ac.cput.repository.EmployeeRepository;
import java.util.List;
import static za.ac.cput.utility.Helper.generateId;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(generateId());
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(long id){
        return employeeRepository.findEmployeeById(id).orElseThrow(() ->
                new UserNotFoundException("User with  id " + id + "does not exist"));
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(long id){
       //employeeRepository.deleteEmployeeById(id);
        employeeRepository.deleteById(id);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

}
