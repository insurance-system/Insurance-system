package domain.customer.controller;

import domain.customer.dto.request.CustomerLoginRequest;
import domain.customer.service.CustomerService;
import java.util.Scanner;

public class CustomerController {

    private final CustomerService customerService;
    private final Scanner scanner;

    public CustomerController() {
        this.customerService = new CustomerService();
        this.scanner = new Scanner(System.in);
    }

    public void initial() {
        System.out.println("고객님 안녕하세요. 회원가입을 하셨다면 로그인을 아직 회원이 아니라면 회원가입을 진행해주세요.\n상담사 연결은 3번을 눌러주세요!");
        System.out.println("1.로그인\n2.회원가입\n3.상담사 연결");
        System.out.print("번호 입력:");
        int n = scanner.nextInt();
        switch(n){
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
        System.out.print("ID 입력:");
        String id = scanner.next();
        System.out.print("Password 입력:");
        String password = scanner.next();
        if(customerService.login(new CustomerLoginRequest(id, password))){
            System.out.println("로그인 성공!");
            return false;
        }
        else{
            System.out.println("아이디 혹은 비번이 틀렸음");
            return true;
        }
    }

    public void join() {

    }

    public void connect() {
//        ArrayList<String> strings = choice.customerInterest();
//        Customer customer = customerService.connect(strings);
    }

}
