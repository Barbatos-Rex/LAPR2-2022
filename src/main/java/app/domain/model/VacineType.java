package app.domain.model;

import app.domain.dto.VacineTypeDTO;
import app.domain.shared.DTOable;

import java.util.Objects;

public class VacineType implements DTOable<VacineTypeDTO> {
    private final String name;


    public VacineType(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "VacineType{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacineType that = (VacineType) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public VacineTypeDTO toDTO() {
        return new VacineTypeDTO(this.name);
    }
}
