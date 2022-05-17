package factories.TransportFactory;

import cargo.Cargo;
import transport.Transport;

public interface TransportFactory {
    Transport createTransport(Cargo cargo);
    public enum Type {
        CAR,
        SHIP
    }
}
