package com.javarush.gaidamashko.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final String MESSAGE_SELECT_MODE = "Please select mode:";
    private static final String INCORRECT_SELECTION = "Incorrect selection.";
    private final Scanner console;
    private final MenuItem[] items = new MenuItem[]{
            new MenuItem("Encrypt", 1,
                    new MenuQuest[]{
                            new MenuQuest("Enter source (full path OR only filename OR Enter for text.txt) :",
                                    "text.txt"),
                            new MenuQuest("Enter destination (full path OR only filename OR Enter for encrypted.txt) :",
                                    "encrypted.txt"),
                            new MenuQuest("Enter key (int number OR Enter for key=1) :",
                                    "1")}),
            new MenuItem("Decrypt", 2,
                    new MenuQuest[]{
                            new MenuQuest("Enter source (full path OR only filename OR Enter for encrypted.txt) :",
                                    "encrypted.txt"),
                            new MenuQuest("Enter destination (full path OR only filename OR Enter for decrypted.txt) :",
                                    "decrypted.txt"),
                            new MenuQuest("Enter key (int number OR Enter for key=1) :",
                                    "1")}),
            new MenuItem("BruteForce", 3,
                    new MenuQuest[]{
                            new MenuQuest("Enter source (full path OR only filename OR Enter for encrypted.txt) :",
                                    "encrypted.txt"),
                            new MenuQuest("Enter destination (full path OR only filename OR Enter for bruteforced.txt) :",
                                    "bruteforced.txt")}),
            new MenuItem("Exit", 4),
    };

    public Menu(Scanner console) {
        this.console = console;
    }

    public String[] getArgs() {
        List<String> res = new ArrayList<>();
        int mode = getMode();
        res.add(items[mode].code.toLowerCase());
        if (items[mode].quests != null) {
            for (int i = 0; i < items[mode].quests.length; i++) {
                MenuQuest quest = items[mode].quests[i];
                res.add(getArg(quest.quest, quest.defaultValue));
            }
        }
        return res.toArray(new String[0]);
    }

    private String getArg(String quest, String def) {
        System.out.println(quest);
        String answer = console.nextLine();
        return answer.trim().isEmpty() ? def : answer;
    }

    private int getMode() {
        int mode;
        do {
            System.out.println(MESSAGE_SELECT_MODE);
            for (MenuItem item : items) {
                System.out.println(item.num + "." + item.code);
            }
            String input = console.nextLine();
            mode = switch (input) {
                case "1" -> 0;
                case "2" -> 1;
                case "3" -> 2;
                default -> {
                    System.out.println(INCORRECT_SELECTION);
                    yield -1;
                }
            };
        } while (mode < 0);
        return mode;
    }
}
