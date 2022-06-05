package domain.employee.service;

import domain.employee.dto.RewardEvaluateResponse;

import java.util.ArrayList;

public class RewardManageService extends EmployeeService{

    public ArrayList<RewardEvaluateResponse> rewardEvaluate() {
        return this.employeeRepository.rewardEvaluate();
    }

    public void rewardAssign(RewardEvaluateResponse rewardChoice) {
        this.employeeRepository.rewardAssign(rewardChoice);
    }
}
