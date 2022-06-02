package domain.employee.controller;

import domain.employee.entity.Employee;
import domain.employee.exception.EmployeeException;
import domain.employee.exception.NOEMPLOYEEEXCEPTION;
import domain.employee.service.EmployeeService;
import global.util.Choice;

public class EmployeeController {

    private EmployeeService employeeService;
    private Choice choice;


    public EmployeeController(Choice choice) {
        this.choice = choice;
        this.employeeService = new EmployeeService();
    }

    public void initial() {
        switch(choice.employeeInitial()){
            case 1:
                Employee employee = login();
                if(employee != null){
                    home(employee);
                }
                connect();
                break;
            case 2:
                connect();
                break;
            default:
                System.out.println("메뉴 1,2,3 중 하나만 입력해주세요.");
                break;
        }
    }

    private Employee login() {
        return employeeService.login(choice.getId(),choice.getPassword());
    }

    private Employee home(Employee employee){
        return null;
    }
}
