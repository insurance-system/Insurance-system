package domain.employee.service;

import domain.contract.dto.InsuranceNearExpireAlarm;
import domain.contract.entity.Contract;
import domain.customer.dto.AcceptanceReviewCustomer;
import domain.customer.dto.AcceptanceReviewRequest;
import domain.customer.entity.Customer;
import domain.employee.dto.CustomerConsultResponse;
import domain.employee.entity.Employee;
import domain.employee.repository.EmployeeRepository;
import domain.insurance.dto.AcceptanceReviewInsurance;
import domain.insurance.entity.Insurance;
import global.dao.Lecture;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;

import static global.util.makeForm.sendExpireAlarmEmail;


public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();

    }

    public Employee login(String employeeId, String password) {
        return this.employeeRepository.login(employeeId,password);
    }

    public ArrayList<CustomerConsultResponse> customerConsult(Employee employee) {
        return this.employeeRepository.customerConsult(employee);
    }

    public void consultExcute(Employee employee, CustomerConsultResponse customerConsultResponse) {
        this.employeeRepository.consultExcute(employee, customerConsultResponse);
    }
    public void findLectureRegistrationList() {

    }

    public boolean uploadEducationLecture(Lecture lecturer) {
        return employeeRepository.insertLecture(lecturer);
    }

    public ArrayList<Lecture> findLectureList(){
        return employeeRepository.selectLectureList();
    }


    public ArrayList<Contract> getNearExpireContractList() {
        ArrayList<Contract> contracts = employeeRepository.selectContractList();
        ArrayList<Contract> nearExpirationContracts = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (Contract contract : contracts){
            Period between = Period.between(contract.getExpiredDate(), now);
            if(between.getDays() <= 5) nearExpirationContracts.add(contract);
        }
        return nearExpirationContracts;
    }

    public ArrayList<Contract> getNearPaymentContractList() {
        ArrayList<Contract> contracts = employeeRepository.selectContractList();
        ArrayList<Contract> nearPaymentContracts = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (Contract contract : contracts){
            Period between = Period.between(contract.getPaymentDate(), now);
            if(between.getDays() <= 3) nearPaymentContracts.add(contract);
        }
        return nearPaymentContracts;
    }

    public void sendEmailNearExpireContract(ArrayList<Contract> nearExpireContractList) {
        ArrayList<Integer> insuranceIds = new ArrayList<>();
        ArrayList<String> customerIds = new ArrayList<>();
        for (Contract contract : nearExpireContractList){
            insuranceIds.add(contract.getInsuranceId());
            customerIds.add(contract.getCustomerId());
        }
        ArrayList<Insurance> insurances = employeeRepository.selectInsuranceByIds(insuranceIds);
        HashMap<Integer, Insurance> insuranceHash = new HashMap<>();
        for (Insurance insurance : insurances) insuranceHash.put(insurance.getInsuranceId(), insurance);

        ArrayList<Customer> customers = employeeRepository.selectCustomerByIds(customerIds);
        HashMap<String, Customer> customerHash = new HashMap<>();
        for (Customer customer : customers) customerHash.put(customer.getCustomerId(), customer);

        ArrayList<InsuranceNearExpireAlarm> InsuranceNearExpireAlarms = new ArrayList<>(nearExpireContractList.size());
        for(int i=0; i<nearExpireContractList.size(); i++){
            InsuranceNearExpireAlarm insuranceNearExpireAlarm = new InsuranceNearExpireAlarm(
                    customerHash.get(nearExpireContractList.get(i).getCustomerId()).getCustomerId(),
                    customerHash.get(nearExpireContractList.get(i).getCustomerId()).getEmail(),
                    customerHash.get(nearExpireContractList.get(i).getCustomerId()).getName(),
                    customerHash.get(nearExpireContractList.get(i).getCustomerId()).getPhoneNumber(),
                    nearExpireContractList.get(i).getInsuranceId(),
                    insuranceHash.get(nearExpireContractList.get(i).getInsuranceId()).getInsuranceName(),
                    insuranceHash.get(nearExpireContractList.get(i).getInsuranceId()).getFee(),
                    nearExpireContractList.get(i).getExpiredDate());
            InsuranceNearExpireAlarms.add(insuranceNearExpireAlarm);
        }
        for (InsuranceNearExpireAlarm insuranceNearExpireAlarm : InsuranceNearExpireAlarms)
            sendExpireAlarmEmail(insuranceNearExpireAlarm);

    }

    public void sendNearPaymentContract(ArrayList<Contract> nearExpireContractList) {
        ArrayList<Integer> insuranceIds = new ArrayList<>();
        ArrayList<String> customerIds = new ArrayList<>();
        for (Contract contract : nearExpireContractList){
            insuranceIds.add(contract.getInsuranceId());
            customerIds.add(contract.getCustomerId());
        }
        ArrayList<Insurance> insurances = employeeRepository.selectInsuranceByIds(insuranceIds);
        HashMap<Integer, Insurance> insuranceHash = new HashMap<>();
        for (Insurance insurance : insurances) insuranceHash.put(insurance.getInsuranceId(), insurance);

        ArrayList<Customer> customers = employeeRepository.selectCustomerByIds(customerIds);
        HashMap<String, Customer> customerHash = new HashMap<>();
        for (Customer customer : customers) customerHash.put(customer.getCustomerId(), customer);

        ArrayList<InsuranceNearExpireAlarm> InsuranceNearExpireAlarms = new ArrayList<>(nearExpireContractList.size());
        for(int i=0; i<nearExpireContractList.size(); i++){
            InsuranceNearExpireAlarm insuranceNearExpireAlarm = new InsuranceNearExpireAlarm(
                    customerHash.get(nearExpireContractList.get(i).getCustomerId()).getCustomerId(),
                    customerHash.get(nearExpireContractList.get(i).getCustomerId()).getEmail(),
                    customerHash.get(nearExpireContractList.get(i).getCustomerId()).getName(),
                    customerHash.get(nearExpireContractList.get(i).getCustomerId()).getPhoneNumber(),
                    nearExpireContractList.get(i).getInsuranceId(),
                    insuranceHash.get(nearExpireContractList.get(i).getInsuranceId()).getInsuranceName(),
                    insuranceHash.get(nearExpireContractList.get(i).getInsuranceId()).getFee(),
                    nearExpireContractList.get(i).getExpiredDate());
            InsuranceNearExpireAlarms.add(insuranceNearExpireAlarm);
        }
        for (InsuranceNearExpireAlarm insuranceNearExpireAlarm : InsuranceNearExpireAlarms)
            sendExpireAlarmEmail(insuranceNearExpireAlarm);
    }

    /*
    * 인수심사 대기 명단 고객 테이블:
    * AcceptanceRequestCustomer Table.
    * insuranceId
    * customerId
    * */

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