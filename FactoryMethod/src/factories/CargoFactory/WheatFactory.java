package factories.CargoFactory;

import cargo.Cargo;
import cargo.Wheat;

public class WheatFactory implements CargoFactory{
    @Override
    public Cargo createCargo() {
        return new Wheat();
    }
}
