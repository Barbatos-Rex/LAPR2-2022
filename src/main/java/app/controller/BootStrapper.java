package app.controller;

import app.domain.dto.VacinationCenterDTO;
import app.domain.model.VacinationCenter;

import java.util.LinkedList;
import java.util.List;

public class BootStrapper {
    private final App app;
    private final RegisterVacineType registerVacineType;

    private final RegisterVacinationCenter registerVacinationCenter;

    private final RegisterEmployee registerEmployee;

    public BootStrapper(App app) {
        this.app = app;
        this.registerVacineType = new RegisterVacineType(app);
        this.registerVacinationCenter = new RegisterVacinationCenter(app);
        this.registerEmployee = new RegisterEmployee(app);
    }


    public void boot() {
        //TODO Move to config file
        app.getCompany().getAuthFacade().addUserRole("500", "Nurse");
        app.getCompany().getAuthFacade().addUserRole("501", "Secretary");
        app.getCompany().getAuthFacade().addUserRole("502", "Receptionist");
        app.getCompany().getAuthFacade().addUserRole("503", "Security Guard");
        app.getCompany().getAuthFacade().addUserRole("504", "Doctor");
        app.getCompany().getAuthFacade().addUserRole("505", "Transport Personel");

        registerVacineType.registerVacineType("Covid-19");
        registerVacinationCenter.registerVacinatioinCenter("Hospital de São João", "Alameda Prof. Hernâni Monteiro, 4200-319 Porto",
                "225512100", "-", "https://portal-chsj.min-saude.pt/", "-",
                "0:0h", "23:59h", 100, 15);
        List<VacinationCenter> vcs = new LinkedList<>(app.getVacinationCenters().values());
        VacinationCenterDTO vacinationCenterDTO = vcs.get(0).toDTO();
        registerEmployee.registerEmployee("Boot", "Strapper", "boot.strapper@gmail.com", "qwerty", app.getCompany().getAuthFacade().getRole("504").get()
                , vacinationCenterDTO);
        registerEmployee.registerEmployee("Rogério", "Silva", "boot2.strapper2@gmail.com", "qwerty", app.getCompany().getAuthFacade().getRole("500").get()
                , vacinationCenterDTO);
    }


}
