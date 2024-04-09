package model;


import LLD3.ParkingLot.strategies.AllotmentStrategy;
import LLD3.ParkingLot.strategies.BillingStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> floors;
    private List<Gate> gates;
    private ParkingLotStatus lotStatus;

    private AllotmentStrategy allotmentStrategy;
    private BillingStrategy billingStrategy;

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getLotStatus() {
        return lotStatus;
    }

    public void setLotStatus(ParkingLotStatus lotStatus) {
        this.lotStatus = lotStatus;
    }
}
