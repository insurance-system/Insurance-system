package global.util;

import domain.employee.dto.*;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeComment {

    Scanner scanner;

    public EmployeeComment() {
        this.scanner = new Scanner(System.in);
    }

    public int home(){
        System.out.println("\n\n----------------Home----------------");
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
        System.out.println("9. 손해 접수 팀");
        System.out.println("91. 사고 발생 접수");
        System.out.println("------------------------------------");
        System.out.println("10. 보상 평가 팀");
        System.out.println("101. 보상금 심사");
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

    public int incidentChoice(ArrayList<IncidentResponse> incidentAccept) {
        System.out.println("");
        System.out.println("담당자 미배정 사건 목록");
        for(int i=0; incidentAccept.size() > i; i++) {
            System.out.println("| 번호: "+i);
            System.out.println("  이름: "+incidentAccept.get(i).getName()+"  전화번호: "+incidentAccept.get(i).getPhoneNum());
            System.out.println("  주소: "+incidentAccept.get(i).getAddress());
            System.out.println("  일시: "+incidentAccept.get(i).getDate());
        }
        System.out.println("");
        System.out.print("담당하려는 사건의 번호를 입력해주세요. \n번호 입력: ");
        return scanner.nextInt();
    }

    public RewardEvaluteResponse rewardChoice(ArrayList<RewardEvaluteResponse> rewardEvaluteResponses) {
        System.out.println("");
        System.out.println("담당자 미배정 사건 목록");
        for(int i=0; rewardEvaluteResponses.size() > i; i++) {
            System.out.println("| 번호: "+i);
            System.out.println("  사용자: "+rewardEvaluteResponses.get(i).getCustomerId());
            System.out.println("  청구 내용: "+rewardEvaluteResponses.get(i).getClaimContent());
            System.out.println("  청구 금액: "+rewardEvaluteResponses.get(i).getClaimCost());
        }
        System.out.println("");
        System.out.print("담당하려는 사건의 번호를 입력해주세요. \n번호 입력: ");
        int choice = scanner.nextInt();
        System.out.println("  사용자: "+rewardEvaluteResponses.get(choice).getCustomerId());
        System.out.println("  청구 내용: "+rewardEvaluteResponses.get(choice).getClaimContent());
        System.out.println("  청구 금액: "+rewardEvaluteResponses.get(choice).getClaimCost());

        System.out.println("청구에 대한 결과를 입력해주세요. \n");
        System.out.print("1.승인   2.거부   3.보류  \n");
        int resultChoice = scanner.nextInt();
        if(resultChoice==1){
            rewardEvaluteResponses.get(choice).setClaimStatus("승인");
        }else if(resultChoice==2){
            rewardEvaluteResponses.get(choice).setClaimStatus("거부");
        }else{
            rewardEvaluteResponses.get(choice).setClaimStatus("보류");
        }

        return rewardEvaluteResponses.get(choice);
    }
}
