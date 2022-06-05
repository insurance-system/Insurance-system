package global.util;

import domain.customer.entity.FindPayment;
import domain.insurance.entity.Insurance;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerComment extends CommonComment{

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

    public String getSatisfaction() {
        System.out.println("만족도(0~10):");
        return scanner.next();
    }

    public int getKindOfJob() {
        System.out.println("1. 직장인");
        System.out.println("2. 학생");
        System.out.println("3. 주부");
        System.out.println("4. 위 중 해당사항 없음");
        System.out.print("번호 입력:");
        return scanner.nextInt();
    }

    public String getAccount() {
        System.out.print("계좌번호:");
        return scanner.next();
    }

    public String getCarNumber() {
        System.out.println("차량번호:");
        return scanner.next();
    }

    public String getIncidentSite() {
        System.out.println("사고장소:");
        return scanner.next();
    }

    public Date getIncidentDate() {
        System.out.println("사고일자 (ex. 2022-01-01 ):");
        String incidentDate = scanner.next();
        java.sql.Date date = java.sql.Date.valueOf(incidentDate);
        return date;
    }

    public String getClaimContent() {
        System.out.println("청구 내용:");
        return scanner.next();
    }

    public int getClaimCost() {
        System.out.println("청구 금액:");
        return scanner.nextInt();
    }

}
