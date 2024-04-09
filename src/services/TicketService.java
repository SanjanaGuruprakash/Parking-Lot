package services;

import dtos.IssueTicketRequest;
import exceptions.GateNotFoundException;
import exceptions.ParkingLotFullException;
import exceptions.ParkingLotNotFoundException;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategies.AllotmentStrategy;
import strategies.AllotmentStrategyFactory;

import java.util.Date;
import java.util.UUID;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRespository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRespository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRespository = ticketRespository;

    }

    public Ticket issueTicket(IssueTicketRequest ticketRequest) throws GateNotFoundException,
            ParkingLotNotFoundException, ParkingLotFullException {

        //set the time
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        //get gate details
        Gate gate = gateRepository.findGateByGateId(ticketRequest.getGateId());
        ticket.setEntryGate(gate);

        // set vehicle
        Vehicle vehicle = getVehicleFromNumber(ticketRequest);
        ticket.setVehicle(vehicle);

        //get parkingLot
        ParkingSlot parkingSlot = getParkingSlot(ticketRequest);
        ticket.setParkingSlot(parkingSlot);

        ticket.setNumber(ticketRequest.getOwnerName()+UUID.randomUUID());

        return ticketRespository.save(ticket);

    }

    private ParkingSlot getParkingSlot(IssueTicketRequest ticketRequest) throws
            ParkingLotNotFoundException, ParkingLotFullException {
        ParkingLot parkingLot = parkingLotRepository.getParkingLotById
                (ticketRequest.getParkingLotId());

        AllotmentStrategy allotmentStrategy = parkingLot.getAllotmentStrategy();
        AllotmentStrategy parkingAllotmentRule = AllotmentStrategyFactory.
                getParkingAllotmentStrategyForType(allotmentStrategy);

        return parkingAllotmentRule.getParkingSlot(ticketRequest.getVehicleType(),
                ticketRequest.getParkingLotId());
    }

    private Vehicle getVehicleFromNumber(IssueTicketRequest ticketRequest) {
        Vehicle vehicle = vehicleRepository.getVehicleByNumber
                (ticketRequest.getVehicleNumber());
        if(vehicle==null){
            vehicle = new Vehicle(ticketRequest.getVehicleType(),
                    ticketRequest.getOwnerName(),
                    ticketRequest.getVehicleNumber());
            vehicleRepository.save(vehicle);
        }
        return vehicle;
    }

}
