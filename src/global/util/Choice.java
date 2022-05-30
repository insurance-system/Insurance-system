package global.util;

import java.util.ArrayList;
import java.util.Scanner;

public class Choice {

    Scanner scanner;

    public Choice() {
        this.scanner = new Scanner(System.in);
    }

    public int initial(){
        System.out.println("1.보험사 고객 \n2.사원\n3.종료");
        return scanner.nextInt();
    }
//
//    public ArrayList<String> customerInitial() {
//        System.out.println("고객님 안녕하세요. 회원가입을 하셨다면 로그인을 아직 회원이 아니라면 회원가입을 진행해주세요.");
//        System.out.println("1.로그인\n2.회원가입");
//        System.out.println("ID: ");
//        ArrayList<String> abc = new ArrayList<>();
//        abc.add(scanner.next());
//        System.out.println("Password: ");
//        abc.add(scanner.next());
//        return abc;
//    }
//
//    public ArrayList<String> employeeInitial() {
//        System.out.println("로그인");
//        System.out.println("ID: ");
//        ArrayList<String> abc = new ArrayList<>();
//        abc.add(scanner.next());
//        System.out.println("Password: ");
//        abc.add(scanner.next());
//        return abc;
//    }
//
//
//    public ArrayList<String> customerInterest() {
//        ArrayList<String> abc = new ArrayList<>();
//        System.out.println("이름 : ");
//        abc.add(scanner.next());
//
//        System.out.println("주민번호 : ");
//        abc.add(scanner.next());
//
//        System.out.println("직종 : ");
//        abc.add(scanner.next());
//
//        System.out.println("흡연유무 : ex) 예, 아니오");
//        abc.add(scanner.next());
//
//        System.out.println("음주유무 : ex) 예, 아니오");
//        abc.add(scanner.next());
//
//        return abc;
//    }

    public ArrayList<String> employeeInital() {
        return null;
    }
}
