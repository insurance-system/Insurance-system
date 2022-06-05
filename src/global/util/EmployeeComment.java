package global.util;

import domain.employee.dto.*;

import java.util.ArrayList;
import java.util.Scanner;

import static global.util.constants.EmployeeConstants.*;

public class EmployeeComment extends CommonComment{

    Scanner scanner;

    public EmployeeComment(){
        this.scanner = new Scanner(System.in);
    }

    public int home(){
        System.out.println(HOME_START);
        printSalesEmployeeMenu();
        printSalesEducationEmployeeMenu();
        printContractGuideMenu();
        printContractManagementEmployeeMenu();
        printUWEmployeeMenu();
        printInsuranceDevelopmentEmployeeMenu();
        printCustomerInformationEmployeeMenu();
        printMarketAnalysisEmployeeMenu();
        printIncidentManagementEmployeeMenu();
        printRewardManagementEmployeeMenu();
        System.out.println(HOME_MENU_LAST);
        System.out.print(SELECT_NUM);
        return scanner.nextInt();
    }

    private void printRewardManagementEmployeeMenu() {
        System.out.println(HOME_REWARD_EMP_MENU);
        System.out.println(HOME_REWARD_EMP_MENU_);
        System.out.println(END_LINE);
    }

    private void printIncidentManagementEmployeeMenu() {
        System.out.println(HOME_INCIDENT_EMP_MENU);
        System.out.println(HOME_INCIDENT_EMP_MENU_);
        System.out.println(END_LINE);
    }

    private void printMarketAnalysisEmployeeMenu() {
        System.out.println(HOME_MARKET_ANALYSIS_EMP);
        System.out.println(HOME_MARKET_ANALYSIS_EMP_);
        System.out.println(END_LINE);
    }

    private void printCustomerInformationEmployeeMenu() {
        System.out.println(HOME_CUS_INFORMATION_EMP);
        System.out.println(HOME_CUS_INFORMATION_EMP_);
        System.out.println(END_LINE);
    }

    private void printInsuranceDevelopmentEmployeeMenu() {
        System.out.println(HOME_INSURANCE_DEV_EMP);
        System.out.println(HOME_INSURANCE_DEV_EMP_);
        System.out.println(END_LINE);
    }

    private void printUWEmployeeMenu() {
        System.out.println(HOME_UW_EMP);
        System.out.println(HOME_UW_EMP_);
        System.out.println(END_LINE);
    }

    private void printContractManagementEmployeeMenu() {
        System.out.println(HOME_CONTRACT_MNG_EMP);
        System.out.println(HOME_CONTRACT_MNG_EMP_);
        System.out.println(END_LINE);
    }

    private void printContractGuideMenu() {
        System.out.println(HOME_CONTRACT_GUIDE_EMP);
        System.out.println(HOME_CONTRACT_GUIDE_EMP_);
        System.out.println(END_LINE);
    }

    private void printSalesEducationEmployeeMenu() {
        System.out.println(HOME_SALES_EDU_EMP);
        System.out.println(HOME_SALES_EDU_EMP_);
        System.out.println(END_LINE);
    }

    private void printSalesEmployeeMenu() {
        System.out.println(HOME_SALES_EMP);
        System.out.println(HOME_SALES_EMP_);
        System.out.println(END_LINE);
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

    public void contractExpiration(ArrayList<ExpirationResponse> arrayList){
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

    public RewardEvaluateResponse rewardChoice(ArrayList<RewardEvaluateResponse> rewardEvaluateRespons) {
        System.out.println("");
        System.out.println("담당자 미배정 사건 목록");
        for(int i = 0; rewardEvaluateRespons.size() > i; i++) {
            System.out.println("| 번호: "+i);
            System.out.println("  사용자: "+ rewardEvaluateRespons.get(i).getCustomerId());
            System.out.println("  청구 내용: "+ rewardEvaluateRespons.get(i).getClaimContent());
            System.out.println("  청구 금액: "+ rewardEvaluateRespons.get(i).getClaimCost());
        }
        System.out.println("");
        System.out.print("담당하려는 사건의 번호를 입력해주세요. \n번호 입력: ");
        int choice = scanner.nextInt();
        System.out.println("  사용자: "+ rewardEvaluateRespons.get(choice).getCustomerId());
        System.out.println("  청구 내용: "+ rewardEvaluateRespons.get(choice).getClaimContent());
        System.out.println("  청구 금액: "+ rewardEvaluateRespons.get(choice).getClaimCost());

        System.out.println("청구에 대한 결과를 입력해주세요. \n");
        System.out.print("1.승인   2.거부   3.보류  \n");
        int resultChoice = scanner.nextInt();
        if(resultChoice==1){
            rewardEvaluateRespons.get(choice).setClaimStatus("승인");
        }else if(resultChoice==2){
            rewardEvaluateRespons.get(choice).setClaimStatus("거부");
        }else{
            rewardEvaluateRespons.get(choice).setClaimStatus("보류");
        }

        return rewardEvaluateRespons.get(choice);
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

    public String getText(String message) {
        System.out.println(message);
        return scanner.next();
    }
}
