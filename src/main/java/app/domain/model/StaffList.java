package app.domain.model;

import pt.isep.lei.esoft.auth.domain.model.User;

import java.util.LinkedList;
import java.util.List;

public class StaffList {
    private final List<User> staffList;

    public StaffList() {
        staffList = new LinkedList<>();
    }

    //Add Staff
    public void addStaff(User staff) {
        staffList.add(staff);
    }

    //Remove Staff
    public void removeStaff(User staff) {
        staffList.remove(staff);
    }


}
