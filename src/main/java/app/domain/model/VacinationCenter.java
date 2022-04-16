package app.domain.model;

import pt.isep.lei.esoft.auth.domain.model.User;

public class VacinationCenter {
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final String email;
    private final String website;
    private final String fax;
    private final String openHours;
    private final String closingHours;
    private final int vacinesSlotCap;
    private final int slotDuration;

    private final StaffList staff;


    public VacinationCenter(String name, String address, String phoneNumber, String email, String website, String fax, String openHours, String closingHours, int vacinesSlotCap, int slotDuration) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
        this.fax = fax;
        this.openHours = openHours;
        this.closingHours = closingHours;
        this.vacinesSlotCap = vacinesSlotCap;
        this.slotDuration = slotDuration;
        staff = new StaffList();
    }

    public void addStaff(User staff) {
        this.staff.addStaff(staff);
    }

    @Override
    public String toString() {
        return "VacinationCenter{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", fax='" + fax + '\'' +
                ", openHours='" + openHours + '\'' +
                ", closingHours='" + closingHours + '\'' +
                ", vacinesSlotCap=" + vacinesSlotCap +
                ", slotDuration=" + slotDuration +
                ", staff=" + staff +
                '}';
    }
}
