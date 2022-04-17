package app.controller;

public class BootStrapper {
    private final App app;
    private final RegisterVacineType registerVacineType;

    private final RegisterVacinationCenter registerVacinationCenter;

    public BootStrapper(App app) {
        this.app = app;
        this.registerVacineType = new RegisterVacineType(app);
        this.registerVacinationCenter = new RegisterVacinationCenter(app);
    }


    public void boot() {
        //TODO Move to config file
        app.getCompany().getAuthFacade().addUserRole(String.valueOf(Math.random() * 10000), "Nurse");
        app.getCompany().getAuthFacade().addUserRole(String.valueOf(Math.random() * 10000), "Secretary");
        app.getCompany().getAuthFacade().addUserRole(String.valueOf(Math.random() * 10000), "Receptionist");
        app.getCompany().getAuthFacade().addUserRole(String.valueOf(Math.random() * 10000), "Security Guard");
        app.getCompany().getAuthFacade().addUserRole(String.valueOf(Math.random() * 10000), "Doctor");
        app.getCompany().getAuthFacade().addUserRole(String.valueOf(Math.random() * 10000), "Transport Personel");


        registerVacineType.registerVacineType("Covid-19");
        registerVacinationCenter.registerVacinatioinCenter("Hospital de São João", "Alameda Prof. Hernâni Monteiro, 4200-319 Porto",
                "225512100", "-", "https://portal-chsj.min-saude.pt/", "-",
                "0:0h", "23:59h", 100, 15);


    }


}
