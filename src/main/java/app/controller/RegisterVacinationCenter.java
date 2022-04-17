package app.controller;

import app.domain.model.VacinationCenter;
import app.metadata.Controller;

@Controller
public class RegisterVacinationCenter {


    private final App app;

    public RegisterVacinationCenter(App app) {
        this.app = app;
    }

    public boolean registerVacinatioinCenter(String name, String address, String phoneNumber, String email, String website, String fax, String openHours, String closingHours, int vacinesSlotCap, int slotDuration) {
        if (!validateData(name, address, phoneNumber, email, website, fax, openHours, closingHours, vacinesSlotCap, slotDuration)) {
            return false;
        }

        VacinationCenter vc = new VacinationCenter(name, address, phoneNumber, email, website, fax, openHours, closingHours, vacinesSlotCap, slotDuration);
        if (app.getVacinationCenters().containsValue(vc)) {
            return false;
        }
        return app.getVacinationCenters().put(VacinationCenter.generatekey(vc), vc) != null;
    }

    private boolean validateData(String name, String address, String phoneNumber, String email, String website, String fax, String openHours, String closingHours, int vacinesSlotCap, int slotDuration) {
        return true;
    }


}
