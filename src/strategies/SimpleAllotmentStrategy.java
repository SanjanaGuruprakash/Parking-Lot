package strategies;

import exceptions.ParkingLotFullException;
import models.ParkingSlot;
import models.VehicleType;

public class SimpleAllotmentStrategy implements AllotmentStrategy {
    @Override
    public ParkingSlot getParkingSlot(VehicleType vehicleType, Long parkingLotId) {

        //get all the floors of this parking lot that are free
        // go through the floors and get the slot that is free for the vehicle type
        return null;
    }
}
