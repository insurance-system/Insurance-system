package domain.employee.service;

import global.dao.Lecture;

import java.util.ArrayList;

public class SalesEduEmployeeService extends EmployeeService{

    public boolean uploadEducationLecture(Lecture lecturer) {
        return employeeRepository.insertLecture(lecturer);
    }

    public ArrayList<Lecture> findLectureList(){
        return employeeRepository.selectLectureList();
    }

}
