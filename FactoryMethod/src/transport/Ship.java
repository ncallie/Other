package transport;

import cargo.Cargo;

public class Ship implements Transport{
    private Cargo cargo;

    public Ship(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public void deliver() {
        System.out.println("Shipping by sea..." + cargo.getType());
    }
}
