package app.domain.dto;

public class VacineTypeDTO {
    private String name;

    public VacineTypeDTO(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
