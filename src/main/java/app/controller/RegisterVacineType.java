package app.controller;

import app.domain.model.VacineType;
import app.metadata.Controller;

@Controller
public class RegisterVacineType {

    private final App app;


    public RegisterVacineType(App app) {
        this.app = app;
    }


    public boolean registerVacineType(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        VacineType type = new VacineType(name);
        return app.getVacineTypes().add(type);
    }


}
