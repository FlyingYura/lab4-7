package main;

import menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MainTest {

    private Menu mockMenu;

    @BeforeEach
    public void setUp() {
        mockMenu = mock(Menu.class);
    }

    @Test
    public void testMainMethod() {
        Main main = new Main(mockMenu);
        main.run();

        verify(mockMenu, times(1)).showMenu();
    }
}
