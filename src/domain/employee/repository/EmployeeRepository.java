package domain.employee.repository;

import domain.contract.entity.Contract;
import domain.customer.enumeration.KindOfJob;
import domain.employee.dto.Customer;
import domain.employee.dto.DefaultResponse;
import domain.employee.dto.ExpirationResponse;
import domain.employee.entity.Employee;
import domain.employee.exception.excution.NoEmployeeException;
import domain.insurance.entity.enumeration.KindOfInsurance;
import global.dao.Lecture;
import global.util.Constants;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public ArrayList<Customer> customerConsult(Employee employee) {
        ResultSet rs = null;
        try {
            String sql = "Select Emp_Cus.emp_CusId, Customer.customerId, Customer.name, Customer.phoneNumber, Customer.kindOfInsurance, Customer.kindOfJob" +
                    " from Emp_Cus, Customer " +
                    "where Customer.customerId = Emp_Cus.customerId and Emp_Cus.satisfaction is null;";
            PreparedStatement st = this.connection.prepareStatement(sql);

            rs = st.executeQuery();

            ArrayList<Customer> customerList = new ArrayList<>();
            while (rs.next()){
                Customer customerConsultResponse = new Customer();
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

    public ArrayList<Contract> selectContractList() {
        ArrayList<Contract> contractList = new ArrayList<>();
        String sql = "select * from Contract;";
        try {
            PreparedStatement st = this.connection.prepareStatement(sql);
            ResultSet rs = null;
            rs = st.executeQuery();

            while (rs.next()) {
                Contract contract = new Contract();
                contract.setContractId(rs.getInt("contractId"));
                contract.setCustomerId(rs.getString("customerId"));
                contract.setInsuranceId(rs.getInt("insuranceId"));
                contract.setExpiredDate(LocalDate.parse(rs.getString("expiredDate"), DateTimeFormatter.ISO_DATE));
                contract.setPaymentDate(LocalDate.parse(rs.getString("paymentDate"), DateTimeFormatter.ISO_DATE));
                contract.setContractStatus(rs.getString("contractStatus"));
                contractList.add(contract);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return contractList;
    }

    public void consultExcute(Employee employee, Customer customerConsultResponse) {
        ResultSet rs = null;
        try {
            String sql = "UPDATE Emp_Cus SET employeeId = ? WHERE emp_CusId=?";
            PreparedStatement st = this.connection.prepareStatement(sql);
            st.setString(1, employee.getEmployeeId());
            st.setString(2, customerConsultResponse.getEmpCusId());
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<domain.customer.entity.Customer> selectEmployeeByIds(ArrayList<String> nearExpiredContractsCustomerIds) {
        ArrayList<domain.customer.entity.Customer> customerList = new ArrayList<>();
        String args = "";
        for (String nearExpiredContractsCustomerId : nearExpiredContractsCustomerIds) {
            args += "'"+nearExpiredContractsCustomerId+"',";
        }
        args = args.substring(0, args.length()-1);

        String sql = "select * from Customer where customerId in ("+args +");";
        System.out.println("sql = " + sql);
        try {
            PreparedStatement st = this.connection.prepareStatement(sql);
            ResultSet rs = null;
            rs = st.executeQuery();

            while (rs.next()) {
                domain.customer.entity.Customer customer = new domain.customer.entity.Customer();
                customer.setCustomerId(rs.getString("customerId"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customerList.add(customer);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customerList;
    }

    public ArrayList<ExpirationResponse> contractManage() {
        ResultSet rs = null;
        try {
            String sql = "select c.customerId, c.name, c.phoneNumber, c.email, c.kindOfJob, c.kindOfInsurance, i.insuranceName, i.insuranceStatus, contractStatus " +
                    " From Customer c, Contract, Insurance i " +
                    "where c.customerId = Contract.customerId" +
                    "  and Contract.insuranceId = i.insuranceId" +
                    "  and contractStatus = 'expiration' ";
            PreparedStatement st = this.connection.prepareStatement(sql);

            rs = st.executeQuery();

            ArrayList<ExpirationResponse> expirationResponses = new ArrayList<>();
            while (rs.next()){
                ExpirationResponse expirationResponse = new ExpirationResponse(
                        rs.getString("customerId"),
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"),
                        KindOfJob.getKindOfJobBy(rs.getString("kindOfJob")),
                        KindOfInsurance.getKindOfInsuranceBy(rs.getInt("kindOfInsurance")),
                        rs.getString("insuranceName"),
                        rs.getString("insuranceStatus"),
                        "만기"
                );
                expirationResponses.add(expirationResponse);
            }

            return expirationResponses;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<DefaultResponse> selectDefaultCustomer() {
        ResultSet rs = null;
        try {
            String sql = "select c.customerId, c.name, c.phoneNumber, address, detailAddress, zipCode, insuranceName, contractStatus " +
                    " FROM Customer c, Contract, Insurance " +
                    " WHERE c.customerId = Contract.customerId and Contract.insuranceId = Insurance.insuranceId " +
                    "  and contractStatus = 'default'";
            PreparedStatement st = this.connection.prepareStatement(sql);

            rs = st.executeQuery();

            ArrayList<DefaultResponse> defaultResponses = new ArrayList<>();
            while (rs.next()){
                DefaultResponse defaultResponse = new DefaultResponse(
                        rs.getString("customerId"),
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("address"),
                        rs.getString("detailAddress"),
                        rs.getString("zipCode"),
                        rs.getString("insuranceName"),
                        "미납"
                );
                defaultResponses.add(defaultResponse);
            }

            return defaultResponses;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
