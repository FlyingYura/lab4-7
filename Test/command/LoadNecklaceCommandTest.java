package command;

import menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LoadNecklaceCommandTest {

    private Menu menu;
    private LoadNecklaceCommand loadNecklaceCommand;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        loadNecklaceCommand = new LoadNecklaceCommand(menu);
    }

    @Test
    public void testExecute() {
        loadNecklaceCommand.execute();
        verify(menu).loadNecklace();
    }
}
