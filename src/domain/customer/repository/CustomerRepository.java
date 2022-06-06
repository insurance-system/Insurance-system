package domain.customer.repository;

import domain.customer.dto.request.CustomerClaimInsuranceRequest;
import domain.customer.dto.request.CustomerHandleIncidentRequest;
import domain.customer.dto.request.InterestCustomerJoinRequest;
import domain.customer.entity.Customer;
import domain.customer.entity.FindPayment;
import domain.customer.exception.excution.NoCustomerException;
import domain.insurance.entity.Insurance;

import java.sql.*;
import java.util.ArrayList;

import static domain.customer.enumeration.KindOfJob.getKindOfJobBy;
import static domain.insurance.entity.enumeration.KindOfInsurance.getKindOfInsuranceNByName;
import static global.util.constants.DataBaseConstants.*;

public class CustomerRepository {

    private final Connection connection;

    public CustomerRepository() {
        this.connection = sqlConnection();
    }

    private Connection sqlConnection() {
        try {
            Class.forName(DB_DRIVER);
            Connection connection = null;
            connection = DriverManager.getConnection(
                    URL,
                    USER,
                    PW);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer insert(Customer customer) {
        ResultSet rs = null;
        try {
            String sql =
                    "insert into Customer (" +
                            "customerId," +
                            "password," +
                            "name," +
                            "email," +
                            "phoneNumber," +
                            "address," +
                            "detailAddress," +
                            "zipcode," +
                            "kindOfInsurance," +
                            "kindOfJob," +
                            "ssn)" +
                            "values (?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement st = connection.prepareStatement(sql);//미리 쿼리문 준비

            st.setString(1, customer.getCustomerId());
            st.setString(2, customer.getPassword());
            st.setString(3, customer.getName());
            st.setString(4, customer.getEmail());
            st.setString(5, customer.getPhoneNumber());
            st.setString(6, customer.getAddress());
            st.setString(7, customer.getDetailAddress());
            st.setString(8, customer.getZipcode());
            st.setString(9, customer.getKindOfInsurance().name());
            st.setString(10, customer.getKindOfJob().name());
            st.setString(11, customer.getSsn());

            int result = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Customer login(String customerId, String password) {
        ResultSet rs = null;
        try {
            String sql = "select * from Customer where customerId = ? and password = ?;";
            PreparedStatement st = connection.prepareStatement(sql);//미리 쿼리문 준비

            st.setString(1, customerId);
            st.setString(2, password);
            rs = st.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rs.getString("customerId"));
                customer.setPassword(rs.getString("password"));
                customer.setName(rs.getString("name"));
                customer.setKindOfInsurance(getKindOfInsuranceNByName(rs.getString("kindOfInsurance")));
                customer.setAddress(rs.getString("email"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setAddress(rs.getString("address"));
                customer.setDetailAddress(rs.getString("detailAddress"));
                customer.setZipcode(rs.getString("zipCode"));
                customer.setKindOfJob(getKindOfJobBy(rs.getString("kindOfJob")));

                System.out.println(customer.getCustomerId());
                return customer;
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        new NoCustomerException();
        return null;
    }

    public ArrayList<Insurance> findJoinedInsurances(String id) {
        ResultSet rs = null;
        try {
            String sql = "select Insurance.insuranceId, Insurance.insuranceConditionId, Insurance.kindOfInsurance, insuranceName, fee, insuranceStatus " +
                    "from Insurance, Customer, Contract " +
                    "where Customer.customerId = Contract.customerId and Contract.insuranceId = Insurance.insuranceId and Customer.customerId = ?";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, id);
            rs = st.executeQuery();
            ArrayList<Insurance> insuranceArrayList = new ArrayList<>();
            while (rs.next()) {
                Insurance insurance = new Insurance();
                insurance.setInsuranceId(rs.getString("insuranceId"));
                insurance.setInsuranceConditionId(rs.getString("insuranceConditionId"));
                insurance.setKindOfInsurance(rs.getString("kindOfInsurance"));
                insurance.setInsuranceName(rs.getString("insuranceName"));
                insurance.setFee(rs.getInt("fee"));
                insurance.setInsuranceStatus((rs.getString("insuranceStatus")));
                insuranceArrayList.add(insurance);
            }
                return insuranceArrayList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public ArrayList<FindPayment> findPayment(String id) {
        ResultSet rs = null;
        try {
            String sql = "select I.insuranceName, I.fee, Ph.PayDate " +
                    "from Customer C, Contract Ct, Payer P, PayHistory Ph, Insurance I " +
                    "where C.customerId = Ct.customerId and Ct.contractId = Ph.contractId and P.payerId = Ph.payerId " +
                    "and Ct.insuranceId = I.insuranceId and C.customerId = ?";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, id);
            rs = st.executeQuery();
            ArrayList<FindPayment> findPaymentArrayList = new ArrayList<>();
            while (rs.next()) {
                FindPayment findPayment = new FindPayment();
                findPayment.setInsuranceName(rs.getString("insuranceName"));
                findPayment.setFee(rs.getInt("fee"));
                findPayment.setPayDate(rs.getString("payDate"));
                findPaymentArrayList.add(findPayment);

            }
            return findPaymentArrayList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void evaluateSatisfaction(String satisfaction, String id) {
        Statement statement = null;
        ResultSet rs = null;
        try {
            String sql = "update Emp_Cus set satisfaction = ? where customerId = ?;";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, satisfaction);
            st.setString(2, id);
            int result = st.executeUpdate();
            st.close();
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connectSalesEmployee(Customer Customer) {
        ResultSet rs = null;
        String emp_CusId = Integer.toString(Integer.parseInt(findLastEmpCusId())+1);
        try {
            String sql =
                    "insert into Emp_Cus (emp_CusId,employeeId,customerId,satisfaction) values (?,?,?,?);";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, emp_CusId);
            st.setString(2, null);
            st.setString(3, Customer.getCustomerId());
            st.setString(4, null);
            int result = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String checkSatisfaction(String id) {
        ResultSet rs = null;
        try {
            String sql = "select satisfaction from Emp_Cus where customerId=?;";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, id);
            rs = st.executeQuery();
            while(rs.next()) {
                String checkSatisfaction = rs.getString("satisfaction");
                return checkSatisfaction;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Insurance> findInterestInsurance(Customer customer) {
        ResultSet rs = null;
        try {
            String sql = "select * from Insurance where kindOfInsurance=?";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, customer.getKindOfInsurance().name());
            rs = st.executeQuery();
            ArrayList<Insurance> interestInsuranceArrayList = new ArrayList<>();
            while (rs.next()) {
                Insurance insurance = new Insurance();
                insurance.setInsuranceId(rs.getString("insuranceId"));
                insurance.setInsuranceConditionId(rs.getString("insuranceConditionId"));
                insurance.setKindOfInsurance(rs.getString("kindOfInsurance"));
                insurance.setInsuranceName(rs.getString("insuranceName"));
                insurance.setFee(rs.getInt("fee"));
                insurance.setInsuranceStatus(rs.getString("insuranceStatus"));
                interestInsuranceArrayList.add(insurance);
            }
            return interestInsuranceArrayList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    public void joinPayer(String payerId, String account, Customer customer) {
        ResultSet rs = null;
        try {
            String sql =
                    "insert into Payer (payerId, customerId, account) values (?,?,?);";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, payerId);
            st.setString(2, customer.getCustomerId());
            st.setString(3, account);
            int result = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkPayer(Customer customer) {
        ResultSet rs = null;
        try {
            String sql = "select payerId from Payer where customerId=?;";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, customer.getCustomerId());
            rs = st.executeQuery();
            while(rs.next()) {
                String checkPayer = rs.getString("payerId");
                return checkPayer;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String checkBeneficiary(Customer customer) {
        ResultSet rs = null;
        try {
            String sql = "select beneficiaryId from Beneficiary where customerId=?;";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, customer.getCustomerId());
            rs = st.executeQuery();
            while(rs.next()) {
                String checkBeneficiary = rs.getString("beneficiaryId");
                return checkBeneficiary;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void joinBeneficiary(String beneficiaryId, String account, Customer customer) {
        ResultSet rs = null;
        try {
            String sql =
                    "insert into Beneficiary (beneficiaryId, customerId, account) values (?,?,?);";

            PreparedStatement st = connection.prepareStatement(sql);//미리 쿼리문 준비

            st.setString(1, beneficiaryId);
            st.setString(2, customer.getCustomerId());
            st.setString(3, account);
            int result = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkJoinNonlifeInsurance(Customer customer) {
        ResultSet rs = null;
        try {
            String sql = "select Ih.incidentId\n" +
                    " from Customer C, Contract Ct, Insurance I, Incident_handling Ih\n" +
                    " where C.customerId = Ct.customerId and Ct.customerId = Ih.customerId and Ct.insuranceId = I.insuranceId\n" +
                    " and C.customerId = ? and I.kindOfInsurance = 'LIFE';";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, customer.getCustomerId());
            rs = st.executeQuery();
            while(rs.next()) {
                String checkJoinNonlifeInsurance = rs.getString("incidentId");
                return checkJoinNonlifeInsurance;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void handleIncident(CustomerHandleIncidentRequest incidentHandling) {
        ResultSet rs = null;
        String incidentId = Integer.toString(Integer.parseInt(findLastIncidentHandlingId())+1);
        try {
            String sql =
                    "insert into Incident_handling (incidentId, customerId, incidentDate, incidentName, incidentPhoneNum, errorRate, carNumber, incidentSite, employeeId) values (?,?,?,?,?,?,?,?,?);";

            PreparedStatement st = connection.prepareStatement(sql);//미리 쿼리문 준비

            st.setString(1, incidentId);
            st.setString(2, incidentHandling.getCustomerId());
            st.setDate(3, incidentHandling.getIncidentDate());
            st.setString(4, null);
            st.setString(5, null);
            st.setString(6, null);
            st.setString(7, incidentHandling.getCarNumber());
            st.setString(8, incidentHandling.getCarNumber());
            st.setString(9, null);
            int result = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public String checkJoinLifeInsurance(Customer customer) {
        ResultSet rs = null;
        try {
            String sql =
                    "select Ic.insuranceClaimId " +
                    " from Customer C, Contract Ct, Insurance I, InsuranceClaim Ic\n" +
                    " where C.customerId = Ct.customerId and Ct.customerId = Ic.customerId and Ct.insuranceId = I.insuranceId\n" +
                    " and C.customerId = ? and I.kindOfInsurance = 'NON_LIFE';";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, customer.getCustomerId());
            rs = st.executeQuery();
            while(rs.next()) {
                String checkJoinLifeInsurance = rs.getString("insuranceClaimId");
                return checkJoinLifeInsurance;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void claimInsurance(CustomerClaimInsuranceRequest claimInsurance) {
        ResultSet rs = null;
        String insuranceClaimId = Integer.toString(Integer.parseInt(findLastInsuranceClaimId())+1);
        try {
            String sql =
                    "insert into InsuranceClaim (insuranceClaimId, customerId, claimContent, claimCost) values (?,?,?,?);";

            PreparedStatement st = connection.prepareStatement(sql);//미리 쿼리문 준비

            st.setString(1, insuranceClaimId);
            st.setString(2, claimInsurance.getCustomerId());
            st.setString(3, claimInsurance.getClaimContent());
            st.setInt(4, claimInsurance.getClaimCost());
            int result = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String findLastInsuranceClaimId() {
        ResultSet rs = null;
        try {
            String sql = "SELECT insuranceClaimId FROM InsuranceClaim ORDER BY insuranceClaimId DESC LIMIT 1";

            PreparedStatement st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                String lastId = rs.getString("insuranceClaimId");
                return lastId;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String findLastEmpCusId() {
        ResultSet rs = null;
        try {
            String sql = "SELECT emp_CusId FROM Emp_Cus ORDER BY emp_CusId DESC LIMIT 1";

            PreparedStatement st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                String lastId = rs.getString("emp_CusId");
                return lastId;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String findLastIncidentHandlingId() {
        ResultSet rs = null;
        try {
            String sql = "SELECT incidentId FROM Incident_handling ORDER BY incidentId DESC LIMIT 1";

            PreparedStatement st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                String lastId = rs.getString("incidentId");
                return lastId;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int checkIdExist(String customerId) {
        ResultSet rs = null;
        try {
            String sql = "SELECT count(*) FROM Customer WHERE customerId = ?;";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customerId);
            rs = st.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("count(*)");
                return id;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public void addCustomerInformation(InterestCustomerJoinRequest customer, String customerId) {
        Statement statement = null;
        ResultSet rs = null;
        try {
            String sql = "update Customer set  address=?, detailAddress=?, zipcode=?, email=? where customerId = ?;";

            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, customer.getAddress());
            st.setString(2, customer.getDetailAddress());
            st.setString(3, customer.getZipcode());
            st.setString(4, customer.getEmail());
            st.setString(5, customerId);

            int result = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String checkConnection(Customer customer) {
        ResultSet rs = null;
        try {
            String sql = "SELECT employeeId FROM Emp_Cus WHERE customerId = ?;";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customer.getCustomerId());
            rs = st.executeQuery();
            while(rs.next()) {
                String employeeId = rs.getString("employeeId");
                return employeeId;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public String findLastContractId() {
        ResultSet rs = null;
        try {
            String sql = "SELECT contractId FROM Contract ORDER BY contractId DESC LIMIT 1";

            PreparedStatement st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                String lastId = rs.getString("contractId");
                return Integer.toString(Integer.parseInt(lastId)+1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
