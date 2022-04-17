package app.domain.model;

import app.domain.dto.EmployeeDTO;
import app.domain.shared.DTOable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StaffList implements Iterable<Employee>, DTOable<List<EmployeeDTO>> {
    private final List<Employee> staffList;

    public StaffList() {
        staffList = new LinkedList<>();
    }

    //Add Staff
    public void addStaff(Employee staff) {
        staffList.add(staff);
    }

    //Remove Staff
    public void removeStaff(Employee staff) {
        staffList.remove(staff);
    }


    @Override
    public Iterator<Employee> iterator() {
        return staffList.iterator();
    }

    @Override
    public List<EmployeeDTO> toDTO() {
        List<EmployeeDTO> dtoList = new LinkedList<>();
        staffList.forEach(staff -> dtoList.add(staff.toDTO()));
        return dtoList;
    }
}
