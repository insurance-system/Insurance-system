package domain.customer.repository;

import domain.customer.entity.Customer;
import domain.customer.entity.FindPayment;
import domain.customer.exception.excution.*;
import domain.insurance.entity.Insurance;
import global.util.Constants;

import java.sql.*;
import java.util.ArrayList;

import static domain.customer.enumeration.KindOfJob.getKindOfJobBy;
import static domain.insurance.entity.enumeration.KindOfInsurance.getKindOfInsuranceNByName;

public class CustomerRepository {

    private Connection connection;

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
                            "kindOfJob)" +
                            "values (?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement st = sqlConnection().prepareStatement(sql);//미리 쿼리문 준비

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
            PreparedStatement st = sqlConnection().prepareStatement(sql);//미리 쿼리문 준비

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

    private Connection sqlConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection(
                    Constants.URL,
                    Constants.USER,
                    Constants.PW);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Insurance> findJoinedInsurances(String id) {
        ResultSet rs = null;
        try {
            String sql = "select Insurance.insuranceId, Insurance.insuranceConditionId, Insurance.kindOfInsurance, insuranceName, fee, insuranceStatus " +
                    "from Insurance, Customer, Contract " +
                    "where Customer.customerId = Contract.customerId and Contract.insuranceId = Insurance.insuranceId and Customer.customerId = ?";
            PreparedStatement st = sqlConnection().prepareStatement(sql);

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
                insurance.setInsuranceStatus(rs.getString("insuranceStatus"));
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

            PreparedStatement st = sqlConnection().prepareStatement(sql);

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

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection(
                    Constants.URL,
                    Constants.USER,
                    Constants.PW);
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, satisfaction);
            st.setString(2, id);
            int result = st.executeUpdate();
            st.close();
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void joinInterestCustomer(Customer interestCustomer) {
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
                            "kindOfJob)" +
                            "values (?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement st = sqlConnection().prepareStatement(sql);

            st.setString(1, interestCustomer.getCustomerId());
            st.setString(2, interestCustomer.getPassword());
            st.setString(3, interestCustomer.getName());
            st.setString(4, interestCustomer.getEmail());
            st.setString(5, interestCustomer.getPhoneNumber());
            st.setString(6, interestCustomer.getAddress());
            st.setString(7, interestCustomer.getDetailAddress());
            st.setString(8, interestCustomer.getZipcode());
            st.setString(9, interestCustomer.getKindOfInsurance().name());
            st.setString(10, interestCustomer.getKindOfJob().name());

            int result = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connectSalesEmployee(Customer Customer) {
        ResultSet rs = null;
        try {
            String sql =
                    "insert into Emp_Cus (emp_CusId,employeeId,customerId,satisfaction) values (?,?,?,?);";

            PreparedStatement st = sqlConnection().prepareStatement(sql);

            st.setString(1, "EC" + Customer.getCustomerId());
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

            PreparedStatement st = sqlConnection().prepareStatement(sql);

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
            PreparedStatement st = sqlConnection().prepareStatement(sql);

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

            PreparedStatement st = sqlConnection().prepareStatement(sql);

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

            PreparedStatement st = sqlConnection().prepareStatement(sql);

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

            PreparedStatement st = sqlConnection().prepareStatement(sql);

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

            PreparedStatement st = sqlConnection().prepareStatement(sql);//미리 쿼리문 준비

            st.setString(1, beneficiaryId);
            st.setString(2, customer.getCustomerId());
            st.setString(3, account);
            int result = st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
