package command;

import menu.Menu;
import necklace.Necklace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CalculateTotalWeightCommandTest {

    private Menu menu;
    private Necklace necklace;
    private CalculateTotalWeightCommand calculateTotalWeightCommand;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        necklace = mock(Necklace.class);
        when(menu.getNecklace()).thenReturn(necklace);
        calculateTotalWeightCommand = new CalculateTotalWeightCommand(menu);
    }

    @Test
    public void testExecute() {
        calculateTotalWeightCommand.execute();

        verify(menu).getNecklace();
        verify(necklace).calculateTotalWeight();
    }
}
