package app.domain.model;

import java.util.List;
import java.util.Objects;

public class Vacine {
    private final VacineType type;
    private final List<AdministrationProcess> administrations;

    private final String name;

    public Vacine(VacineType type, List<AdministrationProcess> administrations, String name) {
        this.type = type;
        this.administrations = administrations;
        this.name = name;
    }


    public VacineType getType() {
        return type;
    }

    public List<AdministrationProcess> getAdministrations() {
        return administrations;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacine vacine = (Vacine) o;
        return Objects.equals(type, vacine.type) && Objects.equals(name, vacine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }

    @Override
    public String toString() {
        return "Vacine{" +
                "type=" + type +
                ", administrations=" + administrations +
                ", name='" + name + '\'' +
                '}';
    }
}
