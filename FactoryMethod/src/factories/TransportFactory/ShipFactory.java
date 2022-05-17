package factories.TransportFactory;

import cargo.Cargo;
import factories.TransportFactory.TransportFactory;
import transport.Ship;
import transport.Transport;

public class ShipFactory implements TransportFactory {
    @Override
    public Transport createTransport(Cargo cargo) {
        return new Ship(cargo);
    }
}
