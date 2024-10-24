package stones;

public class TestStone extends Stone {
    public TestStone(String name, double weight, double cost, double transparency) {
        super(name, weight, cost, transparency);
    }

    @Override
    public String getType() {
        return "TestType";
    }
}
