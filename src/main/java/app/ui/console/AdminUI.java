package app.ui.console;

import app.ui.console.admin.*;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable {
    public AdminUI() {
    }

    public void run() {
        List<MenuItem> options = new ArrayList<MenuItem>();
        options.add(new MenuItem("Register Vacination Center ", new RegisterVacinationCenterUI()));
        options.add(new MenuItem("Register Vacine Type ", new RegisterVacineTypeUI()));
        options.add(new MenuItem("Register Vacine", new RegisterVacineUI()));
        options.add(new MenuItem("Register SNS User", new RegisterSNSUserUI()));
        options.add(new MenuItem("Register Employee", new RegisterEmployeeUI()));
        options.add(new MenuItem("Option F ", new ShowTextUI("You have chosen Option F.")));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}
