package command;

import menu.Menu;

public class LoadNecklaceCommand implements Command {
    private Menu menu;

    public LoadNecklaceCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.loadNecklace();
    }
}
