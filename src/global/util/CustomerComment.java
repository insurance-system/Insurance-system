package global.util;

import domain.insurance.entity.Insurance;

public class CustomerComment {

    public void insuranceInformation(Insurance insurance){
        System.out.println("-------------------보험 가입 내역-------------------");
        System.out.print(" 보험 이름 : "+insurance.getInsuranceName());
        System.out.println(" 보험금 : "+insurance.getFee());
        System.out.println("--------------------------------------------------");
    }
}
