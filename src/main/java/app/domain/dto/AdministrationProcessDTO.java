package app.domain.dto;

import java.util.List;

public class AdministrationProcessDTO {

    private int minAge;
    private int maxAge;
    private int dosage;
    private List<OrderDoseDTO> doses;

    public AdministrationProcessDTO(int minAge, int maxAge, int dosage, List<OrderDoseDTO> doses) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.dosage = dosage;
        this.doses = doses;
    }


    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public List<OrderDoseDTO> getDoses() {
        return doses;
    }

    public void setDoses(List<OrderDoseDTO> doses) {
        this.doses = doses;
    }
}
