package app.controller;

import app.domain.dto.AdministrationProcessDTO;
import app.domain.dto.OrderDoseDTO;
import app.domain.dto.VacineTypeDTO;
import app.domain.model.*;
import app.metadata.Controller;

import java.util.LinkedList;
import java.util.List;

@Controller
public class RegisterVacine {
    private final App app;

    public RegisterVacine(App app) {
        this.app = app;
    }


    public List<VacineTypeDTO> getAllTypes() {
        List<VacineTypeDTO> types = new LinkedList<>();
        this.app.getVacineTypes().forEach(t -> types.add(t.toDTO()));
        return types;
    }

    public boolean registerVacine(String name, VacineTypeDTO type, List<AdministrationProcessDTO> administrations) {

        VacineType t = new VacineType(type.getName());
        List<AdministrationProcess> administrationProcesses = new LinkedList<>();


        if (validate(name, type, administrations)) {


            administrations.forEach(a -> {

                List<OrderDose> l = new LinkedList<>();
                a.getDoses().forEach(d -> l.add(new OrderDose(d.getCurrentDose(), d.getTimeNextDose())));


                AdministrationProcess ap = new AdministrationProcess(new AgeRange(a.getMinAge(), a.getMaxAge())
                        , a.getDosage(), l);
                administrationProcesses.add(ap);
            });

            Vacine v = new Vacine(t, administrationProcesses, name);
            return this.app.getVacines().add(v);

        }
        return false;
    }

    private boolean validate(String name, VacineTypeDTO type, List<AdministrationProcessDTO> administrations) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (type == null || type.getName() == null || type.getName().isEmpty()) {
            return false;
        }
        return !administrations.isEmpty() && validateAdministrations(administrations);
    }

    private boolean validateAdministrations(List<AdministrationProcessDTO> administrations) {
        for (AdministrationProcessDTO a : administrations) {

            if (a == null) {
                return false;
            }

            if (a.getMinAge() > a.getMaxAge()) {
                return false;
            }
            if (a.getDoses().isEmpty()) {
                return false;
            }
            for (OrderDoseDTO d : a.getDoses()) {
                if (d == null) {
                    return false;
                }
            }
        }
        return true;
    }
}