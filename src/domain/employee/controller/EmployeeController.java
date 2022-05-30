package domain.employee.controller;

import domain.employee.Employee;
import domain.employee.exception.EmployeeException;
import domain.employee.exception.NOEMPLOYEEEXCEPTION;
import domain.employee.service.EmployeeService;
import global.util.Choice;

import java.util.ArrayList;

import static domain.employee.exception.EmployeeExceptionList.NOEMPLOYEE;

public class EmployeeController {

    private EmployeeService employeeService;
    private Choice choice;

    private EmployeeException exception;

    public EmployeeController(Choice choice) {
        this.choice = choice;
    }

    public void inital() {
//        try {
//
//        }catch (Exception exception){
//            throw new NOEMPLOYEEEXCEPTION();
//        }
        if (true) {
            System.out.println("오류가 발생했습니다");
//            System.out.println(NOEMPLOYEE.getErrorCode() + NOEMPLOYEE.getMessage());
            new NOEMPLOYEEEXCEPTION();
        }


    }

    //TODO
    public void connect() {

    }
}
