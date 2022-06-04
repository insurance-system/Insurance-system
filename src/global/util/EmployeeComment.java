package global.util;

import domain.employee.dto.EmpCustomer;
import domain.employee.dto.DefaultResponse;
import domain.employee.dto.ExpirationResponse;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeComment {

    Scanner scanner;

    public EmployeeComment() {
        this.scanner = new Scanner(System.in);
    }

    public int home(){
        System.out.println("----------------Home----------------");
        System.out.println("1. 영업 활동 팀");
        System.out.println("11. 상담 대기 신규 고객 명단 조회 \n12. 영업 교육 수강");
        System.out.println("------------------------------------");
        System.out.println("2. 영업 교육 팀");
        System.out.println("21. 영업 교육 강의 자료 업로드 \n22. 강의 자료 리스트 출력 \n23. 수강 명단 체크");
        System.out.println("------------------------------------");
        System.out.println("3. 사후 관리 팀");
        System.out.println("31. 보험 정보 안내 해당 고객 명단 조회");
        System.out.println("------------------------------------");
        System.out.println("4. 계약 관리 팀");
        System.out.println("41. 보험 계약 관리  \n42. 미납 고객 조회");
        System.out.println("------------------------------------");
        System.out.println("5. U/W 팀");
        System.out.println("51. 인수심사 수행");
        System.out.println("------------------------------------");
        System.out.println("6. 상품 개발 팀");
        System.out.println("61. 보험 설계 시작");
        System.out.println("------------------------------------");
        System.out.println("7. 고객 정보 팀");
        System.out.println("71. 고객 정보를 제공");
        System.out.println("------------------------------------");
        System.out.println("8. 시장 분석 팀");
        System.out.println("81. 보험 시장 데이터를 제공");
        System.out.println("------------------------------------");
        System.out.println("0. 로그아웃");

        return scanner.nextInt();
    }

    public int customerConsultList(ArrayList<EmpCustomer> arrayList) {
        System.out.println("");
        System.out.println("미 상담 고객 목록");
        for(int i=0; arrayList.size() > i; i++){
            System.out.println("| 번호: "+i+"  "+"이름: "+arrayList.get(i).getName()+"  전화번호: "+arrayList.get(i).getPhoneNumber());
            System.out.println("  직군: "+arrayList.get(i).getKindOfJob());
            System.out.println("  관심 보험 종류: "+arrayList.get(i).getKindOfInsurance().name() +"\n");
        }
        System.out.println("");
        System.out.print("상담을 진행하려는 고객의 번호를 입력해주세요. \n번호 입력: ");
        return scanner.nextInt();
    }

    public void contractExpriation(ArrayList<ExpirationResponse> arrayList){
        System.out.println("");
        System.out.println("보험 만기 고객 목록");
        for(int i=0; arrayList.size() > i; i++) {
            System.out.println("| 이름: "+arrayList.get(i).getName()+"  전화번호: "+arrayList.get(i).getPhoneNumber());
            System.out.println("  직군: "+arrayList.get(i).getKindOfJob());
            System.out.println("  관심 보험 종류: "+arrayList.get(i).getKindOfInsurance().name());
            System.out.println("  가입한 보험 이름: "+arrayList.get(i).getInsuranceName());
            System.out.println("  현재 보험 상태: "+arrayList.get(i).getContractStatus() +"\n");
        }
    }

    public void contractDefault(ArrayList<DefaultResponse> arrayList) {
        System.out.println("");
        System.out.println("미납 고객 목록");
        for(int i=0; arrayList.size() > i; i++) {
            System.out.println("| 이름: "+arrayList.get(i).getName()+"  전화번호: "+arrayList.get(i).getPhoneNumber());
            System.out.println("  주소: "+arrayList.get(i).getAddress()+" 상세주소: "+arrayList.get(i).getDetailAddress());
            System.out.println("  우편번호: "+arrayList.get(i).getZipCode());
            System.out.println("  가입한 보험 이름: "+arrayList.get(i).getInsuranceName());
            System.out.println("  현재 보험 상태: "+arrayList.get(i).getContractStatus() +"\n");
        }
    }

    public int notifyMenu() {
        System.out.println("1. 계약기간 만료 임박 계약 리스트 출력하기");
        System.out.println("2. 보험 납부 기간 만료 임박 계약 리스트 출력하기");
        return scanner.nextInt();
    }

    public int yesOrNo() {
        System.out.println("1. 예");
        System.out.println("2. 아니요");
        return scanner.nextInt();
    }

    public String getCustomerId() {
        System.out.println("인수심사를 진행할 고객 아이디를 입력하세요.");
        System.out.print("고객 ID:");
        return scanner.next();
    }

    public void developInsurance() {
        System.out.println("--------------보험 설계하기--------------");
        System.out.print("보험 이름:");
        System.out.println("1.생명보험  2.손해보험");
    }

    public String getInsuranceName() {
        System.out.print("보험 이름:");
        return scanner.next();
    }

    public int getKindOfInsurance() {
        System.out.println("1.생명보험  2.손해보험");
        System.out.print("번호 선택:");
        return scanner.nextInt();
    }

    public int getInsuranceFee() {
        System.out.print("월 청구비:");
        return scanner.nextInt();
    }


    public int getMaxAge() {
        System.out.print("가입 최대 나이:");
        return scanner.nextInt();
    }

    public int getMinAge() {
        System.out.print("가입 최소 나이:");
        return scanner.nextInt();
    }

    public String getSmoke() {
        System.out.println("하루 기준 담배 3개비는        A");
        System.out.println("하루 기준 담배 10개비는 이하는  B");
        System.out.println("하루 기준 담배 20개비 이상은   C");
        return scanner.next();
    }

    public String getAlcohol() {
        System.out.println("일주일 기준 담배 3개비는        A");
        System.out.println("일주일 기준 담배 10개비는 이하는  B");
        System.out.println("일주일 기준 소주 2병 이상은      C");
        return scanner.next();
    }

    public String getCancer() {
        System.out.println("현재 암과 관련된 질병이 없다면   A");
        System.out.println("현재 암과 투병중인 상태        C");
        return scanner.next();
    }
}
