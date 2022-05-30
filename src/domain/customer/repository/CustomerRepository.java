package domain.customer.repository;

import domain.customer.entity.Customer;
import global.util.Constants;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {

//    private static final String clientFile = "client-informations";
//    //고객 관심사항 파일
//    private static final String clientInterestFile = "customer-advice";
//


    public CustomerRepository() {
    }

    public String insert(Customer customer){
//        Statement statement = null;
//        ResultSet rs = null;
//        try{
//            String sql = "insert into Customer (" +
//                    "customerId," +
//                    "password," +
//                    "name," +
//                    "email," +
//                    "phoneNumber," +
//                    "address," +
//                    "detailAddress," +
//                    "zipcode," +
//                    "kindOfJob) " +
//                    "values (?,?,?,?,?,?,?,?,?);";
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = null;
//            conn = DriverManager.getConnection(
//                    Constants.URL,
//                    Constants.USER,
//                    Constants.PW);
//
////                rs = statement.executeQuery(sql);
//
//            PreparedStatement st = conn.prepareStatement(sql);//미리 쿼리문 준비
//
//            st.setInt(1, customer.getCustomerId());
//            st.setString(2, customer.getPassword());
//            st.setString(3, customer.getName());
//            st.setString(4, customer.getEmail());
//            st.setString(5, customer.getPhoneNumber());
//            st.setString(6, customer.getAddress());
//            st.setString(7, customer.getDetailAddress());
//            st.setString(8, customer.getZipcode());
//            st.setString(9, customer.getKindOfJob());
//
//            int result = st.executeUpdate();
//
//            st.close();
////            conn.close();
//        }catch(SQLException e){
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public String findById(String clientId){
//        return FileCRUD.findById(clientId, clientFile);
        return null;
    }

    String update(String clientId, String clientStr) throws IOException {
//        return FileCRUD.updateOne(clientId, clientFile, clientStr);
        return null;
    }

    public void deleteById(String clientId) throws IOException {
//        FileCRUD.deleteById(clientId, clientFile);
    }

    public String insertInterest(ArrayList<String> clientStr){
        String asd = "";
        for (String s : clientStr) asd += s + " ";
//        return FileCRUD.insertOne(clientInterestFile, asd);
        return null;
    }

    public Customer login(String id, String password) {
        ResultSet rs = null;
        try{
            String sql = "select * from Customer where customerId = ? and password = ?;";
            PreparedStatement st = sqlConnection().prepareStatement(sql);//미리 쿼리문 준비

            st.setInt(1, Integer.parseInt(id));
            st.setString(2,password);
            rs = st.executeQuery();
            if(rs.next()){
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("customerId"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("email"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setAddress(rs.getString("address"));
                customer.setDetailAddress(rs.getString("detailAddress"));
                customer.setZipcode(rs.getString("zipCode"));
                customer.setKindOfJob(rs.getString("kindOfJob"));
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
}
