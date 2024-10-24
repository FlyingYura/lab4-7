package command;

import menu.Menu;

public class AddSemiPreciousStoneCommand implements Command {
    private Menu menu;

    public AddSemiPreciousStoneCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.addStone(false);
    }
}
