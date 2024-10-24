package command;

import menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddPreciousStoneCommandTest {

    private Menu menu;
    private AddPreciousStoneCommand addPreciousStoneCommand;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        addPreciousStoneCommand = new AddPreciousStoneCommand(menu);
    }

    @Test
    public void testExecute() {
        String input = "Diamond\n1.5\n1000\n0.8\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        addPreciousStoneCommand.execute();
        verify(menu).addStone(true);
    }
}
