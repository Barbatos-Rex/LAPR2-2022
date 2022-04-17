package app.controller;

import app.domain.model.Company;
import app.domain.model.VacinationCenter;
import app.domain.model.Vacine;
import app.domain.model.VacineType;
import app.domain.shared.Constants;
import app.metadata.Singleton;
import pt.isep.lei.esoft.auth.AuthFacade;
import pt.isep.lei.esoft.auth.UserSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
@Singleton
public class App {

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    private final Company company;
    private final AuthFacade authFacade;

    private final List<VacinationCenter> vacinationCenters;

    private final Set<VacineType> vacineTypes;

    private final Set<Vacine> vacines;

    private App() {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        vacinationCenters = new LinkedList<>();
        vacineTypes = new LinkedHashSet<>();
        vacines = new LinkedHashSet<>();
    }

    public static App getInstance() {
        if (singleton == null) {
            synchronized (App.class) {
                singleton = new App();
                singleton.bootstrap();
            }
        }
        return singleton;
    }

    public Company getCompany() {
        return this.company;
    }

    public UserSession getCurrentUserSession() {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd) {
        return this.authFacade.doLogin(email, pwd).isLoggedIn();
    }

    public void doLogout() {
        this.authFacade.doLogout();
    }

    private Properties getProperties() {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "DGS/SNS");


        // Read configured values
        try {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        } catch (IOException ex) {

        }
        return props;
    }

    private void bootstrap() {
        new BootStrapper(this).boot();
        this.authFacade.addUserRole(Constants.ROLE_ADMIN, Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456", Constants.ROLE_ADMIN);
    }

    public List<VacinationCenter> getVacinationCenters() {
        return vacinationCenters;
    }

    public Set<VacineType> getVacineTypes() {
        return vacineTypes;
    }

    public Set<Vacine> getVacines() {
        return vacines;
    }
}
