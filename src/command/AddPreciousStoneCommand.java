package command;

import menu.Menu;

public class AddPreciousStoneCommand implements Command {
    private Menu menu;

    public AddPreciousStoneCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.addStone(true);
    }
}
