package command;

import menu.Menu;

public class FindStonesByTransparencyCommand implements Command {
    private Menu menu;

    public FindStonesByTransparencyCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.findStonesByTransparency();
    }
}
