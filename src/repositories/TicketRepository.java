package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    Map<Long, Ticket> ticketMap = new HashMap<>();
    Long previousId=0L;
    public Ticket save(Ticket ticket){
        previousId++;
        ticketMap.putIfAbsent(previousId,ticket);
        return ticket;
    }
}
