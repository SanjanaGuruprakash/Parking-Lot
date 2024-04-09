package repositories;

import dtos.IssueTicketRequest;
import exceptions.GateNotFoundException;
import models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    Map<Long, Gate> gateMap = new HashMap<>();
    public Gate findGateByGateId(Long gateId) throws GateNotFoundException {
        if(gateMap.containsKey(gateId)){
            return gateMap.get(gateId);
        }
        else{
            throw new GateNotFoundException();
        }


    }
}
