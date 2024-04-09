package App;

import controllers.TicketController;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;

public class AppRunner {
    public static void main(String[] args) {
        // Since we are not using Spring, we need to create all repo and service on own
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,parkingLotRepository,ticketRepository);

        TicketController ticketController = new TicketController(ticketService);


    }
}
