package domain.employee.service;

import domain.contract.dto.InsuranceNearExpireAlarm;
import domain.contract.entity.Contract;
import domain.employee.repository.EmployeeRepository;
import domain.insurance.entity.Insurance;
import global.dao.Lecture;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;

import static global.util.makeForm.sendExpireAlarmEmail;

public class SalesEduEmployeeService extends EmployeeService{

    public boolean uploadEducationLecture(Lecture lecturer) {
        return employeeRepository.insertLecture(lecturer);
    }



    public ArrayList<Lecture> findLectureList(){
        return employeeRepository.selectLectureList();
    }

}
