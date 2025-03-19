package ra.presentation;

import ra.entity.Employee;

import java.util.Scanner;

import static ra.bussiness.EmployeeBusiness.displayEmployees;

public class EmployeeApplication {
    public static final Employee[] arrEmployees = new Employee[100];
    public static int index = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("--------------------------- Employee Menu -----------------------------");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Chỉnh sửa thông tin nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Tìm kiếm nhân viên");
            System.out.println("6. Sắp xếp");
            System.out.println("0. Thoát chuương trình");
            System.out.print("Chọn chức năng (0-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    displayEmployees();
                    break;
                case 2:
                    Employee employee = new Employee();
                    employee.inputData(scanner);
                    arrEmployees[index] = employee;

                    index++;
                    break;
                case 3:
                    System.out.println("Nhap id nhan vien: ");
                    String id = scanner.nextLine();
                    for (int i = 0; i < index; i++) {
                        if(id == arrEmployees[i].getEmployeeId()){
                            arrEmployees[i].displayData();
                            Employee employee1 = new Employee();
                            System.out.println("Nhap thong tin moi:");
                            employee1.inputData(scanner);
                            arrEmployees[i] = employee1;
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhap id nhan vien can xoa: ");
                    String idDelete = scanner.nextLine();
                    for (int i = 0; i < index; i++) {
                        if(idDelete.equals(arrEmployees[i].getEmployeeId())){
                            for (int j = i; j < index - 1; j++) {
                                arrEmployees[j] = arrEmployees[j + 1];
                            }
                            index--;
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Nhap ten nhan vien can tim kiem: ");
                    String name = scanner.nextLine();
                    for (int i = 0; i < index; i++) {
                        if(name.equalsIgnoreCase(arrEmployees[i].getEmployeeName())){
                            arrEmployees[i].displayData();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Sap xep theo ten");
                    for (int i = 0; i < index - 1; i++) {
                        for (int j = i + 1; j < index; j++) {
                            if(arrEmployees[i].getEmployeeName().compareToIgnoreCase(arrEmployees[j].getEmployeeName()) > 0){
                                Employee temp = arrEmployees[i];
                                arrEmployees[i] = arrEmployees[j];
                                arrEmployees[j] = temp;
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không ko hợp lệ, vui lòng nhập lại");
                    break;
            }
        }while (true);
    }


}
