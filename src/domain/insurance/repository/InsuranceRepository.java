package domain.insurance.repository;

import domain.customer.entity.Customer;
import global.util.Constants;

import java.io.IOException;
import java.sql.*;

public class InsuranceRepository {
    private static final String insuranceFile = "insurance.txt";

    public void asd() {

    }

    public String insert(Customer customer) throws IOException {

//
//        Statement statement = null;
//        ResultSet rs = null;
//        try{
//            String sql = "insert into customer (" +
//                    "customerId," +
//                    "password," +
//                    "healthInformationId," +
//                    "name," +
//                    "email," +
//                    "phoneNumber," +
//                    "address," +
//                    "detailAddress," +
//                    "zipcode," +
//                    "kindOfJob) " +
//                    "values (?,?,?,?,?,?,?,?,?,?);";
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
//            st.setInt(3, customer.getHealthInformationId());
//            st.setString(4, customer.getName());
//            st.setString(5, customer.getEmail());
//            st.setString(6, customer.getPhoneNumber());
//            st.setString(7, customer.getAddress());
//            st.setString(8, customer.getDetailAddress());
//            st.setString(9, customer.getZipcode());
//            st.setString(10, customer.getKindOfJob());
//
//            int result = st.executeUpdate();
//
//            st.close();
//            conn.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//

        return null;
    }

    public String findById(String clientId){
//        return FileCRUD.findById(clientId, insuranceFile);
        return null;
    }

    public String update(String clientId, String clientStr) throws IOException {
//        return FileCRUD.updateOne(clientId, insuranceFile, clientStr);
        return null;
    }

    public void deleteById(String clientId) throws IOException {
//        FileCRUD.deleteById(clientId, insuranceFile);
    }
}
