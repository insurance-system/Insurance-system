package domain.employee.controller;

import domain.employee.entity.Employee;
import domain.employee.exception.excution.CheckMenuNumberException;
import domain.employee.exception.excution.NoAuthorityDPException;
import domain.employee.service.EmployeeService;
import global.util.Choice;
import global.util.EmployeeComment;

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
                    if (employee.getDepartmentId() == "DP1") {

                    }else{
                        new NoAuthorityDPException();
                    }
                case 12:
                    //영업 교육 수강
                    if (employee.getDepartmentId() == "DP1") {

                    }else{
                        new NoAuthorityDPException();
                    }
                case 21:
                    //영업 교육 강의 업로드
                    if (employee.getDepartmentId() == "DP4") {

                    }else{
                        new NoAuthorityDPException();
                    }
                case 22:
                    //수강 명단 체크
                    if (employee.getDepartmentId() == "DP4") {

                    }else{
                        new NoAuthorityDPException();
                    }
                case 31:
                    //보험 정보 안내 고객 명단 조회
                    if (employee.getDepartmentId() == "DP6") {

                    }else{
                        new NoAuthorityDPException();
                    }
                case 41:
                    //보험 계약 관리
                    if (employee.getDepartmentId() == "DP5") {

                    }else{
                        new NoAuthorityDPException();
                    }
                case 42:
                    //미납 고객 조회
                    if (employee.getDepartmentId() == "DP5") {

                    }else{
                        new NoAuthorityDPException();
                    }
                case 51:
                    //인수심사 수행
                    if (employee.getDepartmentId() == "DP2") {

                    }else{
                        new NoAuthorityDPException();
                    }
                case 61:
                    //보험 설계 시작
                    if (employee.getDepartmentId() == "DP3") {

                    }else{
                        new NoAuthorityDPException();
                    }
                case 71:
                    //고객 정보를 제공
                    if (employee.getDepartmentId() == "DP7") {

                    }else{
                        new NoAuthorityDPException();
                    }
                case 81:
                    //보험 시장 데이터 제공
                    if (employee.getDepartmentId() == "DP8") {

                    }else{
                        new NoAuthorityDPException();
                    }
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
}
