package domain.employee.controller;

import domain.customer.entity.Customer;
import domain.employee.dto.CustomerAnalysisInformation;
import domain.employee.dto.EmpCustomer;
import domain.contract.entity.Contract;
import domain.customer.dto.AcceptanceReviewRequest;
import domain.employee.dto.MarketInsuranceInformationResponse;
import domain.employee.entity.Employee;
import domain.employee.exception.excution.CheckMenuNumberException;
import domain.employee.exception.excution.NoAuthorityDPException;
import domain.employee.exception.excution.NoEmployeeException;
import domain.employee.service.*;
import global.dao.Lecture;
import global.util.Choice;
import global.util.EmployeeComment;

import javax.swing.undo.CannotUndoException;
import java.util.ArrayList;

public class EmployeeController {

    private EmployeeService employeeService;
    private SalesEmployeeService salesEmployeeService;
    private SalesEduEmployeeService salesEduEmployeeService;
    private ContractGuideEmployeeService contractGuideEmployeeService;
    private AcceptanceReviewEmployeeService acceptanceReviewEmployeeService;
    private ContractManageEmployeeService contractManageEmployeeService;
    private InsuranceDevelopmentEmployeeService insuranceDevelopmentEmployeeService;

    private Choice choice;
    private EmployeeComment employeeComment;


    public EmployeeController(Choice choice) {
        this.choice = choice;
        this.employeeComment = new EmployeeComment();
        this.employeeService = new EmployeeService();
        this.salesEmployeeService = new SalesEmployeeService();
        this.salesEduEmployeeService = new SalesEduEmployeeService();
        this.contractGuideEmployeeService = new ContractGuideEmployeeService();
        this.acceptanceReviewEmployeeService = new AcceptanceReviewEmployeeService();
        this.contractManageEmployeeService = new ContractManageEmployeeService();
        this.insuranceDevelopmentEmployeeService = new InsuranceDevelopmentEmployeeService();
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
        return employeeService.login(choice.getId(),choice.getPassword());
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
                        }
                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 12:
                    //영업 교육 수강
                    if (employee.getDepartmentId().equals("DP1")) {

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
                    if (employee.getDepartmentId().equals("DP4")) {
                        findLectureList();
                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 23:
                    //수강 명단 체크
                    if (employee.getDepartmentId().equals("DP4")) {
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
                case 61://TODO KEEP
                    //보험 설계 시작
                    //생명보험, 화재보험
                    //설계를 위한 데이터 요청 메서드 두개
                    /**
                     * 1개는 고객정보
                     * 1개는 시장 보험 정보
                     *
                     */
                    //
                    if (employee.getDepartmentId().equals("DP3")) {

                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 71:
                    //고객 정보를 제공
                    //삭제 예정
                    if (employee.getDepartmentId().equals("DP7")) {

                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 81:
                    //보험 시장 데이터 제공
                    //삭제 예정
                    if (employee.getDepartmentId().equals("DP8")) {

                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 0:
                    //로그아웃
                    return null;
                default:
                    new CheckMenuNumberException();
//                    break;
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
        String lectureName = choice.getText("강의 이름을 입력하세요:");
        String lecturePdfName = choice.getText("강의 자료를 이름을 입력하세요.");
        String lectureId = lectureName.length() + lecturer.getEmployeeId();
        Lecture lecture = new Lecture(lectureId, lectureName, lecturePdfName, lecturer.getEmployeeId());
        if(salesEduEmployeeService.uploadEducationLecture(lecture)) System.out.println("강의 등록에 성공했습니다.");
        else System.out.println("강의 등록에 실패했습니다.");
    }

    //TODO
    public void findLectureRegistrationList(){

    }

    public ArrayList<CustomerAnalysisInformation> provideCustomerInformation(){

        return null;
    }

    public MarketInsuranceInformationResponse provideMarketInformation(){

        return null;
    }
}
