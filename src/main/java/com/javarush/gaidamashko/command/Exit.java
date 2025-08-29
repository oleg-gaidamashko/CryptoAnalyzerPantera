package com.javarush.gaidamashko.command;

import com.javarush.gaidamashko.consts.Consts;
import com.javarush.gaidamashko.data.Result;
import com.javarush.gaidamashko.data.ResultCode;

public class Exit  extends BaseAction{

    @Override
    public Result execute(String[] parameters) {
        return new Result(ResultCode.OK, Consts.APPLICATION_CLOSED);
    }
}
