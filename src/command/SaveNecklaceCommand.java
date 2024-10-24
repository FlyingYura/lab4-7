package command;

import menu.Menu;

public class SaveNecklaceCommand implements Command {
    private Menu menu;

    public SaveNecklaceCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.saveNecklace();
    }
}
