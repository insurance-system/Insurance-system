package global.util;

import domain.customer.entity.FindPayment;
import domain.insurance.entity.Insurance;

public class CustomerComment {

    public void insuranceInformation(Insurance insurance){
        System.out.println("-------------------보험 가입 내역-------------------");
        System.out.print(" 보험 이름 : "+insurance.getInsuranceName());
        System.out.println(" 보험금 : "+insurance.getFee());
        System.out.println("--------------------------------------------------");
    }

    public void findPaymentHistory(FindPayment findPayment) {
        System.out.println("-------------------보험금 납부 내역-------------------");
        System.out.print(" 보험 이름 : "+findPayment.getInsuranceName());
        System.out.print(" 납부 금액 : "+findPayment.getFee());
        System.out.println(" 납부 일 : "+findPayment.getPayDate());
        System.out.println("--------------------------------------------------");
    }
}
