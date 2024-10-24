package necklace;

import org.junit.Before;
import org.junit.Test;
import stones.PreciousStone;
import stones.SemiPreciousStone;
import stones.Stone;

import static org.junit.Assert.*;

import java.util.List;

public class NecklaceTest {

    private Necklace necklace;

    @Before
    public void setUp() {
        necklace = new Necklace();
    }

    @Test
    public void testAddStone() {
        Stone stone = new PreciousStone("Diamond", 1.5, 1000, 0.9);
        necklace.addStone(stone);
        assertEquals(1, necklace.getStones().size());
    }

    @Test
    public void testCalculateTotalWeight() {
        necklace.addStone(new PreciousStone("Diamond", 1.5, 1000, 0.9));
        necklace.addStone(new SemiPreciousStone("Amethyst", 2.0, 200, 0.7));
        assertEquals(3.5, necklace.calculateTotalWeight(), 0.001);
    }

    @Test
    public void testCalculateTotalCost() {
        necklace.addStone(new PreciousStone("Diamond", 1.5, 1000, 0.9));
        necklace.addStone(new SemiPreciousStone("Amethyst", 2.0, 200, 0.7));
        assertEquals(1200, necklace.calculateTotalCost(), 0.001);
    }

    @Test
    public void testSortStonesByCost() {
        PreciousStone diamond = new PreciousStone("Diamond", 1.5, 1000, 0.9);
        SemiPreciousStone amethyst = new SemiPreciousStone("Amethyst", 2.0, 200, 0.7);
        necklace.addStone(diamond);
        necklace.addStone(amethyst);

        necklace.sortStonesByCost();

        List<Stone> stones = necklace.getStones();
        assertEquals(amethyst, stones.get(0));
        assertEquals(diamond, stones.get(1));
    }

    @Test
    public void testFindStonesByTransparency() {
        PreciousStone diamond = new PreciousStone("Diamond", 1.5, 1000, 0.9);
        SemiPreciousStone amethyst = new SemiPreciousStone("Amethyst", 2.0, 200, 0.7);
        SemiPreciousStone topaz = new SemiPreciousStone("Topaz", 1.0, 300, 0.5);

        necklace.addStone(diamond);
        necklace.addStone(amethyst);
        necklace.addStone(topaz);

        List<Stone> foundStones = necklace.findStonesByTransparency(0.5, 0.8);
        assertEquals(2, foundStones.size());
        assertEquals(amethyst, foundStones.getFirst());
        foundStones = necklace.findStonesByTransparency(0.5, 0.9);
        assertEquals(3, foundStones.size());
    }
}
