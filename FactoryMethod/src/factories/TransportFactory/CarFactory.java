package factories.TransportFactory;

import cargo.Cargo;
import factories.TransportFactory.TransportFactory;
import transport.Car;
import transport.Transport;

public class CarFactory implements TransportFactory {
    @Override
    public Transport createTransport(Cargo cargo) {
        return new Car(cargo);
    }
}
