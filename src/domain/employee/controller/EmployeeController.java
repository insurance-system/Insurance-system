package domain.employee.controller;

import domain.customer.entity.Payer;
import domain.employee.dto.CustomerConsultResponse;
import domain.employee.entity.Employee;
import domain.employee.exception.excution.CheckMenuNumberException;
import domain.employee.exception.excution.NoAuthorityDPException;
import domain.employee.service.EmployeeService;
import global.dao.Lecture;
import global.util.Choice;
import global.util.EmployeeComment;

import java.util.ArrayList;

public class EmployeeController {

    private EmployeeService employeeService;
    private Choice choice;
    private EmployeeComment employeeComment;


    public EmployeeController(Choice choice) {
        this.choice = choice;
        this.employeeComment = new EmployeeComment();
        this.employeeService = new EmployeeService();
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
                        ArrayList<CustomerConsultResponse> arrayList = employeeService.customerConsult(employee);
                        if (!arrayList.isEmpty()){
                            System.out.println("상담 진행");
                            employeeService.consultExcute(employee,
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
                    //보험 정보 안내 고객 명단 조회
                    /*
                    * 보험 가입자에게 보험 계약 상태(고객 만기 및 미납 여부)를 안내한다.
                    */
                    if (employee.getDepartmentId().equals("DP6")) {
                        notifyContractStatus();
                    }else{
                        new NoAuthorityDPException();
                    }
                case 41:
                    //보험 계약 관리
                    if (employee.getDepartmentId().equals("DP6")) {

                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 42:
                    //미납 고객 조회
                    if (employee.getDepartmentId().equals("DP6")) {

                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 51:
                    //인수심사 수행
                    if (employee.getDepartmentId().equals("DP2")) {

                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 61://TODO KEEP
                    //보험 설계 시작
                    if (employee.getDepartmentId().equals("DP3")) {

                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 71:
                    //고객 정보를 제공
                    if (employee.getDepartmentId().equals("DP7")) {

                    }else{
                        new NoAuthorityDPException();
                    }
                    break;
                case 81:
                    //보험 시장 데이터 제공
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

    private void notifyContractStatus() {
        ArrayList<Payer> nearExpiredPayerList = employeeService.getNearExpiredPayerList();
        ArrayList<Payer> nearPaydayPayerList = employeeService.getNearPaymentDayPayerList();
        if(nearExpiredPayerList.size() <= 0 || nearPaydayPayerList.size() <= 0)
            System.out.println("계약기간 혹은 만료일이 임박한 Contract를 가진 Payer가 아직 존재하지 않습니다.");
        else{
            for (Payer payer : nearExpiredPayerList) System.out.println(payer + " 에게 계약 기간만료 임박 이메일을 전송했습니다.");
            for (Payer payer : nearPaydayPayerList) System.out.println(payer + " 에게 납부 날짜 임박 이메일을 전송했습니다.");
        }
    }
    

    private void findLectureList() {
        ArrayList<Lecture> lectureList = employeeService.findLectureList();
        for (Lecture lecture : lectureList) {
            System.out.println(lecture);
        }
    }

    public void uploadEducationLecture(Employee lecturer){
        String lectureName = choice.getText("강의 이름을 입력하세요:");
        String lecturePdfName = choice.getText("강의 자료를 이름을 입력하세요.");
        String lectureId = lectureName.length() + lecturer.getEmployeeId();
        Lecture lecture = new Lecture(lectureId, lectureName, lecturePdfName, lecturer.getEmployeeId());
        if(employeeService.uploadEducationLecture(lecture)) System.out.println("강의 등록에 성공했습니다.");
        else System.out.println("강의 등록에 실패했습니다.");
    }

    public void findLectureRegistrationList(){

    }
}
