package com.javarush.gaidamashko.controller;

import com.javarush.gaidamashko.command.Action;
import com.javarush.gaidamashko.data.Result;
import com.javarush.gaidamashko.data.ResultCode;
import com.javarush.gaidamashko.exception.AppException;

public class MainController {
    public Result execAction(String actionName, String[] params) {
        Action action = ActionContainer.getAction(actionName);
        try {
            return action.execute(params);
        } catch (AppException e) {
            return new Result(ResultCode.ERROR,e.getMessage());
        }
    }
}
