package command;

import menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

public class FindStonesByTransparencyCommandTest {

    private Menu menu;
    private FindStonesByTransparencyCommand findStonesByTransparencyCommand;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        findStonesByTransparencyCommand = new FindStonesByTransparencyCommand(menu);
    }

    @Test
    public void testExecute() {
        String input = "0.4\n0.9\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        findStonesByTransparencyCommand.execute();
        verify(menu).findStonesByTransparency();
    }
}
