package stones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StoneTest {

    private TestStone stone;

    @BeforeEach
    void setUp() {
        stone = new TestStone("Ruby", 2.5, 1000, 0.8);
    }

    @Test
    void testGetName() {
        assertEquals("Ruby", stone.getName());
    }

    @Test
    void testGetWeight() {
        assertEquals(2.5, stone.getWeight());
    }

    @Test
    void testGetCost() {
        assertEquals(1000, stone.getCost());
    }

    @Test
    void testGetTransparency() {
        assertEquals(0.8, stone.getTransparency());
    }

    @Test
    void testGetType() {
        assertEquals("TestType", stone.getType());
    }

    @Test
    void testSetNameTestStone() {
        TestStone mockStone = mock(TestStone.class);
        when(mockStone.getName()).thenReturn("Emerald");

        assertEquals("Emerald", mockStone.getName());
        verify(mockStone).getName();
    }

    @Test
    void testSetNamePreciousStone() {
        PreciousStone preciousStone = new PreciousStone("Emerald", 2.0, 1500, 0.85);
        assertEquals("Emerald", preciousStone.getName());
        assertEquals("Дорогоцінний", preciousStone.getType());
    }

    @Test
    void testSetNameSemiPreciousStone() {
        SemiPreciousStone semiPreciousStone = new SemiPreciousStone("Amethyst", 1.5, 300, 0.75);
        assertEquals("Amethyst", semiPreciousStone.getName());
        assertEquals("Напівкоштовний", semiPreciousStone.getType());
    }

    @Test
    void testSetWeightUsingMockito() {
        TestStone mockStone = mock(TestStone.class);
        when(mockStone.getWeight()).thenReturn(3.0);

        assertEquals(3.0, mockStone.getWeight());
        verify(mockStone).getWeight();
    }

    @Test
    void testPreciousStoneConstructor() {
        PreciousStone preciousStone = new PreciousStone("Diamond", 3.0, 10000, 0.9);
        assertEquals("Diamond", preciousStone.getName());
        assertEquals(3.0, preciousStone.getWeight());
        assertEquals(10000, preciousStone.getCost());
        assertEquals(0.9, preciousStone.getTransparency());
        assertEquals("Дорогоцінний", preciousStone.getType());
    }

    @Test
    void testSemiPreciousStoneConstructor() {
        SemiPreciousStone semiPreciousStone = new SemiPreciousStone("Citrine", 2.0, 600, 0.8);
        assertEquals("Citrine", semiPreciousStone.getName());
        assertEquals(2.0, semiPreciousStone.getWeight());
        assertEquals(600, semiPreciousStone.getCost());
        assertEquals(0.8, semiPreciousStone.getTransparency());
        assertEquals("Напівкоштовний", semiPreciousStone.getType());
    }
}
