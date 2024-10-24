package command;

import menu.Menu;

public class SortStonesByCostCommand implements Command {
    private Menu menu;

    public SortStonesByCostCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.displaySortedStones();
    }
}
