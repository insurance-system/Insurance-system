package domain.customer.repository;

import domain.customer.entity.Customer;
import domain.customer.entity.FindPayment;
import domain.employee.entity.Employee;
import domain.insurance.entity.Insurance;
import global.util.Constants;

import java.io.IOException;
import java.sql.*;

import static domain.customer.enumeration.KindOfJob.getKindOfJobBy;

public class CustomerRepository {

    public Customer insert(Customer customer){
        ResultSet rs = null;
        try{
            String sql =
                    "insert into Customer (" +
                    "customerId," +
                    "password," +
                    "name," +
                    "email," +
                    "phoneNumber," +
                    "address," +
                    "detailAddress," +
                    "zipcode,"+
                    "kindOfInsurance,"+
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
        try{
            String sql = "select * from Customer where customerId = ? and password = ?;";
            PreparedStatement st = sqlConnection().prepareStatement(sql);//미리 쿼리문 준비

            st.setString(1, customerId);
            st.setString(2,password);
            rs = st.executeQuery();
            if(rs.next()){
                Customer customer = new Customer();
                customer.setCustomerId(rs.getString("customerId"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("email"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setAddress(rs.getString("address"));
                customer.setDetailAddress(rs.getString("detailAddress"));
                customer.setZipcode(rs.getString("zipCode"));
                customer.setKindOfJob(getKindOfJobBy(rs.getString("kindOfJob")));
                customer.setPassword(rs.getString("password"));

                System.out.println(customer.getCustomerId());
                return customer;
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection sqlConnection(){
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

    public Insurance findJoinedInsurances(String id) {
        ResultSet rs = null;
        try {
            String sql = "select insuranceName, fee " +
                    "from Insurance, Customer, Contract " +
                    "where Customer.customerId = Contract.customerId and Contract.insuranceId = Insurance.insuranceId and Customer.customerId = ?";
            PreparedStatement st = sqlConnection().prepareStatement(sql);


            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()){
                Insurance insurance = new Insurance(
                        rs.getString("insuranceName"),
                        rs.getInt("fee")
                );
                return insurance;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    public FindPayment findPayment(String id) {
        ResultSet rs = null;
        try{
            String sql = "select I.insuranceName, I.fee, Ph.PayDate " +
                    "from Customer C, Contract Ct, Payer P, PayHistory Ph, Insurance I " +
                    "where C.customerId = Ct.customerId and Ct.contractId = Ph.contractId and P.payerId = Ph.payerId " +
                    "and Ct.insuranceId = I.insuranceId and C.customerId = ?";

            PreparedStatement st = sqlConnection().prepareStatement(sql);

            st.setString(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                FindPayment findPayment = new FindPayment(
                        rs.getString("insuranceName"),
                        rs.getInt("fee"),
                        rs.getString("payDate")
                );
                System.out.println(findPayment.getFee());
                return findPayment;
            }
            ;
//            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void evaluateSatisfaction(String satisfaction, String id) {
        Statement statement = null;
        ResultSet rs = null;
        try{
            String sql = "update Emp_Cus set satisfaction = ? where customerId = ?;";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection(
                    Constants.URL,
                    Constants.USER,
                    Constants.PW);
            PreparedStatement st = conn.prepareStatement(sql);//미리 쿼리문 준비

            st.setString(1, satisfaction);
            st.setString(2, id);
            int result = st.executeUpdate();
            st.close();
//            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connectSalesEmployee(Customer interestCustomer) {
        ResultSet rs = null;
        try{
            String sql =
                    "insert into Customer (" +
                            "customerId," +
                            "password," +
                            "name," +
                            "email," +
                            "phoneNumber," +
                            "address," +
                            "detailAddress," +
                            "zipcode,"+
                            "kindOfInsurance,"+
                            "kindOfJob)" +
                            "values (?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement st = sqlConnection().prepareStatement(sql);//미리 쿼리문 준비

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
}
