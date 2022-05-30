package domain.employee.service;

import domain.employee.Employee;
import domain.employee.repository.EmployeeRepository;

import java.util.ArrayList;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();

    }

    public Employee login(ArrayList<String> userInput) {
        String employeeStr = employeeRepository.findById(userInput.get(0));
        String password = employeeStr.split(" ")[2];
        if(!userInput.get(1).equals(password)){
            return null;
        }else{
            return Employee.toEntity(employeeStr);
        }
        //


    }

}
