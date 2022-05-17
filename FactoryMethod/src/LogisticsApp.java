import cargo.Cargo;
import factories.CargoFactory.CargoFactory;
import factories.TransportFactory.TransportFactory;
import transport.Transport;

public class LogisticsApp {
    public static void main(String[] args) {
        CargoFactory cargoFactory = Logistics.createCargo(CargoFactory.Type.WHEAT);
        Cargo cargo = cargoFactory.createCargo();

        TransportFactory transportFactory = Logistics.createTransport(TransportFactory.Type.SHIP);
        Transport transport = transportFactory.createTransport(cargo);
        transport.deliver();
    }
}
