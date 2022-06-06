package global.util;

import domain.customer.entity.FindPayment;
import domain.insurance.entity.Insurance;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import static global.util.constants.CustomerConstants.*;

public class CustomerComment extends CommonComment{

    Scanner scanner;

    public CustomerComment() {
        this.scanner = new Scanner(System.in);
    }

    public void greetToCustomer(String customerName){
        System.out.println(customerName + GREET);
    }

    public void thanksForEvaluation(String customerName){
        System.out.println(customerName + THANKS_EVALUATION);
    }

    public void notifyCompleteConsultRequest(String customerName) {
        System.out.println(customerName+COMP_CONSULT_REQ);
    }

    public void notifyCompleteJoining(String customerName) {
        System.out.println(customerName+COMP_JOINING);
    }

    public int customerInitial(){
        System.out.println(INITIAL_MSG);
        System.out.println(INITIAL_MENU);
        System.out.print(SELECT_NUM);
        return scanner.nextInt();
    }

    public int afterLogin() {
        System.out.println(INITIAL_MENU_1);
        System.out.println(INITIAL_MENU_2);
        System.out.println(INITIAL_MENU_3);
        System.out.println(INITIAL_MENU_4);
        System.out.println(INITIAL_MENU_5);
        System.out.println(INITIAL_MENU_6);
        System.out.println(INITIAL_MENU_7);
        System.out.println(INITIAL_MENU_8);
        System.out.println(SELECT_NUM);
        return scanner.nextInt();
    }

    public int printJoinedInsurances() {
        System.out.println(JOINED_INSURANCE_MENU_1);
        System.out.println(JOINED_INSURANCE_MENU_2);
        System.out.print(SELECT_NUM);
        return scanner.nextInt();
    }

    public int afterLoginInterest() {
        System.out.println(AFTER_LOGIN_INTEREST_MENU_1);
        System.out.println(AFTER_LOGIN_INTEREST_MENU_2);
        System.out.println(AFTER_LOGIN_INTEREST_MENU_3);
        System.out.println(AFTER_LOGIN_INTEREST_MENU_4);
        return scanner.nextInt();
    }

    public void findPaymentHistory(ArrayList<FindPayment> findPayment) {
        System.out.println(PAYMENT_HISTORY_START);
        for(int i=0; findPayment.size()>i; i++) {
            System.out.print(INSURANCE_NAME + findPayment.get(i).getInsuranceName());
            System.out.print(PAYMENT_FEE + findPayment.get(i).getFee());
            System.out.println(PAYDAY + findPayment.get(i).getPayDate());
        }
        System.out.println(END_LINE);
    }

    public void joinedInsurances(ArrayList<Insurance> insuranceArrayList) {
        System.out.println(INSURANCE_JOIN_HISTORY_START);
        for (Insurance insurance : insuranceArrayList) {
            System.out.print(INSURANCE_NAME + insurance.getInsuranceName());
            System.out.print(INSURANCE_CATEGORY + insurance.getKindOfInsurance());
            System.out.println(INSURANCE_REWARD + insurance.getFee());
        }
        System.out.println(END_LINE);
    }

    public String interestInsurances(ArrayList<Insurance> insuranceArrayList) {
        System.out.println(INSURANCE_INTEREST_HISTORY_START);
        for(int i=0; insuranceArrayList.size()>i; i++) {
            System.out.print(INSURANCE_NUMBER+ i);
            System.out.print(INSURANCE_NAME+insuranceArrayList.get(i).getInsuranceName());
            System.out.print(INSURANCE_CATEGORY+insuranceArrayList.get(i).getKindOfInsurance());
            System.out.println(INSURANCE_REWARD+insuranceArrayList.get(i).getFee());
        }
        System.out.println(END_LINE);
        System.out.print(SELECT_NUMBER_TO_JOIN);
        return insuranceArrayList.get(scanner.nextInt()).getInsuranceId();
    }

    public int checkPayer() {
        System.out.println(CHECK_PAYER);
        System.out.print(SELECT_NUM);
        return scanner.nextInt();
    }

    public int checkBeneficiary() {
        System.out.println(CHECK_BENEFICIARY);
        System.out.print(SELECT_NUM);
        return scanner.nextInt();
    }

    public String getName() {
        System.out.println(ENTER_NAME);
        return scanner.next();
    }

    public int getKindOfInsuranceId() {
        System.out.println(ASK_INSURANCE_CATEGORY);
        return scanner.nextInt();
    }

    public String getAddress() {
        System.out.println(ENTER_ADDRESS);
        return scanner.next();
    }

    public String getDetailAddress() {
        System.out.println(ENTER_DETAIL_ADDRESS);
        return scanner.next();
    }

    public String getZipcode() {
        System.out.println(ENTER_ZIPCODE);
        return scanner.next();
    }

    public String getEmail() {
        System.out.println(ENTER_EMAIL);
        return scanner.next();
    }

    public String getPhoneNumber() {
        System.out.println(ENTER_PHONE);
        return scanner.next();
    }

    public String getSatisfaction() {
        System.out.println(SATISFACTION);
        return scanner.next();
    }

    public int getKindOfJob() {
        System.out.println(JOB_1);
        System.out.println(JOB_2);
        System.out.println(JOB_3);
        System.out.println(JOB_4);
        System.out.print(SELECT_NUM);
        return scanner.nextInt();
    }

    public String getAccount() {
        System.out.print(ACCOUNT);
        return scanner.next();
    }

    public String getCarNumber() {
        System.out.println(CAR_NUMBER);
        return scanner.next();
    }

    public String getIncidentSite() {
        System.out.println(INCIDENT_SITE);
        return scanner.next();
    }

    public Date getIncidentDate() {
        System.out.println(INCIDENT_DATE);
        String incidentDate = scanner.next();
        return java.sql.Date.valueOf(incidentDate);
    }

    public String getClaimContent() {
        System.out.println(CLAIM_CONTENTS);
        return scanner.next();
    }

    public int getClaimCost() {
        System.out.println(CLAIM_MONEY);
        return scanner.nextInt();
    }

    public String getSsn() {
        System.out.println(SSN);
        return scanner.next();
    }
}
