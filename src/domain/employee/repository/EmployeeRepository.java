package domain.employee.repository;

import domain.employee.entity.Employee;
import global.util.Constants;

import java.io.IOException;
import java.sql.*;
/*
* 여기에 CRUD 있어요~ argument만 바꿔서 쓰면됨
* */
public class EmployeeRepository {

    public String insert(Employee employee) throws IOException {
        Statement statement = null;
        ResultSet rs = null;
        try{
            String sql = "insert into Employee (" +
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

            st.setInt(1, employee.getEmployeeId());
            st.setString(2, employee.getPassword());
            st.setString(3, employee.getName());
            st.setString(4, employee.getEmail());
            st.setString(5, employee.getPhoneNumber());
            st.setString(6, employee.getAddress());
            st.setString(7, employee.getDetailAddress());
            st.setString(8, employee.getZipcode());


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

    public String delete(int employeeId) throws IOException {
        Statement statement = null;
        ResultSet rs = null;
        try{
            String sql = "delete from Employee where id = ?;";

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
}
