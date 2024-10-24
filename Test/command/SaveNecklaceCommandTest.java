package command;

import menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class SaveNecklaceCommandTest {

    private Menu menu;
    private SaveNecklaceCommand saveNecklaceCommand;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        saveNecklaceCommand = new SaveNecklaceCommand(menu);
    }

    @Test
    public void testExecute() {
        saveNecklaceCommand.execute();
        verify(menu).saveNecklace();
    }
}
