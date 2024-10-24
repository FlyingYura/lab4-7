package menu;

import command.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MenuInvokerTest {

    private MenuInvoker menuInvoker;
    private Command mockCommand;

    @BeforeEach
    public void setUp() {
        menuInvoker = new MenuInvoker();
        mockCommand = mock(Command.class);
    }

    @Test
    public void testSetCommandAndExecuteCommand_ValidOption() {
        menuInvoker.setCommand(1, mockCommand);

        menuInvoker.executeCommand(1);

        verify(mockCommand, times(1)).execute();
    }

    @Test
    public void testExecuteCommand_InvalidOption() {
        menuInvoker.executeCommand(2);

        verify(mockCommand, never()).execute();
    }

    @Test
    public void testSetMultipleCommandsAndExecute() {
        Command mockCommand2 = mock(Command.class);
        menuInvoker.setCommand(1, mockCommand);
        menuInvoker.setCommand(2, mockCommand2);

        menuInvoker.executeCommand(1);
        verify(mockCommand, times(1)).execute();

        menuInvoker.executeCommand(2);
        verify(mockCommand2, times(1)).execute();
    }
}
