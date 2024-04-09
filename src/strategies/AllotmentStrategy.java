package strategies;

import exceptions.ParkingLotFullException;
import models.ParkingSlot;
import models.VehicleType;

public interface AllotmentStrategy {

    ParkingSlot getParkingSlot(VehicleType vehicleType, Long parkingLotId)
            throws ParkingLotFullException;
}
