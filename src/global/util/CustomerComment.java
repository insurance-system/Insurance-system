package global.util;

import domain.customer.entity.FindPayment;
import domain.insurance.entity.Insurance;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerComment {

    Scanner scanner;

    public CustomerComment() {
        this.scanner = new Scanner(System.in);
    }

    public int customerInitial(){
        System.out.println("고객님 안녕하세요. 회원가입을 하셨다면 로그인을, 아직 회원이 아니라면 회원가입을 진행해주세요.\n상담사 연결은 3번을 눌러주세요!");
        System.out.println("1.로그인\n2.회원가입\n3.상담사 연결\n4.종료");
        System.out.print("번호 입력:");
        return scanner.nextInt();
    }

    public int afterLogin() {
        System.out.println("1. 상담사 연결하기");
        System.out.println("2. 상담사 평가하기");
        System.out.println("3. 가입된 보험 조회하기");
        System.out.println("4. 보험급 납부내역");
        System.out.println("5. 사고 처리 접수");
        System.out.println("6. 보험 가입하기");
        System.out.println("7. 보험금 청구하기");
        System.out.println("8. 로그아웃");
        System.out.println("번호 입력:");
        return scanner.nextInt();
    }

    public int afterfindJoinedInsurances() {
        System.out.println("1. 보험 해지하기");
        System.out.println("2. 돌아가기");
        System.out.print("번호 입력:");
        return scanner.nextInt();
    }

    public int afterLoginInterest() {
        System.out.println("1. 상담사 연결하기");
        System.out.println("2. 상담사 평가하기");
        System.out.println("3. 보험 가입하기");
        System.out.println("4. 로그아웃");
        return scanner.nextInt();
    }

    public void findPaymentHistory(ArrayList<FindPayment> findPayment) {
        System.out.println("-------------------보험금 납부 내역-------------------");
        for(int i=0; findPayment.size()>i; i++) {
            System.out.print(" 보험 이름 : " + findPayment.get(i).getInsuranceName());
            System.out.print("  | 납부 금액 : " + findPayment.get(i).getFee());
            System.out.println(" | 납부 일 : " + findPayment.get(i).getPayDate());
        }
        System.out.println("--------------------------------------------------");
    }

    public void joinedInsurances(ArrayList<Insurance> insuranceArrayList) {
        System.out.println("-------------------보험 가입 내역-------------------");
        for(int i=0; insuranceArrayList.size()>i; i++) {
            System.out.print(" 보험 이름 : "+insuranceArrayList.get(i).getInsuranceName());
            System.out.print(" | 보험 종류 : "+insuranceArrayList.get(i).getKindOfInsurance());
            System.out.println(" | 보험금 : "+insuranceArrayList.get(i).getFee());
        }
        System.out.println("--------------------------------------------------");
    }

    public String interestInsurances(ArrayList<Insurance> insuranceArrayList) {
        System.out.println("-------------------관심 보험 내역-------------------");
        for(int i=0; insuranceArrayList.size()>i; i++) {
            System.out.print(" 보험 번호 : "+ i);
            System.out.print(" | 보험 이름 : "+insuranceArrayList.get(i).getInsuranceName());
            System.out.print(" | 보험 종류 : "+insuranceArrayList.get(i).getKindOfInsurance());
            System.out.println(" | 보험금 : "+insuranceArrayList.get(i).getFee());
        }
        System.out.println("--------------------------------------------------");
        System.out.print("가입할 보험 번호 입력 :");

        return insuranceArrayList.get(scanner.nextInt()).getInsuranceId();
    }

    public int checkPayer() {
        System.out.println("보험금 수익자가 본인이면 0, 아니면 1을 입력해주세요.");
        System.out.print("번호 입력 :");
        return scanner.nextInt();
    }

    public int checkBeneficiary() {
        System.out.println("보험금 납부자가 본인이면 0, 아니면 1을 입력해주세요.");
        System.out.print("번호 입력 :");
        return scanner.nextInt();
    }
}
