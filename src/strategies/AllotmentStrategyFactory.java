package strategies;

public class AllotmentStrategyFactory {

    public static AllotmentStrategy getParkingAllotmentStrategyForType(
            AllotmentStrategy allotmentStrategy){
        return new SimpleAllotmentStrategy();
    }

}
