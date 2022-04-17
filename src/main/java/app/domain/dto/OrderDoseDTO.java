package app.domain.dto;

public class OrderDoseDTO {

    private int currentDose;
    private int timeNextDose;

    public OrderDoseDTO(int currentDose, int timeNextDose) {
        this.currentDose = currentDose;
        this.timeNextDose = timeNextDose;
    }

    public int getCurrentDose() {
        return currentDose;
    }

    public void setCurrentDose(int currentDose) {
        this.currentDose = currentDose;
    }

    public int getTimeNextDose() {
        return timeNextDose;
    }

    public void setTimeNextDose(int timeNextDose) {
        this.timeNextDose = timeNextDose;
    }


}
