package factories.CargoFactory;

import cargo.Cargo;
import cargo.Oil;

public class OilFactory implements CargoFactory{
    @Override
    public Cargo createCargo() {
        return new Oil();
    }
}
