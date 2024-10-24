package io;

import necklace.Necklace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stones.Stone;
import stones.PreciousStone;
import stones.SemiPreciousStone;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NecklaceIOTest {

    private Necklace necklace;
    private Stone stone1, stone2;
    private final String fileName = "C:/Users/proko/Desktop/log_test.txt";

    @BeforeEach
    void setUp() {
        necklace = new Necklace();
        stone1 = new PreciousStone("Diamond", 5.0, 500.0, 0.95);
        stone2 = new SemiPreciousStone("Ruby", 3.0, 300.0, 0.85);

        necklace.addStone(stone1);
        necklace.addStone(stone2);
    }

    @Test
    void testSaveToFile() throws IOException {
        new File(fileName).delete();

        assertDoesNotThrow(() -> {
            NecklaceIO.saveToFile(necklace, fileName);
        });

        File savedFile = new File(fileName);
        assertTrue(savedFile.exists(), "File should be created after saving");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedFile))) {
            Stone readStone1 = (Stone) ois.readObject();
            assertEquals("Diamond", readStone1.getName());
            assertEquals(5.0, readStone1.getWeight());
            assertEquals(500.0, readStone1.getCost());
            assertEquals(0.95, readStone1.getTransparency());

            Stone readStone2 = (Stone) ois.readObject();
            assertEquals("Ruby", readStone2.getName());
            assertEquals(3.0, readStone2.getWeight());
            assertEquals(300.0, readStone2.getCost());
            assertEquals(0.85, readStone2.getTransparency());
        } catch (EOFException | ClassNotFoundException e) {
        }
    }

    @Test
    void testLoadFromFile() throws IOException, ClassNotFoundException {
        NecklaceIO.saveToFile(necklace, fileName);

        Necklace loadedNecklace = new Necklace();

        assertDoesNotThrow(() -> {
            NecklaceIO.loadFromFile(loadedNecklace, fileName);
        });

        assertEquals(2, loadedNecklace.getStones().size(), "Loaded necklace should contain 2 stones");

        assertEquals("Diamond", loadedNecklace.getStones().get(0).getName());
        assertEquals(5.0, loadedNecklace.getStones().get(0).getWeight());
        assertEquals(500.0, loadedNecklace.getStones().get(0).getCost());
        assertEquals(0.95, loadedNecklace.getStones().get(0).getTransparency());

        assertEquals("Ruby", loadedNecklace.getStones().get(1).getName());
        assertEquals(3.0, loadedNecklace.getStones().get(1).getWeight());
        assertEquals(300.0, loadedNecklace.getStones().get(1).getCost());
        assertEquals(0.85, loadedNecklace.getStones().get(1).getTransparency());
    }
}
