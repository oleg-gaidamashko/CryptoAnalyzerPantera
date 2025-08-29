package com.javarush.gaidamashko.view;

import com.javarush.gaidamashko.controller.MainController;
import com.javarush.gaidamashko.data.Result;
import com.javarush.gaidamashko.data.ResultCode;

import java.util.Arrays;

public class ConsoleApp {
    private final MainController controller;
    private final Menu menu;

    public ConsoleApp(MainController controller, Menu menu) {
        this.controller = controller;
        this.menu = menu;
    }

    public void run(String[] args) {
        if (args.length == 0) {
            args = menu.getArgs();
        }
        Result result = getResult(args);
        System.out.println(result);
    }

    private Result getResult(String[] args) {
        String actionName = args[0];
        String[] params = Arrays.copyOfRange(args, 1, args.length);
        return controller.execAction(actionName, params);
    }
}
