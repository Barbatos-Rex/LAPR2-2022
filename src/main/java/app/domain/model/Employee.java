package app.domain.model;

import app.domain.dto.EmployeeDTO;
import app.domain.shared.DTOable;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

public class Employee implements DTOable<EmployeeDTO> {

    private final String email;
    private final String name;
    private final UserRoleDTO role;

    public Employee(String email, String name, UserRoleDTO role) {
        this.email = email;
        this.name = name;
        this.role = role;
    }

    @Override
    public EmployeeDTO toDTO() {
        return new EmployeeDTO(email, name, role);
    }
}



