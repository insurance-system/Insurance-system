package global.util;

import domain.customer.dto.UwRequest;
import domain.employee.dto.*;
import domain.employee.exception.excution.CheckMenuNumberException;

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
        return validateInt();
    }

    private void printRewardManagementEmployeeMenu(){
        System.out.println(HOME_REWARD_EMP_MENU);
        System.out.println(HOME_REWARD_EMP_MENU_);
        System.out.println(END_LINE);
    }

    private void printIncidentManagementEmployeeMenu(){
        System.out.println(HOME_INCIDENT_EMP_MENU);
        System.out.println(HOME_INCIDENT_EMP_MENU_);
        System.out.println(END_LINE);
    }

    private void printMarketAnalysisEmployeeMenu(){
        System.out.println(HOME_MARKET_ANALYSIS_EMP);
        System.out.println(HOME_MARKET_ANALYSIS_EMP_);
        System.out.println(END_LINE);
    }

    private void printCustomerInformationEmployeeMenu(){
        System.out.println(HOME_CUS_INFORMATION_EMP);
        System.out.println(HOME_CUS_INFORMATION_EMP_);
        System.out.println(END_LINE);
    }

    private void printInsuranceDevelopmentEmployeeMenu(){
        System.out.println(HOME_INSURANCE_DEV_EMP);
        System.out.println(HOME_INSURANCE_DEV_EMP_);
        System.out.println(END_LINE);
    }

    private void printUWEmployeeMenu(){
        System.out.println(HOME_UW_EMP);
        System.out.println(HOME_UW_EMP_);
        System.out.println(END_LINE);
    }

    private void printContractManagementEmployeeMenu(){
        System.out.println(HOME_CONTRACT_MNG_EMP);
        System.out.println(HOME_CONTRACT_MNG_EMP_);
        System.out.println(END_LINE);
    }

    private void printContractGuideMenu(){
        System.out.println(HOME_CONTRACT_GUIDE_EMP);
        System.out.println(HOME_CONTRACT_GUIDE_EMP_);
        System.out.println(END_LINE);
    }

    private void printSalesEducationEmployeeMenu(){
        System.out.println(HOME_SALES_EDU_EMP);
        System.out.println(HOME_SALES_EDU_EMP_);
        System.out.println(END_LINE);
    }

    private void printSalesEmployeeMenu(){
        System.out.println(HOME_SALES_EMP);
        System.out.println(HOME_SALES_EMP_);
        System.out.println(END_LINE);
    }

    public int customerConsultList(ArrayList<EmpCustomer> arrayList) {
        System.out.println(LINE_BREAK+ CUSTOMER_CUNSULT_LIST_START);
        for(int i=0; arrayList.size() > i; i++){
            System.out.println(VERTICAL_BAR+NUMBER+i+NAME+arrayList.get(i).getName()+PHONE_NUMBER+arrayList.get(i).getPhoneNumber());
            System.out.println(KIND_OF_JOB+arrayList.get(i).getKindOfJob());
            System.out.println(KIND_OF_INSURANCE+arrayList.get(i).getKindOfInsurance().name()+LINE_BREAK);
        }
        System.out.print(ASK_CONSULT_CUSTOMER+SELECT_NUM);
        while(true) {
            int choice = validateInt();
            if (choice > arrayList.size()) {
                choice = validateInt();
            }
            return choice;
        }
    }

    public void contractExpiration(ArrayList<ExpirationResponse> expirationResponses){
        System.out.println(LINE_BREAK+ EXPIRED_CUSTOMER_LIST_START);
        for (ExpirationResponse expirationResponse : expirationResponses) {
            System.out.println(VERTICAL_BAR + NAME + expirationResponse.getName() + PHONE_NUMBER + expirationResponse.getPhoneNumber());
            System.out.println(KIND_OF_JOB + expirationResponse.getKindOfJob());
            System.out.println(KIND_OF_INSURANCE + expirationResponse.getKindOfInsurance().name());
            System.out.println(JOINED_INSURANCE_NAME + expirationResponse.getInsuranceName());
            System.out.println(INSURANCE_STATUS + expirationResponse.getContractStatus() + LINE_BREAK);
        }
    }

    public void contractDefault(ArrayList<DefaultResponse> DefaultResponses) {
        System.out.println(LINE_BREAK+DEFAULT_CUSTOMER_LIST_START);
        for (DefaultResponse defaultResponse : DefaultResponses) {
            System.out.println(VERTICAL_BAR + NAME + defaultResponse.getName() + PHONE_NUMBER + defaultResponse.getPhoneNumber());
            System.out.println(ADDRESS + defaultResponse.getAddress() + DETAIL_ADDRESS + defaultResponse.getDetailAddress());
            System.out.println(ZIPCODE + defaultResponse.getZipCode());
            System.out.println(JOINED_INSURANCE_NAME + defaultResponse.getInsuranceName());
            System.out.println(INSURANCE_STATUS + defaultResponse.getContractStatus() + LINE_BREAK);
        }
    }

    public int notifyMenu() {
        System.out.println(NOTIFY_MENU_1);
        System.out.println(NOTIFY_MENU_2);
        System.out.println(NOTIFY_MENU_3);
        return validateInt();
    }

    public int yesOrNo() {
        System.out.println(YES_OR_NO_1);
        System.out.println(YES_OR_NO_2);
        return validateInt();
    }

    public int askPermit() {
        System.out.println(EXAMINATION_1);
        System.out.println(EXAMINATION_2);
        System.out.println(EXAMINATION_3);
        return scanner.nextInt();
    }

    public String getCustomerId() {
        System.out.println(ASK_CUSTOMER_TO_UW);
        System.out.print(CUSTOMER_ID);
        return scanner.next();
    }

    public int incidentChoice(ArrayList<IncidentResponse> incidentAccept) {
        System.out.println(LINE_BREAK+UNCHOICED_INCIDENT_LIST_START);
        for(int i=0; incidentAccept.size() > i; i++) {
            System.out.println(VERTICAL_BAR+NUMBER+i);
            System.out.println(NAME+incidentAccept.get(i).getName()+PHONE_NUMBER+incidentAccept.get(i).getPhoneNum());
            System.out.println(ADDRESS+incidentAccept.get(i).getAddress());
            System.out.println(DATE+incidentAccept.get(i).getDate());
        }
        System.out.print(LINE_BREAK+ASK_CHOICED_INCIDENT);
        System.out.println(SELECT_NUM);
        while(true) {
            int choice = validateInt();
            if (choice > incidentAccept.size()) {
                choice = validateInt();
            }
            return choice;
        }
    }

    public RewardEvaluateResponse rewardChoice(ArrayList<RewardEvaluateResponse> rewardEvaluateRespons) {
        System.out.println(LINE_BREAK+UNCHOICED_INCIDENT_LIST_START);
        for(int i = 0; rewardEvaluateRespons.size() > i; i++) {
            System.out.println(VERTICAL_BAR+NUMBER+i);
            System.out.println(CUSTOMER+ rewardEvaluateRespons.get(i).getCustomerId());
            System.out.println(CLAIM_CONTENTS+ rewardEvaluateRespons.get(i).getClaimContent());
            System.out.println(CLAIM_MONEY+ rewardEvaluateRespons.get(i).getClaimCost());
        }
        System.out.println("");
        System.out.print(LINE_BREAK+ASK_CHOICED_INCIDENT);
        System.out.println(SELECT_NUM);
        int choice;
        while(true) {
            choice = validateInt();
            if (choice > rewardEvaluateRespons.size()) {
                choice = validateInt();
            }
            break;
        }

        System.out.println(CUSTOMER+ rewardEvaluateRespons.get(choice).getCustomerId());
        System.out.println(CLAIM_CONTENTS+ rewardEvaluateRespons.get(choice).getClaimContent());
        System.out.println(CLAIM_MONEY+ rewardEvaluateRespons.get(choice).getClaimCost());

        System.out.println(ASK_RESULT_OF_CLAIM);
        System.out.println(EXAMINATION_1+EXAMINATION_2+EXAMINATION_3);
        int resultChoice;
        while(true) {
            resultChoice = validateInt();
            if (choice > 3) {
                choice = validateInt();
            }
            break;
        }

        if(resultChoice==1){
            rewardEvaluateRespons.get(choice).setClaimStatus(PERMISSION);
        }else if(resultChoice==2){
            rewardEvaluateRespons.get(choice).setClaimStatus(NOT_ALLOWED);
        }else{
            rewardEvaluateRespons.get(choice).setClaimStatus(UNDER_EXAMINATION);
        }
        return rewardEvaluateRespons.get(choice);
    }

    public void developInsurance() {
        System.out.println(DEVELOP_INSURANCE_START);
        System.out.print(INSURANCE_NAME);
        System.out.println(KIND_OF_INSURANCE_1+KIND_OF_INSURANCE_2);
    }

    public String getInsuranceName() {
        System.out.print(INSURANCE_NAME);
        return validateString();
    }

    public int getKindOfInsurance() {
        System.out.println(KIND_OF_INSURANCE_1+KIND_OF_INSURANCE_2);
        System.out.print(SELECT_NUM);
        return validateInt();
    }

    public int getInsuranceFee() {
        System.out.print(MONTHLY_INSURANCE_FEE);
        return validateInt();
    }


    public int getMaxAge() {
        System.out.print(MAX_AGE);
        return validateInt();
    }

    public int getMinAge() {
        System.out.print(MIN_AGE);
        return validateInt();
    }

    public String getSmoke() {
        System.out.println(SMOKE_CONDITION_START);
        System.out.println(SMOKE_CONDITION_A);
        System.out.println(SMOKE_CONDITION_B);
        System.out.println(SMOKE_CONDITION_C);
        return validateString();
    }

    public String getAlcohol() {
        System.out.println(ALCOHOL_CONDITION_START);
        System.out.println(ALCOHOL_CONDITION_A);
        System.out.println(ALCOHOL_CONDITION_B);
        System.out.println(ALCOHOL_CONDITION_C);
        return validateString();
    }

    public String getCancer() {
        System.out.println(CANCER_CONDITION_START);
        System.out.println(CANCER_CONDITION_A);
        System.out.println(CANCER_CONDITION_B);
        System.out.println(CANCER_CONDITION_C);
        return validateString();
    }

    public String getLectureName() {
        System.out.println(ASK_LECTURE_NAME);
        return scanner.next();
    }

    public String getLecturePdfName() {
        System.out.println(ASK_LECTURE_PDF_NAME);
        return scanner.next();
    }

    public void printSuccessRegistrationMessage() {
        System.out.println(REGISTRATION_LECTURE_SUCCESS);
    }

    public void printFailRegistrationMessage() {
        System.out.println(REGISTRATION_LECTURE_FAIL);
    }

    public void completeConsult() {
        System.out.println(CONSULT_COMPLETE);
    }

    public void startConsult() {
        System.out.println(CONSULT_START);
    }

    public void askUwCustomerList() {
        System.out.println(ASK_TO_GET_UW_CUSTOMER_LIST);
    }

    public void printNearContractsListMsg() {
        System.out.println(NEAR_CONTRACT_LIST_START);
    }

    public void printNearPayDayContractsListMsg() {
        System.out.println(NEAR_PAYDAY_CONTRACT_LIST_START);
    }

    public void printSendNearExpirationMailMsg() {
        System.out.println(ASK_MAIL_TO_NEAR_EXPIRATION_CUSTOMER);
    }

    public void printCustomerAnalysisDataMsg() {
        System.out.println(CUSTOMER_ANALYSIS_DATA_START);
    }

    public void printMarketAnalysisDataMsg() {
        System.out.println(MARKET_ANALYSIS_DATA_START);
    }

    public void printSuccessInsuranceRegistrationMsg() {
        System.out.println(REGISTRATION_INSURANCE_SUCCESS);
    }

    public void printMngSettingCompleteMsg() {
        System.out.println(REGISTRATION_MNG_SUCCESS);
    }

    public UwRequest selectUwList(ArrayList<UwRequest> uwRequests) {
        System.out.println(LINE_BREAK+ CUSTOMER_UW_LIST_START);
        for(int i=0; uwRequests.size() > i; i++){//.getContractId()
            System.out.println(VERTICAL_BAR+NUMBER+i+" "+NAME+uwRequests.get(i).getCustomerName());
            System.out.println("   "+"?????? ID:"+uwRequests.get(i).getCustomerId());
            System.out.println("   "+"?????? ID:"+uwRequests.get(i).getContractId());
//            System.out.println("   "+uwRequests.get(i).getExpiredDate());
        }
        System.out.println(ASK_CONSULT_CUSTOMER);
        System.out.print(SELECT_NUM);
        return uwRequests.get(scanner.nextInt());
    }

    public int validateInt(){
        while(true){
            String next = scanner.next();
            boolean isNumeric =  next.matches("[+-]?\\d*(\\.\\d+)?");
            if(isNumeric){
                return Integer.parseInt(next);
            }else{
                new CheckMenuNumberException();
            }
        }
    }

    public String validateString(){
        while(true){
            String next = scanner.next();
            boolean isNumeric =  next.matches("[+-]?\\d*(\\.\\d+)?");
            if(!isNumeric){
                return next;
            }else{
                new CheckMenuNumberException();
            }
        }
    }
}
