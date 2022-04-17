package app.domain.model;

import app.domain.dto.AdministrationProcessDTO;
import app.domain.dto.OrderDoseDTO;
import app.domain.shared.DTOable;

import java.util.LinkedList;
import java.util.List;

public class AdministrationProcess implements DTOable<AdministrationProcessDTO> {
    private final AgeRange range;
    private final int dosage;
    private final List<OrderDose> doses;


    public AdministrationProcess(AgeRange range, int dosage, List<OrderDose> doses) {
        this.range = range;
        this.dosage = dosage;
        this.doses = doses;
    }


    @Override
    public AdministrationProcessDTO toDTO() {
        List<OrderDoseDTO> l = new LinkedList<>();
        doses.forEach(d -> l.add(d.toDTO()));
        return new AdministrationProcessDTO(this.range.getMinAge(), this.range.getMaxAge(), dosage, l);
    }

    @Override
    public String toString() {
        return "AdministrationProcess{" +
                "range=" + range +
                ", dosage=" + dosage +
                ", doses=" + doses +
                '}';
    }
}
