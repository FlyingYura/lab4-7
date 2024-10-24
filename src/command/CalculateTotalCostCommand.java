package command;

import menu.Menu;

public class CalculateTotalCostCommand implements Command {
    private Menu menu;

    public CalculateTotalCostCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        System.out.println("Загальна вартість: $" + menu.getNecklace().calculateTotalCost());
    }
}
