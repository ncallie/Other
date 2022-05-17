package factories.CargoFactory;

import cargo.Cargo;

public interface CargoFactory {
    Cargo createCargo();
    public enum Type{
        OIL,
        WHEAT
    }
}
