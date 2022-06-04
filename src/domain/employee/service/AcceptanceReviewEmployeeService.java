package domain.employee.service;

import domain.customer.dto.AcceptanceReviewCustomer;
import domain.customer.dto.AcceptanceReviewRequest;
import domain.insurance.dto.AcceptanceReviewInsurance;

import java.util.ArrayList;

public class AcceptanceReviewEmployeeService extends EmployeeService{

    // TODO 인수심사 대기 명단 고객 테이블에서 select ALL 해오기
    public ArrayList<AcceptanceReviewRequest> getAcceptanceReviewCustomerList() {
        return employeeRepository.getAcceptanceReviewCustomerList();
    }

    // TODO Customer table에 healthInformation과 creditInformation을 외래키로 참조하기
    public void getAcceptanceReviewDetail(AcceptanceReviewRequest acceptanceReviewRequest) {
        AcceptanceReviewCustomer acceptanceReviewCustomer =
                employeeRepository.getAcceptanceReviewCustomerById(acceptanceReviewRequest.getCustomerId());
        System.out.println("acceptanceReviewCustomer"); // acceptanceReviewCustomer 보여주고
        AcceptanceReviewInsurance acceptanceReviewInsurance =
                employeeRepository.getAcceptanceReviewInsuranceById(acceptanceReviewRequest.getRequestInsuranceId());
        System.out.println("acceptanceReviewInsurance"); // acceptanceReviewInsurance 보여주고

        System.out.println("해당 고객의 보험 가입 요청을 허용 하시겠습니까?"); //고르게 하고
    }


}
