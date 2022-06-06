package global.util;

import domain.contract.dto.InsuranceNearExpireAlarm;

public class makeForm {

    public static void sendExpireAlarmEmail(InsuranceNearExpireAlarm insuranceNearExpireAlarm) {
        String email = makeExpireAlarmEmail(insuranceNearExpireAlarm);
        System.out.println(email);
        System.out.println("위의 이메일을 전송하였습니다.");
        System.out.println();
    }

    public static String makeExpireAlarmEmail(InsuranceNearExpireAlarm insuranceNearExpireAlarm) {
        String content = "--------------------------------------------------------------\n";
        content+="-- 고객 아이디                   :"+insuranceNearExpireAlarm.getCustomerId()+"\n";
        content+="-- 고객 명                      :"+insuranceNearExpireAlarm.getCustomerName()+"\n";
        content+="-- 고객 전화번호                  :"+insuranceNearExpireAlarm.getPhoneNumber()+"\n";
        content+="-- 계약 만료 임박 보험 아이디        :"+insuranceNearExpireAlarm.getInsuranceId()+"\n";
        content+="-- 계약 만료 임박 보험 이름         :"+insuranceNearExpireAlarm.getInsuranceName()+"\n";
        content+="-- 계약 만료 임박 보험 월 지불 비용   :"+insuranceNearExpireAlarm.getFee()+"\n";
        content+="-- 계약 만료 일                   :"+insuranceNearExpireAlarm.getExpiredDate()+"\n";
        content +="-- from." + "아프시죠보험" + "        to." + insuranceNearExpireAlarm.getEmail()+"\n";
        content += "---------------------------------------------------------------";
        return content;
    }

    public static void sendNearPaymentEmail(InsuranceNearExpireAlarm insuranceNearExpireAlarm) {
        String email = makeExpireAlarmEmail(insuranceNearExpireAlarm);
        System.out.println(email);
        System.out.println("위의 이메일을 전송하였습니다.");
        System.out.println();
    }

    public static String makeNearPaymentEmail(InsuranceNearExpireAlarm insuranceNearExpireAlarm) {
        String content = "--------------------------------------------------------------\n";
        content+="-- 고객 아이디                   :"+insuranceNearExpireAlarm.getCustomerId()+"\n";
        content+="-- 고객 명                      :"+insuranceNearExpireAlarm.getCustomerName()+"\n";
        content+="-- 고객 전화번호                  :"+insuranceNearExpireAlarm.getPhoneNumber()+"\n";
        content+="-- 계약 만료 임박 보험 아이디        :"+insuranceNearExpireAlarm.getInsuranceId()+"\n";
        content+="-- 계약 만료 임박 보험 이름         :"+insuranceNearExpireAlarm.getInsuranceName()+"\n";
        content+="-- 계약 만료 임박 보험 월 지불 비용   :"+insuranceNearExpireAlarm.getFee()+"\n";
        content+="-- 계약 만료 일                   :"+insuranceNearExpireAlarm.getExpiredDate()+"\n";
        content +="-- from." + "아프시죠보험" + "        to." + insuranceNearExpireAlarm.getEmail()+"\n";
        content += "---------------------------------------------------------------";
        return content;
    }
}
