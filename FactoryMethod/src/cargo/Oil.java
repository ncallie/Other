package cargo;

public class Oil implements Cargo{
    private String type;

    public Oil() {
        this.type = "Oil";
    }

    @Override
    public String getType() {
        return type;
    }
}
