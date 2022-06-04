package domain.employee.service;

import domain.employee.dto.IncidentResponse;
import domain.employee.entity.Employee;

import java.util.ArrayList;

public class IncidentManageService extends EmployeeService{


    public ArrayList<IncidentResponse> IncidentAccept(Employee employee) {
        return this.employeeRepository.IncidentAccept(employee);
    }

    public void incidentAssign(Employee employee, IncidentResponse incidentChoice) {
        this.employeeRepository.incidentAssign(employee, incidentChoice);
    }
}
