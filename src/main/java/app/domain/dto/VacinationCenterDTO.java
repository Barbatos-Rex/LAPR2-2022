package app.domain.dto;

import java.util.List;

public class VacinationCenterDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String website;

    private String fax;
    private String openHours;
    private String closingHours;
    private int vacinesSlotCap;
    private int slotDuration;

    private List<EmployeeDTO> staff;

    public VacinationCenterDTO(String name, String address, String phoneNumber, String email, String website, String fax, String openHours, String closingHours, int vacinesSlotCap, int slotDuration, List<EmployeeDTO> staff) {
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
        this.staff = staff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getClosingHours() {
        return closingHours;
    }

    public void setClosingHours(String closingHours) {
        this.closingHours = closingHours;
    }

    public int getVacinesSlotCap() {
        return vacinesSlotCap;
    }

    public void setVacinesSlotCap(int vacinesSlotCap) {
        this.vacinesSlotCap = vacinesSlotCap;
    }

    public int getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(int slotDuration) {
        this.slotDuration = slotDuration;
    }

    public List<EmployeeDTO> getStaff() {
        return staff;
    }

    public void setStaff(List<EmployeeDTO> staff) {
        this.staff = staff;
    }
}
