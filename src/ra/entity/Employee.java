package ra.entity;

import ra.validate.Validator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Employee implements IApp{
    private String employeeId;
    private String employeeName;
    private String birthday;
    private String phoneNumber;
    private boolean sex;
    private float coeffiecnt;
    private int allowanceSalary;
    private String department;
    private int status;

    public Employee() {
    }

    public Employee(int allowanceSalary, String birthday, float coeffiecnt, String department, String employeeId, String employeeName, String phoneNumber, boolean sex, byte status) {
        this.allowanceSalary = allowanceSalary;
        this.birthday = birthday;
        this.coeffiecnt = coeffiecnt;
        this.department = department;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.status = status;
    }

    public int getAllowanceSalary() {
        return allowanceSalary;
    }

    public String getBirthdate() {
        return birthday;
    }

    public float getCoeffiecnt() {
        return coeffiecnt;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public int getStatus() {
        return status;
    }

    public void setAllowanceSalary(int allowanceSalary) {
        this.allowanceSalary = allowanceSalary;
    }

    public void setBirthdate(String birthday) {
        this.birthday = birthday;
    }

    public void setCoeffiecnt(float coeffiecnt) {
        this.coeffiecnt = coeffiecnt;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner){
        employeeId = inputEmployeeId(scanner);
        employeeName = Validator.isInputString(scanner, "Nhập vào tên nhân viên : ");
        birthday = inputBirthday(scanner);
        phoneNumber = inputPhoneNumber(scanner);
        sex = Validator.isInputBoolean(scanner, "Nhập vào giới tính (true:nam, false:nữ) : ");
        coeffiecnt = Validator.isInputFloat(scanner,"Nhập vào hệ số lượng : ",0);
        allowanceSalary = Validator.isInputInt(scanner, "Nhập vào phụ cấp lương : ",0);
        department =  Validator.isInputString(scanner, "Nhập vào tên phòng ban : ");
        status =  Validator.isInputInt(scanner, "Nhập vào trạng thái (1:Đang làm việc, 2:Đang nghỉ phép, 3: Đã nghỉ việc) : ",0);

    }


    public String inputEmployeeId(Scanner scanner){
        String regex = "['NV']\\w{4}";
        return Validator.validatePattern(scanner, "Nhập vào mã nhân viên : ",regex);
    }

    public String inputBirthday(Scanner scanner){
        String regex = "\\d{2}/\\d{2}/\\d{4}";
        return Validator.validatePattern(scanner, "Nhập vào ngày sinh (dd/mm/yyyy) : ",regex);
    }
    public String inputPhoneNumber(Scanner scanner){
        String regex = "\\d{10}";
        return Validator.validatePattern(scanner, "Nhập vào số điện thoại : ",regex);
    }


    @Override
    public void displayData(){
        System.out.println("Mã nhân viên: " + employeeId);
        System.out.println("Tên nhân viên: " + employeeName);
        System.out.println("Ngày sinh: " + birthday);
        System.out.println("Số điện thoại: " + phoneNumber);
        System.out.println("Giới tính: " + (sex? "Nam" : "Nữ"));
        System.out.println("Hệ số lượng: " + coeffiecnt);
        System.out.println("Phụ cấp lương: " + allowanceSalary);
        System.out.println("Phòng ban: " + department);
        System.out.println("Trạng thái: " + (status == 1? "Đang làm việc" : (status == 2? "Đang nghỉ phép" : "Đã nghỉ việc")));
        System.out.println("Total Salary: " + BASE_SALARY*coeffiecnt + allowanceSalary);
    }
}
