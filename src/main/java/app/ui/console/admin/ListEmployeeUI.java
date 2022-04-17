package app.ui.console.admin;

import app.controller.App;
import app.controller.ListEmployee;
import app.domain.dto.EmployeeDTO;

import java.util.List;

public class ListEmployeeUI implements Runnable {
    private final ListEmployee listEmployee = new ListEmployee(App.getInstance());


    @Override
    public void run() {
        System.out.println("List of employees");
        List<ListEmployee.EmployeeList> employeeList = listEmployee.getStaff();
        for (ListEmployee.EmployeeList employee : employeeList) {
            for (EmployeeDTO emp : employee.getEmployees()) {
                System.out.printf("%s - %s - %s\n", emp.getName(), emp.getRole().getDescription(), employee.getVacinationCenterInfo());
            }
        }
    }
}
