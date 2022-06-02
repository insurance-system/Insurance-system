package domain.customer.repository;

import domain.customer.entity.Customer;
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

    public String findJoinedInsurances(String id) {

        return null;
    }
    /*
    public String select(int employeeId) throws IOException {
        Statement statement = null;
        ResultSet rs = null;
        try{
            String sql = "select * from Employee where id = ?;";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection(
                    Constants.URL,
                    Constants.USER,
                    Constants.PW);
            PreparedStatement st = conn.prepareStatement(sql);//미리 쿼리문 준비

            st.setInt(1, employeeId);
            int result = st.executeUpdate();
            st.close();
//            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
     */
}
