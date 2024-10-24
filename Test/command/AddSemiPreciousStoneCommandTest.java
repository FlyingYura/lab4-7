package command;

import menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.mockito.Mockito.*;

public class AddSemiPreciousStoneCommandTest {

    private Menu menu;
    private AddSemiPreciousStoneCommand addSemiPreciousStoneCommand;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        addSemiPreciousStoneCommand = new AddSemiPreciousStoneCommand(menu);
    }

    @Test
    public void testExecute() {
        String input = "Opal\n1.2\n300\n0.5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        addSemiPreciousStoneCommand.execute();
        verify(menu).addStone(false);
    }
}
