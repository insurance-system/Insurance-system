package global.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.sql.Date;
import java.util.Scanner;

public class Choice {

    Scanner scanner;

    public Choice() {
        this.scanner = new Scanner(System.in);
    }

    public int initial(){
        System.out.println("-------------------아프시조 보험-------------------");
        System.out.println("1.보험사 고객 \n2.사원\n3.종료");
        System.out.print("번호 입력:");
        return scanner.nextInt();
    }

    public String getPassword() {
        System.out.print("Password 입력:");
        return scanner.next();
    }

    public String getId() {
        System.out.print("ID 입력:");
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

    public int employeeInitial() {
        return scanner.nextInt();
    }

    public String getText(String message) {
        System.out.println(message);
        return scanner.next();
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

    public String getclaimContent() {
        System.out.println("청구 내용:");
        return scanner.next();
    }

    public int getclaimCost() {
        System.out.println("청구 금액:");
        return scanner.nextInt();
    }
}
