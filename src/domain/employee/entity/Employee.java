package domain.employee.entity;

public class Employee {
    private String employeeId;
    private String departmentId;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String detailAddress;
    private String zipcode;


    //TODO
    public static Employee toEntity(String employee){
        //파일 시스템에 데이터들이 저장되는 위치를 알야한다.
        return null;
    }

    public Employee() {
    }

    public Employee(String employeeId, String name, String email, String phoneNumber, String address, String detailAddress, String zipcode) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.detailAddress = detailAddress;
        this.zipcode = zipcode;
    }

    public Employee(String employeeId, String password, String departmentId, String name, String email, String phoneNumber, String address, String detailAddress, String zipcode) {
        this.employeeId = employeeId;
        this.password = password;
        this.departmentId = departmentId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.detailAddress = detailAddress;
        this.zipcode = zipcode;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}