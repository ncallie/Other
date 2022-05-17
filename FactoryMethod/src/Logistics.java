import factories.CargoFactory.CargoFactory;
import factories.CargoFactory.OilFactory;
import factories.CargoFactory.WheatFactory;
import factories.TransportFactory.CarFactory;
import factories.TransportFactory.ShipFactory;
import factories.TransportFactory.TransportFactory;

public class Logistics {
    private Logistics() {
    }
    public static TransportFactory createTransport(TransportFactory.Type type) {
        switch (type) {
            case SHIP:
                return new ShipFactory();
            case CAR:
                return new CarFactory();
            default:
                throw new RuntimeException("Unknown transport type");
        }
    }
    public static CargoFactory createCargo(CargoFactory.Type type) {
        switch (type) {
            case OIL:
                return new OilFactory();
            case WHEAT:
                return new WheatFactory();
            default:
                throw new RuntimeException("Unknown cargo type");
        }
    }
}
