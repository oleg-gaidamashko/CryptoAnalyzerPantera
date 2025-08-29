package com.javarush.gaidamashko.view;

public class MenuItem {
    public final String code;
    public final int num;
    public final MenuQuest[] quests;



    public MenuItem(String code, int num) {
        this(code, num, null);
    }

    public MenuItem(String code, int num, MenuQuest[] quests) {
        this.code = code;
        this.num = num;
        this.quests = quests;
    }
}
