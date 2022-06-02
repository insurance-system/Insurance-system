package domain.insurance.repository;

import domain.insurance.entity.Insurance;
import global.util.Constants;

import java.io.IOException;
import java.sql.*;

public class InsuranceRepository {

    public String insert(Insurance insurance) throws IOException {
        Statement statement = null;
        ResultSet rs = null;
        try{
            String sql =
                    "insert into Insurance (" +
                    "employeeId," +
                    "password," +
                    "name," +
                    "email," +
                    "phoneNumber," +
                    "address," +
                    "detailAddress," +
                    "zipcode)" +
                    "values (?,?,?,?,?,?,?,?);";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection(
                    Constants.URL,
                    Constants.USER,
                    Constants.PW);

//                rs = statement.executeQuery(sql);

            PreparedStatement st = conn.prepareStatement(sql);//미리 쿼리문 준비

//            st.setInt(1, insurance.getEmployeeId());
//            st.setString(2, insurance.getPassword());
//            st.setString(3, insurance.getName());
//            st.setString(4, insurance.getEmail());
//            st.setString(5, insurance.getPhoneNumber());
//            st.setString(6, insurance.getAddress());
//            st.setString(7, insurance.getDetailAddress());
//            st.setString(8, insurance.getZipcode());


            int result = st.executeUpdate();

            st.close();
//            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
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
