package app.controller;

import app.domain.model.SNSUser;
import app.metadata.Controller;

@Controller
public class RegisterSNSUser {

    private final App app;

    public RegisterSNSUser(App app) {
        this.app = app;
    }


    public boolean registerSNSUser(String socialId, String firstName, String middleNames, String lastName, String identificationNumber, String email, String phoneNumber) {

        if (!validate(socialId, firstName, middleNames, lastName, identificationNumber, email, phoneNumber)) {
            return false;
        }

        SNSUser user = new SNSUser(socialId, firstName, middleNames, lastName, identificationNumber, email, phoneNumber);
        return app.getSnsUsers().add(user);

    }

    private boolean validate(String... args) {

        for (String arg : args) {
            if (arg == null || arg.isEmpty()) {
                return false;
            }
        }

        return true;
    }


}
