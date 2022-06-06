package domain.employee.service;

import domain.employee.dto.Lecture;

import java.util.ArrayList;

public class SalesEduEmployeeService extends EmployeeService{

    public boolean uploadEducationLecture(Lecture lecturer) {
        return employeeRepository.insertLecture(lecturer);
    }

    public ArrayList<Lecture> findLectureList(){
        return employeeRepository.selectLectureList();
    }

}
