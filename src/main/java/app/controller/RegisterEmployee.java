package app.controller;

import app.domain.dto.VacinationCenterDTO;
import app.domain.model.Employee;
import app.domain.model.VacinationCenter;
import app.metadata.Controller;
import pt.isep.lei.esoft.auth.mappers.dto.UserDTO;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.util.LinkedList;
import java.util.List;

@Controller
public class RegisterEmployee {
    private final App app;

    public RegisterEmployee(App app) {
        this.app = app;
    }


    public List<UserRoleDTO> roles() {
        return app.getCompany().getAuthFacade().getUserRoles();
    }

    public List<VacinationCenterDTO> centers() {
        List<VacinationCenterDTO> l = new LinkedList<>();
        app.getVacinationCenters().values().forEach(vacinationCenter -> l.add(vacinationCenter.toDTO()));
        return l;
    }

    public boolean registerEmployee(String name, String surname, String email, String password, UserRoleDTO role, VacinationCenterDTO center) {

        VacinationCenter vc = app.getVacinationCenters().get(VacinationCenter.generatekey(center.getName(), center.getAddress()));

        if (!validate(vc)) {
            return false;
        }


        if (app.getCompany().getAuthFacade().addUserWithRole(String.format("%s %s", name, surname), email, password, role.getId())) {
            UserDTO u = app.getCompany().getAuthFacade().getUser(email).orElse(null);
            Employee e = new Employee(u.getId(), u.getName(), u.getRoles().get(0));
            vc.addStaff(e);
            return true;
        }
        return false;
    }

    private boolean validate(VacinationCenter vc) {
        return vc != null;
    }


}
