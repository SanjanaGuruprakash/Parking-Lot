package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Long previousId=0l;
    Map<String, Vehicle> vehicleMap = new HashMap<>();
    public Vehicle getVehicleByNumber(String vehicleNumber) {
        if(vehicleMap.containsKey(vehicleNumber)){
            return vehicleMap.get(vehicleNumber);
        }
        return null;

    }

    public Vehicle save(Vehicle vehicle) {
        previousId++;
        vehicle.setId(previousId);
        vehicleMap.putIfAbsent(vehicle.getVehicleNumber(), vehicle);
        return vehicleMap.get(vehicle.getVehicleNumber());
    }
}
