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

    public int customerInitial(){
        System.out.println("고객님 안녕하세요. 회원가입을 하셨다면 로그인을, 아직 회원이 아니라면 회원가입을 진행해주세요.\n상담사 연결은 3번을 눌러주세요!");
        System.out.println("1.로그인\n2.회원가입\n3.상담사 연결");
        System.out.print("번호 입력:");
        return scanner.nextInt();

    }

    public ArrayList<String> employeeInital() {
        return null;
    }

    public String getPassword() {
        System.out.println("Password 입력:");
        return scanner.next();
    }

    public String getCustomerId() {
        System.out.println("ID 입력:");
        return scanner.next();
    }

    public String getName() {
        System.out.println("이름 입력:");
        return scanner.next();
    }

    public int getKindOfInsuranceId() {
        System.out.println("생명보험에 관심이 있으시다면 1을, 손해보험에 관심이 있으시다면 2를 입력:");
        return scanner.nextInt();
    }

    public String getAddress() {
        System.out.println("주소 입력 (ex: OO시 OO구 OO동):");
        return scanner.next();
    }

    public String getDetailAddress() {
        System.out.println("상세주소 입력 (ex: 12동 501호)");
        return scanner.next();
    }

    public String getZipcode() {
        System.out.println("우편번호 입력:");
        return scanner.next();
    }

    public String getEmail() {
        System.out.println("이메일 입력:");
        return scanner.next();
    }

    public String getPhoneNumber() {
        System.out.println("핸드폰 번호 입력:");
        return scanner.next();
    }

    public int getKindOfJob() {
        System.out.println("1. 직장인");
        System.out.println("2. 학생");
        System.out.println("3. 주부");
        System.out.println("4. 위 중 해당사함 없음");
        System.out.print("위 중 해당 번호 입력:");
        return scanner.nextInt();
    }

    public int afterLogin() {
        System.out.println("1. 상담사 연결하기");
        System.out.println("2. 가입된 보험 조회하기");
        System.out.println("3. 보험급 납부내역");
        System.out.println("4. 보험 관련 문의");
        System.out.println("5. 사고 처리 접수");
        System.out.println("위 중 해당 번호 입력");
        return scanner.nextInt();

    }
}
