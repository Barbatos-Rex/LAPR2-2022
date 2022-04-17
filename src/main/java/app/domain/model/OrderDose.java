package app.domain.model;

import app.domain.dto.OrderDoseDTO;
import app.domain.shared.DTOable;

public class OrderDose implements DTOable<OrderDoseDTO> {
    private final int currentDose;
    private final int timeNextDose;

    public OrderDose(int currentDose, int timeNextDose) {
        this.currentDose = currentDose;
        this.timeNextDose = timeNextDose;
    }

    public int getCurrentDose() {
        return currentDose;
    }

    public int getTimeNextDose() {
        return timeNextDose;
    }

    @Override
    public String toString() {
        return "OrderDose{" +
                "currentDose=" + currentDose +
                ", timeNextDose=" + timeNextDose +
                '}';
    }

    @Override
    public OrderDoseDTO toDTO() {
        return new OrderDoseDTO(currentDose, timeNextDose);
    }
}
