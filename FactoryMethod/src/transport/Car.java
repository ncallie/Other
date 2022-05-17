package transport;

import cargo.Cargo;

public class Car implements Transport{
    private Cargo cargo;

    public Car(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public void deliver() {
        System.out.println("Overland delivery..." + cargo.getType());
    }
}
