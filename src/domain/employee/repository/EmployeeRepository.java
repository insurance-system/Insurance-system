package domain.employee.repository;

import domain.contract.dto.NewInsurance;
import domain.contract.entity.Contract;
import domain.customer.dto.UwCustomer;
import domain.customer.dto.UwRequest;
import domain.customer.dto.UwResponse;
import domain.customer.entity.Grade;
import domain.customer.entity.HealthInformation;
import domain.customer.enumeration.KindOfJob;
import domain.employee.dto.*;
import domain.employee.entity.Employee;
import domain.employee.exception.excution.NoEmployeeException;
import domain.insurance.dto.UwInsurance;
import domain.insurance.entity.Insurance;
import domain.insurance.entity.InsuranceCondition;
import domain.insurance.entity.enumeration.InsuranceStatus;
import domain.insurance.entity.enumeration.KindOfInsurance;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static global.util.constants.DataBaseConstants.*;

public class EmployeeRepository {

    private Connection connection;

    public EmployeeRepository() {
        this.connection = this.sqlConnection();
    }

    private Connection sqlConnection(){
        try {
            Class.forName(DB_DRIVER);
            Connection conn = null;
            conn = DriverManager.getConnection(
                    URL,
                    USER,
                    PW);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Employee login(String employeeId, String password) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * from Employee where employeeId = ? and password = ?";
            PreparedStatement st = this.connection.prepareStatement(sql);

            st.setString(1, employeeId);
            st.setString(2, password);
            rs = st.executeQuery();
            if (rs.next()){
                Employee employee = new Employee(
                        rs.getString("employeeId"),
                        rs.getString("password"),
                        rs.getString("departmentId"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getString("address"),
                        rs.getString("detailAddress"),
                        rs.getString("zipCode")
                );
                System.out.println(employee.getEmployeeId());
                return employee;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        new NoEmployeeException();
        return null;
    }

    public ArrayList<EmpCustomer> customerConsult(Employee employee) {
        ResultSet rs = null;
        try {
            String sql = "Select Emp_Cus.emp_CusId, Customer.customerId, Customer.name, Customer.phoneNumber, Customer.kindOfInsurance, Customer.kindOfJob" +
                    " from Emp_Cus, Customer " +
                    "where Customer.customerId = Emp_Cus.customerId and Emp_Cus.satisfaction is null and Emp_Cus.EmployeeId is null;";
            PreparedStatement st = this.connection.prepareStatement(sql);

            rs = st.executeQuery();

            ArrayList<EmpCustomer> customerList = new ArrayList<>();
            while (rs.next()){
                EmpCustomer customerConsultResponse = new EmpCustomer();
                customerConsultResponse.setEmpCusId(rs.getString("emp_CusId"));
                customerConsultResponse.setCustomerId(rs.getString("customerId"));
                customerConsultResponse.setName(rs.getString("name"));
                customerConsultResponse.setPhoneNumber(rs.getString("phoneNumber"));
                customerConsultResponse.setKindOfInsurance(KindOfInsurance.getKindOfInsuranceBy(rs.getString("kindOfInsurance")));
                customerConsultResponse.setKindOfJob(KindOfJob.getKindOfJobBy(rs.getString("kindOfJob")));
                customerList.add(customerConsultResponse);
            }

                return customerList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean insertLecture(Lecture lecturer) {
        Statement statement = null;
        ResultSet rs = null;
        try{
            String sql = "insert into Lecture (" +
                    "lectureId," +
                    "lectureName," +
                    "lecturePdfName," +
                    "lecturerId)" +
                    "values (?,?,?,?);";

            PreparedStatement st = connection.prepareStatement(sql);//?????? ????????? ??????

            st.setString(1, lecturer.getLectureId());
            st.setString(2, lecturer.getLectureName());
            st.setString(3, lecturer.getLecturePdfName());
            st.setString(4, lecturer.getLecturerId());
            st.executeUpdate();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Lecture> selectLectureList() {
        ArrayList<Lecture> lectureList = new ArrayList<>();
        String sql = "select * from Lecture;";
        try {
            PreparedStatement st = this.connection.prepareStatement(sql);
            ResultSet rs = null;
            rs = st.executeQuery();

            while (rs.next()) {
                Lecture lecture = new Lecture();
                lecture.setLectureId(rs.getString("lectureId"));
                lecture.setLectureName(rs.getString("lectureName"));
                lecture.setLecturePdfName(rs.getString("lecturePdfName"));
                lecture.setLecturerId(rs.getString("lecturerId"));
                lectureList.add(lecture);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lectureList;
    }

    public ArrayList<Contract> selectContractList() {
        ArrayList<Contract> contractList = new ArrayList<>();
        String sql = "select * from Contract;";
        try {
            PreparedStatement st = this.connection.prepareStatement(sql);
            ResultSet rs = null;
            rs = st.executeQuery();

            while (rs.next()) {
                Contract contract = new Contract();
                contract.setContractId(rs.getString("contractId"));
                contract.setCustomerId(rs.getString("customerId"));
                contract.setInsuranceId(rs.getString("insuranceId"));
                contract.setExpiredDate(LocalDate.parse(rs.getString("expiredDate"), DateTimeFormatter.ISO_DATE));
                contract.setPaymentDate(LocalDate.parse(rs.getString("paymentDate"), DateTimeFormatter.ISO_DATE));
                contract.setContractStatus(rs.getString("contractStatus"));
                contractList.add(contract);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return contractList;
    }

    public void executeConsult(Employee employee, EmpCustomer customerConsultResponse){
        try {
            String sql = "UPDATE Emp_Cus SET employeeId = ? WHERE emp_CusId=?";
            PreparedStatement st = this.connection.prepareStatement(sql);
            st.setString(1, employee.getEmployeeId());
            st.setString(2, customerConsultResponse.getEmpCusId());
            st.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<domain.customer.entity.Customer> selectEmployeeByIds(ArrayList<String> nearExpiredContractsCustomerIds){
        ArrayList<domain.customer.entity.Customer> customerList = new ArrayList<>();
        String args = "";
        for (String nearExpiredContractsCustomerId : nearExpiredContractsCustomerIds) {
            args += "'"+nearExpiredContractsCustomerId+"',";
        }
        args = args.substring(0, args.length()-1);

        String sql = "select * from Customer where customerId in ("+args +");";
        System.out.println("sql = " + sql);
        try {
            PreparedStatement st = this.connection.prepareStatement(sql);
            ResultSet rs = null;
            rs = st.executeQuery();

            while (rs.next()) {
                domain.customer.entity.Customer customer = new domain.customer.entity.Customer();
                customer.setCustomerId(rs.getString("customerId"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customerList.add(customer);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }

    public ArrayList<ExpirationResponse> contractManage() {
        ResultSet rs = null;
        try {
            String sql =
                    "select c.customerId, c.name, c.phoneNumber, c.email, c.kindOfJob, c.kindOfInsurance, i.insuranceName, i.insuranceStatus, contractStatus " +
                    " From Customer c, Contract, Insurance i " +
                    "where c.customerId = Contract.customerId" +
                    "  and Contract.insuranceId = i.insuranceId" +
                    "  and contractStatus = 'expiration' ";
            PreparedStatement st = this.connection.prepareStatement(sql);

            rs = st.executeQuery();

            ArrayList<ExpirationResponse> expirationResponses = new ArrayList<>();
            while (rs.next()){
                ExpirationResponse expirationResponse = new ExpirationResponse(
                        rs.getString("customerId"),
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        KindOfJob.getKindOfJobBy(rs.getString("kindOfJob")),
                        KindOfInsurance.getKindOfInsuranceBy(rs.getString("kindOfInsurance")),
                        rs.getString("insuranceName"),
                        rs.getString("insuranceStatus"),
                        "??????"
                );
                expirationResponses.add(expirationResponse);
            }

            return expirationResponses;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<DefaultResponse> selectDefaultCustomer() {
        ResultSet rs = null;
        try {
            String sql = "select c.customerId, c.name, c.phoneNumber, address, detailAddress, zipCode, insuranceName, contractStatus " +
                    " FROM Customer c, Contract, Insurance " +
                    " WHERE c.customerId = Contract.customerId and Contract.insuranceId = Insurance.insuranceId " +
                    "  and contractStatus = 'default'";
            PreparedStatement st = this.connection.prepareStatement(sql);

            rs = st.executeQuery();

            ArrayList<DefaultResponse> defaultResponses = new ArrayList<>();
            while (rs.next()){
                DefaultResponse defaultResponse = new DefaultResponse(
                        rs.getString("customerId"),
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("address"),
                        rs.getString("detailAddress"),
                        rs.getString("zipCode"),
                        rs.getString("insuranceName"),
                        "??????"
                );
                defaultResponses.add(defaultResponse);
            }

            return defaultResponses;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public ArrayList<domain.customer.entity.Customer> selectCustomerByIds(ArrayList<String> customerIds) {
        ArrayList<domain.customer.entity.Customer> customerList = new ArrayList<>();
        String args = "";
        for (String customerId : customerIds) {
            args += "'"+customerId+"',";
        }
        args = args.substring(0, args.length()-1);

        String sql = "select * from Customer where customerId in ("+args +");";
        System.out.println("sql = " + sql);
        try {
            PreparedStatement st = this.connection.prepareStatement(sql);
            ResultSet rs = null;
            rs = st.executeQuery();

            while (rs.next()) {
                domain.customer.entity.Customer customer = new domain.customer.entity.Customer();
                customer.setCustomerId(rs.getString("customerId"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customerList.add(customer);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }

    public ArrayList<Insurance> selectInsuranceByIds(ArrayList<String> insuranceIds) {
        ArrayList<Insurance> insuranceList = new ArrayList<>();
        String args = "";
        for (String insuranceId : insuranceIds) {
            args += "'"+insuranceId+"',";
        }
        args = args.substring(0, args.length()-1);

        String sql = "select * from Insurance where insuranceId in ("+args +");";
        System.out.println("sql = " + sql);
        try {
            PreparedStatement st = this.connection.prepareStatement(sql);
            ResultSet rs = null;
            rs = st.executeQuery();

            while (rs.next()){
                Insurance insurance = new Insurance();
                insurance.setInsuranceId(rs.getString("insuranceId"));
                insurance.setInsuranceName(rs.getString("insuranceName"));
                insurance.setFee(rs.getInt("fee"));
                insuranceList.add(insurance);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return insuranceList;
    }

    public ArrayList<UwRequest> getUwCustomerList() {
        ArrayList<UwRequest> uwRequestLists = new ArrayList<>();

        String sql = "select contractId, Contract.customerId, Customer.name ,expiredDate, contractStatus, paymentDate " +
                "from Contract, Customer " +
                "where Contract.customerId = Customer.customerId and " +
                "      contractStatus is null;";
        try {
            PreparedStatement st = this.connection.prepareStatement(sql);
            ResultSet rs = null;
            rs = st.executeQuery();

            while (rs.next()){
                UwRequest uwRequest = new UwRequest();
                uwRequest.setContractId(rs.getString("contractId"));
                uwRequest.setCustomerId(rs.getString("customerId"));
                uwRequest.setCustomerName(rs.getString("name"));
                uwRequest.setExpiredDate(rs.getString("expiredDate"));
                uwRequest.setContractStatus(rs.getString("contractStatus"));
                uwRequest.setPaymentDate(rs.getString("paymentDate"));
                uwRequestLists.add(uwRequest);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return uwRequestLists;
    }

    public UwCustomer getAcceptanceReviewCustomerById(String customerId){
        ResultSet rs = null;
        UwCustomer uwCustomer = new UwCustomer();
        try{
            String sql = "select C.customerId, C.name, C.email, C.address, C.detailAddress, C.zipcode, C.phoneNumber, C.kindOfJob, " +
                    " H.cancer, H.smoke, H.alchohol, " +
                    " C.creditGrade " +
                    " from Customer C, HealthInformation H, CreditInformation C " +
                    " where C.customerId = ? and C.healthInformationId = H.healthInformationId and C.creditInformationId = C.creditInformationId;";

            PreparedStatement st = connection.prepareStatement(sql);//?????? ????????? ??????

            st.setString(1, customerId);
            rs = st.executeQuery();
            uwCustomer.setCustomerId(rs.getString(customerId));
            uwCustomer.setName(rs.getString("name"));
            uwCustomer.setEmail(rs.getString("email"));
            uwCustomer.setAddress(rs.getString("address"));
            uwCustomer.setDetailAddress(rs.getString("detailAddress"));
            uwCustomer.setZipcode(rs.getString("zipcode"));
            uwCustomer.setPhoneNumber(rs.getString("phoneNumber"));
            uwCustomer.setKindOfJob(KindOfJob.getKindOfJobBy(rs.getString("kindOfJob")));
            uwCustomer.setCancer(rs.getString("cancer"));
            uwCustomer.setSmoke(rs.getString("smoke"));
            uwCustomer.setAlcohol(rs.getString("alchohol"));
            uwCustomer.setCreditGrade(rs.getString("creditGrade"));
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return uwCustomer;
    }

    public UwInsurance getUwInsuranceById(String requestInsuranceId) {
        ResultSet rs = null;
        UwInsurance uwInsurance = new UwInsurance();
        try{
            String sql = "select I.insuranceId, I.insuranceName, I.fee, C.maxAge, C.minAge, C.smoke, C.alchohol, C.cancer, " +
                    " from Insurance I, Insurance_Condition C, " +
                    " where I.insuranceId = ? and I.insurnaceConditionId = C.insurnace_ConditionId;";

            PreparedStatement st = connection.prepareStatement(sql);//?????? ????????? ??????

            st.setString(1, requestInsuranceId);
            rs = st.executeQuery();
            uwInsurance.setInsuranceId(rs.getString("insuranceId"));
            uwInsurance.setInsuranceName(rs.getString("insuranceName"));
            uwInsurance.setFee(rs.getInt("fee"));
            uwInsurance.setKindOfInsurance(KindOfInsurance.getKindOfInsuranceBy(rs.getString("kindOfInsurance")));
            uwInsurance.setMaxAge(rs.getInt("maxAge"));
            uwInsurance.setMinAge(rs.getInt("minAge"));
            uwInsurance.setSmoke(Grade.getGrade(rs.getString("smoke")));
            uwInsurance.setCancer(Grade.getGrade(rs.getString("cancer")));
            uwInsurance.setAlcohol(Grade.getGrade(rs.getString("alcohol")));
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return uwInsurance;
    }

    public void insertNewInsurance(NewInsurance newInsurance){
        int insuranceConditionId = insertInsuranceCondition(newInsurance.getInsuranceCondition());
        int insuranceId = getLastInsuranceId();
        insuranceId+=1;

        try{
            String sql = "insert into Insurance (" +
                    "insuranceId," +
                    "insuranceConditionId," +
                    "insuranceName," +
                    "fee," +
                    "kindOfInsurance," +
                    "insuranceStatus)" +
                    "values (?,?,?,?,?,?);";

            PreparedStatement st = connection.prepareStatement(sql);//?????? ????????? ??????

            st.setInt(1, insuranceId);
            st.setInt(2, insuranceConditionId);
            st.setString(3, newInsurance.getInsuranceName());
            st.setInt(4, newInsurance.getFee());
            st.setString(5, newInsurance.getKindOfInsurance().getName());
            st.setString(6, InsuranceStatus.UNDER_EXAMINATION.getName());

            int result = st.executeUpdate();

            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int insertInsuranceCondition(InsuranceCondition insuranceCondition){
        int insuranceConditionId = getLastInsuranceConditionId();
        insuranceConditionId += 1;
        try{
            String sql = "insert into Insurance_Condition (" +
                    "insuranceConditionId," +
                    "maxAge," +
                    "minAge," +
                    "smoke," +
                    "alcohol," +
                    "cancer)" +
                    "values (?,?,?,?,?,?);";

            PreparedStatement st = connection.prepareStatement(sql);//?????? ????????? ??????

            st.setInt(1, insuranceConditionId);
            st.setInt(2, insuranceCondition.getMaxAge());
            st.setInt(3, insuranceCondition.getMinAge());
            st.setString(4, insuranceCondition.getSmoke());
            st.setString(5, insuranceCondition.getAlcohol());
            st.setString(6, insuranceCondition.getCancer());
            int result = st.executeUpdate();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return insuranceConditionId;
    }

    public int getLastInsuranceId() {
        ResultSet rs = null;
        int insuranceId = 0;
        try{
            String sql = "SELECT insuranceId FROM Insurance ORDER BY insuranceId DESC LIMIT 1;";

            PreparedStatement st = connection.prepareStatement(sql);//?????? ????????? ??????
            rs = st.executeQuery();
            if(rs.next()) insuranceId = rs.getInt("insuranceId");
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return insuranceId;
    }

    public int getLastInsuranceConditionId() {
        ResultSet rs = null;
        int insuranceConditionId = 0;
        try{
            String sql = "SELECT insuranceConditionId FROM Insurance_Condition ORDER BY insuranceConditionId DESC LIMIT 1;";

            PreparedStatement st = connection.prepareStatement(sql);//?????? ????????? ??????
            rs = st.executeQuery();
            if(rs.next()) insuranceConditionId = rs.getInt("insuranceConditionId");
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return insuranceConditionId;
    }

    public ArrayList<CustomerAnalysisInformation> provideCustomerInformation() {
        ResultSet rs = null;
        try {
            String sql = "SELECT i.insuranceName, i.kindOfInsurance, avg(i.fee), count(*) " +
                    "FROM Insurance i " +
                    "group by i.kindOfInsurance";

            PreparedStatement st = this.connection.prepareStatement(sql);

            rs = st.executeQuery();

            ArrayList<CustomerAnalysisInformation> defaultResponses = new ArrayList<>();
            while (rs.next()){
                CustomerAnalysisInformation defaultResponse = new CustomerAnalysisInformation(
                        rs.getString("insuranceName"),
                        KindOfInsurance.getKindOfInsuranceBy(rs.getString("kindOfInsurance")),
                        rs.getString("avg(i.fee)"),
                        rs.getString("count(*)")
                );
                defaultResponses.add(defaultResponse);
            }
            return defaultResponses;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<IncidentResponse> IncidentAccept(Employee employee) {
        ResultSet rs = null;
        try {
            String sql = "SELECT incidentId, incidentName, incidentPhoneNum, incidentDate, incidentSite " +
                    "FROM Incident_handling " +
                    "WHERE employeeId IS null";

            PreparedStatement st = this.connection.prepareStatement(sql);

            rs = st.executeQuery();

            ArrayList<IncidentResponse> responseArrayList = new ArrayList<>();
            while (rs.next()){
                IncidentResponse incidentResponse = new IncidentResponse(
                        rs.getString("incidentId"),
                        rs.getString("incidentName"),
                        rs.getString("incidentPhoneNum"),
                        rs.getString("incidentDate"),
                        rs.getString("incidentSite")
                );
                responseArrayList.add(incidentResponse);
            }
            return responseArrayList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void incidentAssign(Employee employee, IncidentResponse incidentChoice) {
        try {
            String sql = "UPDATE Incident_handling SET employeeId = ? WHERE incidentId=?";
            PreparedStatement st = this.connection.prepareStatement(sql);
            st.setString(1, employee.getEmployeeId());
            st.setString(2, incidentChoice.getIncidentId());
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<RewardEvaluateResponse> rewardEvaluate() {
        ResultSet rs = null;
        try {
            String sql = "SELECT insuranceClaimId,customerId, claimContent, claimCost " +
                    "FROM InsuranceClaim " +
                    "WHERE claimStatus is null;";

            PreparedStatement st = this.connection.prepareStatement(sql);

            rs = st.executeQuery();

            ArrayList<RewardEvaluateResponse> responseArrayList = new ArrayList<>();
            while (rs.next()){
                RewardEvaluateResponse rewardEvaluateResponse = new RewardEvaluateResponse(
                        rs.getString("insuranceClaimId"),
                        rs.getString("customerId"),
                        rs.getString("claimContent"),
                        rs.getString("claimCost")
                );
                responseArrayList.add(rewardEvaluateResponse);
            }
            return responseArrayList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void rewardAssign(RewardEvaluateResponse rewardChoice) {
        try {
            String sql = "UPDATE InsuranceClaim SET claimStatus = ? WHERE insuranceClaimId=?;";
            PreparedStatement st = this.connection.prepareStatement(sql);
            st.setString(1, rewardChoice.getClaimStatus());
            st.setString(2, rewardChoice.getInsuranceClaimId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void makeInsuranceContract(Contract contract) {
        try {
            String sql = "INSERT INTO Contract (contractId, customerId, chargeOfEmployeeId, insuranceId, expiredDate, contractStatus, paymentDate, UWReview)" +
                    "        VALUE (?,?,?,?,?,?,?,?)";
            PreparedStatement st = this.connection.prepareStatement(sql);
            st.setString(1, contract.getContractId());
            st.setString(2, contract.getCustomerId());
            st.setString(3,contract.getChargeOfEmployeeId());
            st.setString(4,contract.getInsuranceId());
            st.setString(5,contract.getExpiredDate().toString());
            st.setString(6,contract.getContractStatus());
            st.setString(7,contract.getPaymentDate().toString());
            st.setString(8,null);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void expireContract(String insuranceId, String customerId) {
        try {
            String sql = "UPDATE Contract SET contractStatus = ? WHERE insuranceId=? AND custoerId=?;";
            PreparedStatement st = this.connection.prepareStatement(sql);
            st.setString(1, "expiration");
            st.setString(2, insuranceId);
            st.setString(3, customerId);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    String sql = "SELECT * from Employee where employeeId = ? and password = ?";
//    PreparedStatement st = this.connection.prepareStatement(sql);
//
//            st.setString(1, employeeId);
//            st.setString(2, password);
//            rs = st.executeQuery();
//            if (rs.next()){
//        Employee employee = new Employee(
//                rs.getString("employeeId"),
//                rs.getString("password"),
//                rs.getString("departmentId"),
//                rs.getString("name"),
//                rs.getString("email"),
//                rs.getString("phoneNumber"),
//                rs.getString("address"),
//                rs.getString("detailAddress"),
//                rs.getString("zipCode")
//        );
//        System.out.println(employee.getEmployeeId());
//        return employee;
//    }

    public UwResponse getUwInformation(String contractId) {
        UwResponse uwResponse = new UwResponse();
        HealthInformation healthInformation = new HealthInformation();
        try {
                String sql =
                        "select distinct contractId, customerId, Insurance.insuranceId, insuranceName, " +
                                "Insurance.fee, kindOfInsurance, Insurance_Condition.insuranceConditionId, " +
                                "maxAge, minAge, Insurance_Condition.smoke, Insurance_Condition.alcohol, Insurance_Condition.cancer, " +
                                "HealthInformation.smoke, HealthInformation.alcohol, HealthInformation.cancer " +
                                "from Contract, Insurance, Insurance_Condition, HealthInformation " +
                                "where contractId = ? " +
                                "and Contract.insuranceId = Insurance.insuranceId " +
                                "and Insurance.insuranceConditionId = Insurance_Condition.insuranceConditionId; ";
                PreparedStatement st = this.connection.prepareStatement(sql);
                st.setString(1, contractId);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    uwResponse.setContractId(rs.getString("contractId"));
                    uwResponse.setCustomerId(rs.getString("customerId"));
                    uwResponse.setInsuranceId(rs.getString("insuranceId"));
                    uwResponse.setInsuranceName(rs.getString("insuranceName"));
                    uwResponse.setFee(rs.getString("fee"));
                    uwResponse.setKindOfInsurance(KindOfInsurance.getKindOfInsuranceBy(rs.getString("kindOfInsurance")));
    //                rs.getString("insuranceConditionId");
                    healthInformation.setSmoke(Grade.getGrade(rs.getString("HealthInformation.smoke")));
                    healthInformation.setAlcohol(Grade.getGrade(rs.getString("HealthInformation.alcohol")));
                    healthInformation.setCancer(Grade.getGrade(rs.getString("HealthInformation.cancer")));
                    uwResponse.setCustomerHealthInformation(healthInformation);
                    uwResponse.setMaxAge(rs.getInt("maxAge"));
                    uwResponse.setMinAge(rs.getInt("minAge"));
                    uwResponse.setSmoke(Grade.getGrade(rs.getString("Insurance_Condition.smoke")));
                    uwResponse.setAlcohol(Grade.getGrade(rs.getString("Insurance_Condition.alcohol")));
                    uwResponse.setCancer(Grade.getGrade(rs.getString("Insurance_Condition.cancer")));
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
            return uwResponse;
        }

    public void activateContract(String contractId) {
        try {
            String sql = "UPDATE Contract SET contractStatus = 'active' , UWReview ='PASS' WHERE contractId=?;";
            PreparedStatement st = this.connection.prepareStatement(sql);
            st.setString(1, contractId);
            st.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void failContract(String contractId) {
        try {
            String sql = "UPDATE Contract SET UWReview='NONPASS' WHERE contractId=?;";
            PreparedStatement st = this.connection.prepareStatement(sql);
            st.setString(1, contractId);
            st.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
