package domain.employee.service;

import domain.contract.dto.InsuranceNearExpireAlarm;
import domain.contract.entity.Contract;
import domain.customer.entity.Customer;
import domain.customer.entity.Payer;
import domain.employee.dto.CustomerConsultResponse;
import domain.employee.entity.Employee;
import domain.employee.repository.EmployeeRepository;
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

    public ArrayList<Payer> getNearPaymentDayPayerList() {
        // TODO InsurancePaymentAlarm 객체로 바꿔서 이메일 보내기
        return null;
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
}