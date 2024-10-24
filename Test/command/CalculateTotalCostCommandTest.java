package command;

import menu.Menu;
import necklace.Necklace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CalculateTotalCostCommandTest {

    private Menu menu;
    private Necklace necklace;
    private CalculateTotalCostCommand command;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        necklace = mock(Necklace.class);
        when(menu.getNecklace()).thenReturn(necklace);
        command = new CalculateTotalCostCommand(menu);
    }

    @Test
    public void testExecute() {
        command.execute();
        verify(menu).getNecklace();
        verify(necklace).calculateTotalCost();
    }
}
