package menu;

import command.*;
import io.NecklaceIO;
import stones.Stone;
import necklace.Necklace;
import stones.PreciousStone;
import stones.SemiPreciousStone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MenuTest {

    private Menu menu;
    private Necklace necklace;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        menu = new Menu();
        necklace = menu.getNecklace();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testAddPreciousStone() {
        String input = "Diamond\n1.5\n1000\n0.8\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.addStone(true);

        assertEquals(1, necklace.getStones().size());
        assertTrue(necklace.getStones().get(0) instanceof PreciousStone);
        assertEquals("Diamond", necklace.getStones().get(0).getName());
    }

    @Test
    public void testAddSemiPreciousStone() {
        String input = "Opal\n2.0\n500\n0.6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.addStone(false);

        assertEquals(1, necklace.getStones().size());
        assertTrue(necklace.getStones().get(0) instanceof SemiPreciousStone);
        assertEquals("Opal", necklace.getStones().get(0).getName());
    }

    @Test
    public void testCalculateTotalWeight() {
        necklace.addStone(new PreciousStone("Ruby", 1.0, 1000, 0.7));
        necklace.addStone(new SemiPreciousStone("Opal", 1.5, 500, 0.6));

        double totalWeight = menu.getNecklace().calculateTotalWeight();
        assertEquals(2.5, totalWeight);
    }

    @Test
    public void testCalculateTotalCost() {
        necklace.addStone(new PreciousStone("Ruby", 1.0, 1000, 0.7));
        necklace.addStone(new SemiPreciousStone("Opal", 1.5, 500, 0.6));

        double totalCost = menu.getNecklace().calculateTotalCost();
        assertEquals(1500, totalCost);
    }

    @Test
    public void testFindStonesByTransparency() {
        necklace.addStone(new PreciousStone("Ruby", 1.0, 1000, 0.7));
        necklace.addStone(new SemiPreciousStone("Opal", 1.5, 500, 0.6));

        String input = "0.5\n0.8\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.findStonesByTransparency();

        String output = outContent.toString();
        assertTrue(output.contains("Ruby"));
        assertTrue(output.contains("Opal"));
    }

    @Test
    public void testSortStonesByCost() {
        necklace.addStone(new PreciousStone("Ruby", 1.0, 1000, 0.7));
        necklace.addStone(new SemiPreciousStone("Opal", 1.5, 500, 0.6));

        menu.displaySortedStones();

        String output = outContent.toString();
        assertTrue(output.contains("Opal"));
        assertTrue(output.contains("Ruby"));
    }

    @Test
    public void testGetValidInput() {
        String input = "3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(3, menu.getValidInput(new java.util.Scanner(System.in)));
    }

    @Test
    public void testGetValidDoubleInput() {
        String input = "2.5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(2.5, menu.getValidDoubleInput(new java.util.Scanner(System.in)));
    }

    @Test
    public void testSaveAndLoadNecklace() {
        necklace.addStone(new PreciousStone("Ruby", 1.0, 1000, 0.7));
        necklace.addStone(new SemiPreciousStone("Opal", 1.5, 500, 0.6));

        menu.saveNecklace();
        necklace.getStones().clear();

        assertEquals(0, necklace.getStones().size());

        menu.loadNecklace();
        assertEquals(2, necklace.getStones().size());
    }

    @Test
    public void testInvalidInputInMenu() {
        String input = "10\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        menu.showMenu();

        String output = outContent.toString();
        assertTrue(output.contains("Помилка: Введіть число від 0 до 8."));
    }

    @Test
    public void testSaveNecklace() {
        necklace.addStone(new PreciousStone("Diamond", 1.5, 1000, 0.8));

        assertDoesNotThrow(() -> menu.saveNecklace());
    }


    @Test
    public void testLoadNecklace() {
        necklace.addStone(new PreciousStone("Emerald", 2.0, 1500, 0.9));

        menu.saveNecklace();

        necklace.getStones().clear();

        assertDoesNotThrow(() -> menu.loadNecklace());

        assertEquals(1, necklace.getStones().size());
        assertEquals("Emerald", necklace.getStones().get(0).getName());
    }
}
