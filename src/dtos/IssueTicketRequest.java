package dtos;

import models.Ticket;
import models.VehicleType;

public class IssueTicketRequest {

    private VehicleType vehicleType;
    private String vehicleNumber;
    private String ownerName;
    private long gateId;
    private Long parkingLotId;

    public IssueTicketRequest(VehicleType vehicleType, String vehicleNumber, String ownerName, long gateId, Long parkingLotId) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.gateId = gateId;
        this.parkingLotId = parkingLotId;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getGateId() {
        return gateId;
    }

    public void setGateId(long gateId) {
        this.gateId = gateId;
    }
}
