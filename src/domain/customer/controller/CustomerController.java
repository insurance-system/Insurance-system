package domain.customer.controller;

import domain.customer.dto.request.CustomerLoginRequest;
import domain.customer.entity.Customer;
import domain.customer.service.CustomerService;
import global.util.Choice;

import java.util.Scanner;

public class CustomerController {

    private final CustomerService customerService;
    private final Choice choice;

    public CustomerController(Choice choice) {
        this.customerService = new CustomerService(choice);
        this.choice = choice;
    }

    public void initial() {
        switch(choice.customerInitial()){
            case 1:
                login();
                break;
            case 2:
                join();
                break;
            case 3:
                connect();
                break;
            default:
                System.out.println("메뉴 1,2,3 중 하나만 입력해주세요.");
                break;
        }
    }

    public boolean login() {
        CustomerLoginRequest customerLoginRequest = new CustomerLoginRequest(choice.getCustomerId(), choice.getPassword());
        Customer customer = customerService.login(customerLoginRequest);
        if(customer != null){
            System.out.println("로그인 성공!");
            enter(customer);
            return false;
        }
        else{
            System.out.println("아이디 혹은 비번이 틀렸음");
            return true;
        }
    }

    public void enter(Customer customer){
        System.out.println(customer.getName() + "님 안녕하세요!");

        switch (choice.customerEnter()){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }

    }

    public void join() {

    }

    public void connect() {
//        ArrayList<String> strings = choice.customerInterest();
//        Customer customer = customerService.connect(strings);
    }

}
