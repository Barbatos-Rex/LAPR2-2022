package app.ui;

import app.ui.console.AdminUI;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

//Teste
public class Main {

    public static void main(String[] args) {
        try {
//            Runnable menu = new MainMenuUI();
            Runnable menu = new AdminUI();
            menu.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
