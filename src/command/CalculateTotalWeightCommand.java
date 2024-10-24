package command;

import menu.Menu;

public class CalculateTotalWeightCommand implements Command {
    private Menu menu;

    public CalculateTotalWeightCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        System.out.println("Загальна вага: " + menu.getNecklace().calculateTotalWeight() + " карат");
    }
}
