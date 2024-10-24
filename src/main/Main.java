package main;

import menu.Menu;

public class Main {
    private Menu menu;

    public Main(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        menu.showMenu();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Main main = new Main(menu);
        main.run();
    }
}
