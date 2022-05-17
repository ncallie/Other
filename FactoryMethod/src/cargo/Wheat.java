package cargo;

public class Wheat implements Cargo{
    private String type;

    public Wheat() {
        this.type = "Wheat";
    }

    @Override
    public String getType() {
        return type;
    }
}
