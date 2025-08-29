package com.javarush.gaidamashko;

import com.javarush.gaidamashko.controller.MainController;
import com.javarush.gaidamashko.view.ConsoleApp;
import com.javarush.gaidamashko.view.Menu;

import java.util.Scanner;

public class ConsoleRunner {
    /**
     * run console app
     */

    public static void main(String[] args) {
        MainController controller = new MainController();
        Scanner console = new Scanner(System.in);
        Menu menu = new Menu(console);
        ConsoleApp app = new ConsoleApp(controller,menu);
        app.run(args);
    }
}