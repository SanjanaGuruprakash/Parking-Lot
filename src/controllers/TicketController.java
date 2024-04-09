package controllers;

import dtos.IssueTicketRequest;
import dtos.IssueTicketResponse;
import dtos.ResponseStatus;
import exceptions.GateNotFoundException;
import exceptions.ParkingLotFullException;
import exceptions.ParkingLotNotFoundException;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private static final String INVALID_PARKING_LOT = "Parking Lot not found";
    public static final String TICKET_ISSUED_MESSAGE = "Ticket Issued";
    public static final String INVALID_GATE = "Gate is not valid";
    private static final String PARKING_LOT_FULL = "Parking Lot is Full, please find parking space on the road";
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponse issueTicket(IssueTicketRequest ticketRequest){

        Ticket ticket = null;
        try {
            ticket = ticketService.issueTicket(ticketRequest);
        } catch (GateNotFoundException e) {
            return new IssueTicketResponse(null, ResponseStatus.FAILURE, INVALID_GATE);
        } catch (ParkingLotNotFoundException e) {
            return new IssueTicketResponse(null, ResponseStatus.FAILURE, INVALID_PARKING_LOT);
        } catch (ParkingLotFullException e) {
            return new IssueTicketResponse(null, ResponseStatus.FAILURE, PARKING_LOT_FULL);
        }
        return new IssueTicketResponse(ticket, ResponseStatus.SUCCESS, TICKET_ISSUED_MESSAGE);
    }
}
