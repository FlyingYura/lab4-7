package stones;

public class SemiPreciousStone extends Stone {

    public SemiPreciousStone(String name, double weight, double cost, double transparency) {
        super(name, weight, cost, transparency);
    }

    @Override
    public String getType() {
        return "Напівкоштовний";
    }
}
