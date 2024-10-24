package necklace;

import stones.Stone;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Necklace {
    private List<Stone> stones = new ArrayList<>();

    public void addStone(Stone stone) {
        stones.add(stone);
    }

    public double calculateTotalWeight() {
        return stones.stream().mapToDouble(Stone::getWeight).sum();
    }

    public double calculateTotalCost() {
        return stones.stream().mapToDouble(Stone::getCost).sum();
    }

    public void sortStonesByCost() {
        Collections.sort(stones, Comparator.comparing(Stone::getCost));
    }

    public List<Stone> getStones() {
        return stones;
    }
    public List<Stone> findStonesByTransparency(double minTransparency, double maxTransparency) {
        List<Stone> result = new ArrayList<>();
        for (Stone stone : stones) {
            if (stone.getTransparency() >= minTransparency && stone.getTransparency() <= maxTransparency) {
                result.add(stone);
            }
        }
        return result;
    }
}
