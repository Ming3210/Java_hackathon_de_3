package ra.bussiness;

import ra.entity.Employee;
import ra.presentation.EmployeeApplication;

public class EmployeeBusiness {
    public static void displayEmployees(){
        for(int i = 0; i< EmployeeApplication.index; i++){
            EmployeeApplication.arrEmployees[i].displayData();
        }
    }


}
