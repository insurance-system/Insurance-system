package domain.employee.repository;

import domain.employee.entity.Employee;
import domain.employee.exception.excution.NoEmployeeException;
import global.dao.Lecture;
import global.util.Constants;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/*
* 여기에 CRUD 있어요~ argument만 바꿔서 쓰면됨
* */
public class EmployeeRepository {

    private Connection connection;

    public EmployeeRepository() {
        this.connection = this.sqlConnection();
    }

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

            PreparedStatement st = connection.prepareStatement(sql);//미리 쿼리문 준비

            st.setString(1, employee.getEmployeeId());
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

    public boolean insertLecture(Lecture lecturer) {
//        String lectureId, String lectureName, String lecturePdfName, String lecturerId
        Statement statement = null;
        ResultSet rs = null;
        try{
            String sql = "insert into Lecture (" +
                    "lectureId," +
                    "lectureName," +
                    "lecturePdfName," +
                    "lecturerId)" +
                    "values (?,?,?,?);";

            Class.forName("com.mysql.cj.jdbc.Driver");

//                rs = statement.executeQuery(sql);

            PreparedStatement st = connection.prepareStatement(sql);//미리 쿼리문 준비

            st.setString(1, lecturer.getLectureId());
            st.setString(2, lecturer.getLectureName());
            st.setString(3, lecturer.getLecturePdfName());
            st.setString(4, lecturer.getLecturerId());

            int result = st.executeUpdate();

            st.close();
        }catch(SQLException | ClassNotFoundException e){
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
}
