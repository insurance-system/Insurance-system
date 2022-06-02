package domain.employee.controller;

import domain.employee.exception.EmployeeException;
import domain.employee.exception.NOEMPLOYEEEXCEPTION;
import domain.employee.service.EmployeeService;
import global.util.Choice;

public class EmployeeController {

    private EmployeeService employeeService;
    private Choice choice;


    public EmployeeController(Choice choice) {
        this.choice = choice;
    }

    public void initial() {
        switch(choice.employeeInitial()){
            case 1:
                login();
                break;
            case 2:
                connect();
                break;
            default:
                System.out.println("메뉴 1,2,3 중 하나만 입력해주세요.");
                break;
        }
    }

    private void login() {
        employeeService.login(choice.getId(),choice.getPassword());



    }

    //TODO
    public void connect() {

    }
}
