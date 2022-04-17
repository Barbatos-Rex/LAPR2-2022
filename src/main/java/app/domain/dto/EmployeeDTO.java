package app.domain.dto;

import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

public class EmployeeDTO {
    private String email;
    private String name;
    private UserRoleDTO role;

    public EmployeeDTO(String email, String name, UserRoleDTO role) {
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRoleDTO getRole() {
        return role;
    }

    public void setRole(UserRoleDTO role) {
        this.role = role;
    }
}
