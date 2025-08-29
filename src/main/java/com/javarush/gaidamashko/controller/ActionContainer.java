package com.javarush.gaidamashko.controller;

import com.javarush.gaidamashko.command.*;
import com.javarush.gaidamashko.exception.AppException;

public enum ActionContainer {
    ENCRYPT(new Encrypt()),
    DECRYPT(new Decrypt()),
    BRUTEFORCE(new BruteForce()),
    EXIT(new Exit());

    private final Action action;

    ActionContainer(Action action) {
        this.action = action;
    }

    public static Action getAction(String actionName) {
        ActionContainer value;
        try {
            value = ActionContainer.valueOf(actionName.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new AppException("Action \"" + actionName + "\" not found", e);
        }
        return value.action;
    }
}
