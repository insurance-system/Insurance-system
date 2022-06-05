package domain.employee.controller;

import domain.contract.dto.NewInsurance;
import domain.contract.entity.Contract;
import domain.customer.dto.AcceptanceReviewRequest;
import domain.employee.dto.*;
import domain.employee.entity.Employee;
import domain.employee.exception.excution.*;
import domain.employee.service.*;
import domain.insurance.entity.InsuranceCondition;
import global.dao.Lecture;
import global.util.EmployeeComment;

import java.util.ArrayList;

public class EmployeeController {

    private EmployeeService employeeService;
    private SalesEmployeeService salesEmployeeService;
    private SalesEduEmployeeService salesEduEmployeeService;
    private ContractGuideEmployeeService contractGuideEmployeeService;
    private AcceptanceReviewEmployeeService acceptanceReviewEmployeeService;
    private ContractManageEmployeeService contractManageEmployeeService;
    private InsuranceDevelopmentEmployeeService insuranceDevelopmentEmployeeService;
    private CustomerInformationManageService customerInformationManageService;
    private IncidentManageService incidentManageService;
    private RewardManageService rewardManageService;

    private EmployeeComment employeeComment;


    public EmployeeController() {
        this.employeeComment = new EmployeeComment();
        this.employeeService = new EmployeeService();
        this.salesEmployeeService = new SalesEmployeeService();
        this.salesEduEmployeeService = new SalesEduEmployeeService();
        this.contractGuideEmployeeService = new ContractGuideEmployeeService();
        this.acceptanceReviewEmployeeService = new AcceptanceReviewEmployeeService();
        this.contractManageEmployeeService = new ContractManageEmployeeService();
        this.insuranceDevelopmentEmployeeService = new InsuranceDevelopmentEmployeeService();
        this.customerInformationManageService = new CustomerInformationManageService();
        this.incidentManageService = new IncidentManageService();
        this.rewardManageService = new RewardManageService();
    }

    public void initial() {
        while (true){
            Employee employee = login();
            if(employee != null){
                home(employee);
            }
            break;
        }

    }

    private Employee login() {
        return employeeService.login(employeeComment.getId(),employeeComment.getPassword());
    }

    private Employee home(Employee employee){
        while(true){
            switch (this.employeeComment.home()){
                case 11:
                    //상담 대기 신규 고객 명단 조회
                    if (employee.getDepartmentId().equals("DP1")){
                        ArrayList<EmpCustomer> arrayList = salesEmployeeService.customerConsult(employee);
                        if (!arrayList.isEmpty()){
                            System.out.println("상담 진행");
                            salesEmployeeService.consultExecute(employee,
                                    arrayList.get(employeeComment.customerConsultList(arrayList)));
                            System.out.println("상담 완료");
                        }else{
                            new NoConsultCustomerException();
                        }
                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 12:
                    //영업 교육 수강
                    if (employee.getDepartmentId().equals("DP1")){

                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 21:
                    if (employee.getDepartmentId().equals("DP4"))
                        uploadEducationLecture(employee);
                    else
                        new NoAuthorityDPException();
                    break;
                //영업 교육 강의 업로드
                case 22:
                    //강의 자료 리스트 출력
                    if (employee.getDepartmentId().equals("DP4")){
                        findLectureList();
                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 23:
                    //수강 명단 체크
                    if (employee.getDepartmentId().equals("DP4")){
                        findLectureRegistrationList();
                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 31:
                    //계약 보험 상태 안내 고객 명단 조회
                    /*
                    * 보험 가입자에게 보험 계약 상태(고객 만기 및 미납 여부)를 안내한다.
                    */
                    if (employee.getDepartmentId().equals("DP6")){
                        notifyContractStatus();
                    }else{
                        new NoAuthorityDPException();
                    }
                case 41:
                    //보험 만기 고객 조회
                    //건강정보 테이블에 고객 ID들어가야함
                    if (employee.getDepartmentId().equals("DP6")) {
                        employeeComment.contractExpriation(this.contractManageEmployeeService.selectContractExpiration());
                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 42:
                    //미납 고객 조회
                    if (employee.getDepartmentId().equals("DP6")) {
                        employeeComment.contractDefault(this.contractManageEmployeeService.selectDefaultCustomer());
                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 51:
                    //인수심사 수행
                    if (employee.getDepartmentId().equals("DP2")) {
                        startAcceptanceReview();
                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 61:
                    if (employee.getDepartmentId().equals("DP3")) developInsurance();
                    else new NoAuthorityDPException();
                    break;
                case 71:
                    //고객 정보를 제공
                    if (employee.getDepartmentId().equals("DP7")){
                        this.provideCustomerInformation();
                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 81:
                    //보험 시장 데이터 제공
                    if (employee.getDepartmentId().equals("DP8")) {
                        this.provideMarketInformation();
                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 91:
                    //손해접수팀
                    //사고 발생 신고를 접수받는다.
                    if (employee.getDepartmentId().equals("DP9")) {
                        ArrayList<IncidentResponse> incidentResponses = this.incidentManageService.IncidentAccept(employee);
                        if(!incidentResponses.isEmpty()){
                            this.incidentManageService.incidentAssign(employee,
                                    incidentResponses.get(this.employeeComment.incidentChoice(incidentResponses)));
                            System.out.println("담당자 설정이 완료되었습니다.");
                        }else{
                            new NoIncidentException();
                        }

                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 101:
                    //보상평가팀
                    //보상금을 심사하다.
                    if (employee.getDepartmentId().equals("DP10")) {
                        ArrayList<RewardEvaluteResponse> rewardEvaluteResponses = this.rewardManageService.rewardEvaluate();
                        if(!rewardEvaluteResponses.isEmpty()){
                            this.rewardManageService.rewardAssign(this.employeeComment.rewardChoice(rewardEvaluteResponses));
                        }else{
                            new NoRewardException();
                        }

                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 0:
                    //로그아웃
                    return null;
                default:
                    new CheckMenuNumberException();
                    break;
            }
        }
    }



    private void startAcceptanceReview() {
        System.out.println("인수 심사 대상 고객 명단을 불러오시겠습니까?");
        switch(employeeComment.yesOrNo()){
            case 1:
                getAcceptanceReviewCustomerList();
                break;
            case 2:
                break;
        }
    }

    private void getAcceptanceReviewCustomerList() {
        ArrayList<AcceptanceReviewRequest> AcceptanceReviewRequests = acceptanceReviewEmployeeService.getAcceptanceReviewCustomerList();
        for (AcceptanceReviewRequest acceptanceReviewCustomer : AcceptanceReviewRequests)
            System.out.println(acceptanceReviewCustomer);
        String customerId = employeeComment.getCustomerId();
        AcceptanceReviewRequest acceptanceReviewRequest =
                AcceptanceReviewRequests.stream()
                        .filter((aar) -> aar.getCustomerId().equals(customerId))
                        .findFirst()
                        .orElseThrow(NoEmployeeException::new);

        acceptanceReviewEmployeeService.getAcceptanceReviewDetail(acceptanceReviewRequest);
    }

    private void notifyContractStatus() {
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
        System.out.println("-----계약 기간 만료 임박 고객 리스트-----");
        for (Contract contract : nearExpireContractList) System.out.println(contract);
        System.out.println("----------------------------------");
        System.out.println("해당 고객들에게 계약 기간 만료 임박 이메일을 보내시겠습니까?");
        if(employeeComment.yesOrNo() == 1) contractGuideEmployeeService.sendEmailNearExpireContract(nearExpireContractList);
    }

    private void getNearPaymentContractList() {
        ArrayList<Contract> nearPaymentContractList = contractGuideEmployeeService.getNearPaymentContractList();
        System.out.println("-----납부일 만료 임박 고객 리스트-----");
        for (Contract contract : nearPaymentContractList) System.out.println(contract);
        System.out.println("----------------------------------");
        System.out.println("해당 고객들에게 계약 기간 만료 임박 이메일을 보내시겠습니까?");
        if(employeeComment.yesOrNo() == 1) contractGuideEmployeeService.sendNearPaymentContract(nearPaymentContractList);
    }

    private void findLectureList() {
        ArrayList<Lecture> lectureList = salesEduEmployeeService.findLectureList();
        for (Lecture lecture : lectureList) {
            System.out.println(lecture);
        }
    }

    public void uploadEducationLecture(Employee lecturer){
        String lectureName = employeeComment.getText("강의 이름을 입력하세요:");//TODO choice comment로 옮기기
        String lecturePdfName = employeeComment.getText("강의 자료를 이름을 입력하세요.");
        String lectureId = lectureName.length() + lecturer.getEmployeeId();
        Lecture lecture = new Lecture(lectureId, lectureName, lecturePdfName, lecturer.getEmployeeId());
        if(salesEduEmployeeService.uploadEducationLecture(lecture)) System.out.println("강의 등록에 성공했습니다.");
        else System.out.println("강의 등록에 실패했습니다.");
    }

    //TODO
    public void findLectureRegistrationList(){
    }

    private void developInsurance() {
        ArrayList<CustomerAnalysisInformation> customerAnalysisInformations = provideCustomerInformation();
        MarketInsuranceInformationResponse marketInsuranceInformationResponse = provideMarketInformation();
        System.out.println("-------------고객 분석 데이터--------------");
        for (CustomerAnalysisInformation customerAnalysisInformation : customerAnalysisInformations)
            System.out.println(customerAnalysisInformation);
        System.out.println("---------------------------------------");
        System.out.println("-------------시장 분석 데이터--------------");
        System.out.println(marketInsuranceInformationResponse);
        System.out.println("---------------------------------------");
        String insuranceName = employeeComment.getInsuranceName();
        int kindOfInsurance = employeeComment.getKindOfInsurance();
        int insuranceFee = employeeComment.getInsuranceFee();
        int maxAge = employeeComment.getMaxAge();
        int minAge = employeeComment.getMinAge();
        System.out.println("---보험 가입 조건 설정하기(입력하신 Grade 이상이 되어야 보험이 가능합니다.)---");
        String smoke = employeeComment.getSmoke();
        String alcohol = employeeComment.getAlcohol();
        String cancer = employeeComment.getCancer();
        InsuranceCondition insuranceCondition = new InsuranceCondition(maxAge,minAge,smoke,alcohol,cancer);
        NewInsurance newInsurance = new NewInsurance(insuranceName, kindOfInsurance, insuranceFee, insuranceCondition);
        if(insuranceDevelopmentEmployeeService.developInsurance(newInsurance))
            System.out.println("보험 등록이 성공적으로 완료되었습니다.");
    }

    public ArrayList<CustomerAnalysisInformation> provideCustomerInformation(){
        return customerInformationManageService.provideCustomerInformation();
    }

    public MarketInsuranceInformationResponse provideMarketInformation(){
        return new MarketInsuranceInformationResponse();
    }

    public void doInsuranceContract(Contract contract){
        salesEmployeeService.doInsuranceContract(contract);
    }

    //TODO
    public void doContractExpiration(){

    }
}
