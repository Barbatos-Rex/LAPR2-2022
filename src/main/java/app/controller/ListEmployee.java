package app.controller;

import app.domain.dto.EmployeeDTO;
import app.domain.dto.VacinationCenterDTO;
import app.domain.model.VacinationCenter;
import app.metadata.Controller;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ListEmployee {

    private final App app;

    public ListEmployee(App app) {
        this.app = app;
    }

    public List<EmployeeList> getStaff() {
        List<EmployeeList> staff = new LinkedList<>();
        for (VacinationCenter vc : app.getVacinationCenters().values()) {
            staff.add(new EmployeeList(vc.toDTO()));
        }
        return staff;
    }

    public class EmployeeList {
        private final VacinationCenterDTO vc;


        public EmployeeList(VacinationCenterDTO vc) {
            this.vc = vc;
        }


        public String getVacinationCenterInfo() {
            return vc.getName();
        }

        public List<EmployeeDTO> getEmployees() {
            return vc.getStaff();
        }


    }

}
