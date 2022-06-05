package domain.employee.controller;

import domain.contract.dto.NewInsurance;
import domain.contract.entity.Contract;
import domain.customer.dto.UwRequest;
import domain.employee.dto.*;
import domain.employee.entity.Employee;
import domain.employee.exception.excution.*;
import domain.employee.service.*;
import domain.insurance.entity.InsuranceCondition;
import global.dao.Lecture;
import global.util.EmployeeComment;

import java.util.ArrayList;

import static global.util.constants.EmployeeConstants.*;

public class EmployeeController {

    private final EmployeeService employeeService;
    private final SalesEmployeeService salesEmployeeService;
    private final SalesEduEmployeeService salesEduEmployeeService;
    private final ContractGuideEmployeeService contractGuideEmployeeService;
    private final UWEmployeeService UWEmployeeService;
    private final ContractManageEmployeeService contractManageEmployeeService;
    private final InsuranceDevelopmentEmployeeService insuranceDevelopmentEmployeeService;
    private final CustomerInformationManageService customerInformationManageService;
    private final IncidentManageService incidentManageService;
    private final RewardManageService rewardManageService;

    private final EmployeeComment employeeComment;


    public EmployeeController() {
        this.employeeComment = new EmployeeComment();
        this.employeeService = new EmployeeService();
        this.salesEmployeeService = new SalesEmployeeService();
        this.salesEduEmployeeService = new SalesEduEmployeeService();
        this.contractGuideEmployeeService = new ContractGuideEmployeeService();
        this.UWEmployeeService = new UWEmployeeService();
        this.contractManageEmployeeService = new ContractManageEmployeeService();
        this.insuranceDevelopmentEmployeeService = new InsuranceDevelopmentEmployeeService();
        this.customerInformationManageService = new CustomerInformationManageService();
        this.incidentManageService = new IncidentManageService();
        this.rewardManageService = new RewardManageService();
    }

    public void initial() {
        Exit:
        while (true){
            switch (employeeComment.getLoginOrExit()){
                case 1 :
                    Employee employee = login();
                    if(employee != null) home(employee);
                    else new NoEmployeeException();
                    break;
                case 0 :
                    break Exit;
            }
        }
    }

    private Employee login() {
        return employeeService.login(employeeComment.getId(),employeeComment.getPassword());
    }

    private void home(Employee employee){
        Exit:
        while(true){
            switch (this.employeeComment.home()){
                case 11:
                    doSalesEmployeeService(employee);//상담 대기 신규 고객 명단 조회
                    break;
                case 12:
                    registerSalesEdu(employee);//영업 교육 수강
                    break;
                case 21:
                    uploadEducationLecture(employee);//영업 교육 강의 업로드
                    break;
                case 22:
                    findLectureList(employee);//강의 자료 리스트 출력
                    break;
                case 23:
                    findLectureRegistrationList(employee);
                    break;
                case 31:
                    notifyContractStatus(employee);//보험 가입자에게 보험 계약 상태(고객 만기 및 미납 여부)를 안내한다.
                    break;
                case 41:
                    contractExpiration(employee);//보험 만기 고객 조회//건강정보 테이블에 고객 ID 들어가야함
                    break;
                case 42:
                    contractDefault(employee); //미납 고객 조회
                    break;
                case 51:
                    startUW(employee);//인수심사 수행
                    break;
                case 61:
                    developInsurance(employee);
                    break;
                case 71:
                    printCustomerInformation(employee);//고객 정보를 제공
                    break;
                case 81:
                    printMarketInformation(employee);//보험 시장 데이터 제공
                    break;
                case 91:
                    manageIncidentReport(employee);
                    break;
                case 101:
                    evaluateReward(employee);//보상평가팀//보상금을 심사하다
                    break;
                case 0:
                    System.out.println(TERMINATE_EMPLOYEE_SYSTEM);
                    break Exit;
                default:
                    new CheckMenuNumberException();
                    break;
            }
        }
    }

    /* -------------------------------- sales -------------------------------- */

    private void doSalesEmployeeService(Employee employee) {
        if (employee.getDepartmentId().equals(DEPT_SALES)){
            ArrayList<EmpCustomer> arrayList = salesEmployeeService.customerConsult(employee);
            if (!arrayList.isEmpty()){
                employeeComment.startConsult();
                salesEmployeeService.consultExecute(employee, arrayList.get(employeeComment.customerConsultList(arrayList)));
                employeeComment.completeConsult();
            }else{
                new NoConsultCustomerException();
            }
        }else{
            new NoAuthorityDPException();
        }
    }

    private void registerSalesEdu(Employee employee) {
        if (employee.getDepartmentId().equals(DEPT_SALES)){

        }else{
            new NoAuthorityDPException();
        }
        return;
    }
    /* ---------------------------------------------------------------------- */


    /* -------------------------------- Edu --------------------------------- */
    public void uploadEducationLecture(Employee lecturer){
        if (!lecturer.getDepartmentId().equals(DEPT_EDU)){
            new NoAuthorityDPException();
            return;
        }
        String lectureName = employeeComment.getLectureName();//TODO choice comment로 옮기기
        String lecturePdfName = employeeComment.getLecturePdfName();
        String lectureId = lectureName.length() + lecturer.getEmployeeId();
        Lecture lecture = new Lecture(lectureId, lectureName, lecturePdfName, lecturer.getEmployeeId());
        if(salesEduEmployeeService.uploadEducationLecture(lecture)) employeeComment.printSuccessRegistrationMessage();
        else employeeComment.printFailRegistrationMessage();
    }

    private void findLectureList(Employee eduEmployee) {
        if (!(eduEmployee.getDepartmentId().equals(DEPT_EDU)) || !(eduEmployee.getDepartmentId().equals(DEPT_SALES))){
            new NoAuthorityDPException();
            return;
        }
        ArrayList<Lecture> lectureList = salesEduEmployeeService.findLectureList();
        for (Lecture lecture : lectureList) {
            System.out.println(lecture);
        }
    }

    private void findLectureRegistrationList(Employee employee) {
        //수강 명단 체크
        if (employee.getDepartmentId().equals(DEPT_EDU)){

        }else{
            new NoAuthorityDPException();
        }
        return;
    }
    /* -------------------------------------------------------------------------------- */


    /* -------------------------------- ContractGuide --------------------------------- */
    private void notifyContractStatus(Employee employee){
        if (!employee.getDepartmentId().equals(DEPT_CONTRACT_GUIDE)){
            new NoAuthorityDPException();
            return;
        }
        switch(employeeComment.notifyMenu()){
            case 1:
                getNearExpireContractList();
                break;
            case 2:
                getNearPaymentContractList();
                break;
        }
    }

    private void getNearExpireContractList() {
        ArrayList<Contract> nearExpireContractList = contractGuideEmployeeService.getNearExpireContractList();
        employeeComment.printNearContractsListMsg();
        for (Contract contract : nearExpireContractList)
            System.out.println(contract);
        employeeComment.printLine();
        employeeComment.printSendNearExpirationMailMsg();
        if(employeeComment.yesOrNo() == 1) contractGuideEmployeeService.sendEmailNearExpireContract(nearExpireContractList);
    }

    private void getNearPaymentContractList() {
        ArrayList<Contract> nearPaymentContractList = contractGuideEmployeeService.getNearPaymentContractList();
        employeeComment.printNearPayDayContractsListMsg();
        for (Contract contract : nearPaymentContractList) System.out.println(contract);
        employeeComment.printLine();
        employeeComment.printSendNearExpirationMailMsg();
        if(employeeComment.yesOrNo() == 1) contractGuideEmployeeService.sendNearPaymentContract(nearPaymentContractList);
    }
    /* ------------------------------------------------------------------------------------- */

    /* -------------------------------- Contract Management --------------------------------- */

    private void contractExpiration(Employee employee) {
        if (employee.getDepartmentId().equals(DEPT_CONTRACT_GUIDE)) {
            employeeComment.contractExpiration(((ContractManageEmployeeService)employeeService).selectContractExpiration());
        }else new NoAuthorityDPException();
    }

    private void contractDefault(Employee employee) {
        if (employee.getDepartmentId().equals(DEPT_CONTRACT_GUIDE)) {
            employeeComment.contractDefault(this.contractManageEmployeeService.selectDefaultCustomer());
        }else new NoAuthorityDPException();
    }


    /* -------------------------------------------------------------------------------- */

    /* -------------------------------------- U/W ------------------------------------- */
    private void startUW(Employee employee) {
        if (employee.getDepartmentId().equals(DEPT_UW)){
            new NoAuthorityDPException();
            return;
        }
        employeeComment.getUwCustomerList();
        switch(employeeComment.yesOrNo()){
            case 1:
                getUwCustomerList();
                break;
            case 2:
                break;
        }
    }

    private void getUwCustomerList() {
        ArrayList<UwRequest> uwRequests = UWEmployeeService.getUwCustomerList();
        for (UwRequest acceptanceReviewCustomer : uwRequests)
            System.out.println(acceptanceReviewCustomer);
        String customerId = employeeComment.getCustomerId();
        UwRequest uwRequest =
                uwRequests.stream()
                        .filter((aar) -> aar.getCustomerId().equals(customerId))
                        .findFirst()
                        .orElseThrow(NoEmployeeException::new);

        UWEmployeeService.getUwDetail(uwRequest);
    }
    /* -------------------------------------------------------------------------------- */

    /* -------------------------- development Insurance -------------------------------- */
    private void developInsurance(Employee employee) {
        if (!employee.getDepartmentId().equals(DEPT_INSURANCE_DEV)){
            new NoAuthorityDPException();
            return;
        }
        ArrayList<CustomerAnalysisInformation> customerAnalysisInformations = provideCustomerInformation();
        MarketInsuranceInformationResponse marketInsuranceInformationResponse = provideMarketInformation();
        employeeComment.printCustomerAnalysisDataMsg();
        for (CustomerAnalysisInformation customerAnalysisInformation : customerAnalysisInformations)
            System.out.println(customerAnalysisInformation);
        employeeComment.printLine();
        employeeComment.printMarketAnalysisDataMsg();
        System.out.println(marketInsuranceInformationResponse);
        employeeComment.printLine();

        InsuranceCondition insuranceCondition = getInsuranceCondition();
        NewInsurance newInsurance = getNewInsurance(insuranceCondition);

        if(insuranceDevelopmentEmployeeService.developInsurance(newInsurance))
            employeeComment.printSuccessInsuranceRegistrationMsg();
    }

    private NewInsurance getNewInsurance(InsuranceCondition insuranceCondition) {
        String insuranceName = employeeComment.getInsuranceName();
        int kindOfInsurance = employeeComment.getKindOfInsurance();
        int insuranceFee = employeeComment.getInsuranceFee();
        return new NewInsurance(insuranceName, kindOfInsurance, insuranceFee, insuranceCondition);
    }

    private InsuranceCondition getInsuranceCondition() {
        int maxAge = employeeComment.getMaxAge();
        int minAge = employeeComment.getMinAge();
        String smoke = employeeComment.getSmoke();
        String alcohol = employeeComment.getAlcohol();
        String cancer = employeeComment.getCancer();
        return new InsuranceCondition(maxAge,minAge,smoke,alcohol,cancer);
    }
    /* -------------------------------------------------------------------------------- */

    /*------------------------- information analysis --------------------------*/

    public void printCustomerInformation(Employee employee){
        if (!employee.getDepartmentId().equals(DEPT_CUSTOMER_INFO)){
            new NoAuthorityDPException();
            return;
        }
        ArrayList<CustomerAnalysisInformation> customerAnalysisInformations = provideCustomerInformation();
        for (CustomerAnalysisInformation customerAnalysisInformation : customerAnalysisInformations)
            System.out.println(customerAnalysisInformation);
    }

    public ArrayList<CustomerAnalysisInformation> provideCustomerInformation(){
        return customerInformationManageService.provideCustomerInformation();
    }

    private void printMarketInformation(Employee employee) {
        if (!employee.getDepartmentId().equals(DEPT_MARKET_ANAL)){
            new NoAuthorityDPException();
            return;
        }
        System.out.println(provideMarketInformation());
    }

    public MarketInsuranceInformationResponse provideMarketInformation(){
        return new MarketInsuranceInformationResponse();
    }
    /*---------------------------------------------------------------------------*/

    /*------------------------- evaluate reward --------------------------*/

    private void evaluateReward(Employee employee) {
        if (employee.getDepartmentId().equals(DEPT_REWARD)) {
            ArrayList<RewardEvaluateResponse> rewardEvaluateResponses = this.rewardManageService.rewardEvaluate();
            if(!rewardEvaluateResponses.isEmpty()) this.rewardManageService.rewardAssign(this.employeeComment.rewardChoice(rewardEvaluateResponses));
            else new NoRewardException();
        }else new NoAuthorityDPException();
    }
    /*---------------------------------------------------------------------------*/

    /*------------------------- manage incident --------------------------*/
    private void manageIncidentReport(Employee employee) {
        //손해접수팀
        //사고 발생 신고를 접수받는다.
        if (employee.getDepartmentId().equals(DEPT_INCIDENT_MNG)) {
            ArrayList<IncidentResponse> incidentResponses = this.incidentManageService.IncidentAccept(employee);
            if(!incidentResponses.isEmpty()){
                this.incidentManageService.incidentAssign(
                        employee,
                        incidentResponses.get(this.employeeComment.incidentChoice(incidentResponses))
                );
                employeeComment.printMngSettingCompleteMsg();
            }else new NoIncidentException();
        }else new NoAuthorityDPException();
        return;
    }
    /*---------------------------------------------------------------------------*/

    /* ------------ FROM CUSTOMER CONTROLLER ----------- */
    public void doContractExpiration(){}
    public void doInsuranceContract(Contract contract){
        salesEmployeeService.doInsuranceContract(contract);
    }
    /* -------------------------------------------------- */


}
