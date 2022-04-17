package app.domain.model;

import app.domain.dto.VacinationCenterDTO;
import app.domain.shared.DTOable;

import java.util.Objects;

public class VacinationCenter implements DTOable<VacinationCenterDTO> {
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

    public static String generatekey(String name, String address) {
        return name + address;
    }

    public static String generatekey(VacinationCenter vc) {
        return generatekey(vc.name, vc.address);
    }

    public void addStaff(Employee staff) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacinationCenter that = (VacinationCenter) o;
        return Objects.equals(name, that.name) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public VacinationCenterDTO toDTO() {

        return new VacinationCenterDTO(name, address, phoneNumber, email, website, fax, openHours, closingHours, vacinesSlotCap, slotDuration, staff.toDTO());
    }
}
