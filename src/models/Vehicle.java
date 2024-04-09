package models;

public class Vehicle extends BaseModel{
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String ownerName;

    public Vehicle(VehicleType vehicleType, String ownerName, String vehicleNumber) {
        this.vehicleNumber=vehicleNumber;
        this.vehicleType = vehicleType;
        this.ownerName=ownerName;
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
}
