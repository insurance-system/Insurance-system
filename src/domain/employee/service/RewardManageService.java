package domain.employee.service;

import domain.employee.dto.RewardEvaluteResponse;
import domain.employee.entity.Employee;

import java.util.ArrayList;

public class RewardManageService extends EmployeeService{

    public ArrayList<RewardEvaluteResponse> rewardEvaluate() {
        return this.employeeRepository.rewardEvaluate();
    }

    public void rewardAssign(RewardEvaluteResponse rewardChoice) {
        this.employeeRepository.rewardAssign(rewardChoice);
    }
}
