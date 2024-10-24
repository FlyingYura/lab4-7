package command;

import menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SortStonesByCostCommandTest {

    private Menu menu;
    private SortStonesByCostCommand command;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        command = new SortStonesByCostCommand(menu);
    }

    @Test
    public void testExecute() {
        command.execute();
        verify(menu).displaySortedStones();
    }
}
