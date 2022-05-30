package domain.employee;

public abstract class Employee {
    private String id;
    private int departmentId;
    private String name;
    private String phoneNumber;
    private String address;
    private String detailAddress;
    private String zipcode;


    //TODO
    public static Employee toEntity(String employee){
        //파일 시스템에 데이터들이 저장되는 위치를 알야한다.
        return null;
    }

}
