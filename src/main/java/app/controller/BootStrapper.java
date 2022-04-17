package app.controller;

public class BootStrapper {
    private final App app;
    private final RegisterVacineType registerVacineType;

    public BootStrapper(App app) {
        this.app = app;
        this.registerVacineType = new RegisterVacineType(app);
    }


    public void boot() {

        registerVacineType.registerVacineType("Covid-19");


    }


}
