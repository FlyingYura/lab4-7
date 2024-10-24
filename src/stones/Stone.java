package stones;

import java.io.Serializable;

public abstract class Stone implements Serializable {
    private String name;
    private double weight;
    private double cost;
    private double transparency;

    public Stone(String name, double weight, double cost, double transparency) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.transparency = transparency;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getCost() {
        return cost;
    }

    public double getTransparency() {
        return transparency;
    }

    public abstract String getType();
}
