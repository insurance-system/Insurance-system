package domain.employee.repository;

import domain.customer.entity.Customer;
import domain.customer.enumeration.KindOfJob;
import domain.employee.dto.CustomerConsultResponse;
import domain.employee.entity.Employee;
import domain.employee.exception.excution.NoEmployeeException;
import domain.insurance.entity.enumeration.KindOfInsurance;
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

    public ArrayList<CustomerConsultResponse> customerConsult(Employee employee) {
        ResultSet rs = null;
        try {
            String sql = "Select Emp_Cus.emp_CusId, Customer.customerId, Customer.name, Customer.phoneNumber, Customer.kindOfInsurance, Customer.kindOfJob" +
                    " from Emp_Cus, Customer " +
                    "where Customer.customerId = Emp_Cus.customerId and Emp_Cus.satisfaction is null;";
            PreparedStatement st = this.connection.prepareStatement(sql);

            rs = st.executeQuery();

            ArrayList<CustomerConsultResponse> customerList = new ArrayList<>();
            while (rs.next()){
                CustomerConsultResponse customerConsultResponse = new CustomerConsultResponse();
                customerConsultResponse.setEmpCusId(rs.getString("emp_CusId"));
                customerConsultResponse.setCustomerId(rs.getString("customerId"));
                customerConsultResponse.setName(rs.getString("name"));
                customerConsultResponse.setPhoneNumber(rs.getString("phoneNumber"));
                customerConsultResponse.setKindOfInsurance(KindOfInsurance.getKindOfInsuranceBy(rs.getInt("kindOfInsurance")));
                customerConsultResponse.setKindOfJob(KindOfJob.getKindOfJobBy(rs.getString("kindOfJob")));
                customerList.add(customerConsultResponse);
            }

                return customerList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void consultExcute(Employee employee, CustomerConsultResponse customerConsultResponse) {
        ResultSet rs = null;
        try {
            String sql = "Select Emp_Cus.emp_CusId, Customer.customerId, Customer.name, Customer.phoneNumber, Customer.kindOfInsurance, Customer.kindOfJob" +
                    " from Emp_Cus, Customer " +
                    "where Customer.customerId = Emp_Cus.customerId and Emp_Cus.satisfaction is null;";
            PreparedStatement st = this.connection.prepareStatement(sql);

            rs = st.executeQuery();

            ArrayList<CustomerConsultResponse> customerList = new ArrayList<>();
            while (rs.next()){
                CustomerConsultResponse customerConsultResponse1 = new CustomerConsultResponse();
                customerConsultResponse1.setEmpCusId(rs.getString("emp_CusId"));
                customerConsultResponse1.setCustomerId(rs.getString("customerId"));
                customerConsultResponse1.setName(rs.getString("name"));
                customerConsultResponse1.setPhoneNumber(rs.getString("phoneNumber"));
                customerConsultResponse1.setKindOfInsurance(KindOfInsurance.getKindOfInsuranceBy(rs.getInt("kindOfInsurance")));
                customerConsultResponse1.setKindOfJob(KindOfJob.getKindOfJobBy(rs.getString("kindOfJob")));
                customerList.add(customerConsultResponse1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
