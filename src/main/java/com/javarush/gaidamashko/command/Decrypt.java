package com.javarush.gaidamashko.command;

import com.javarush.gaidamashko.consts.Consts;
import com.javarush.gaidamashko.data.Result;
import com.javarush.gaidamashko.data.ResultCode;

public class Decrypt extends BaseAction{

    @Override
    public Result execute(String[] parameters) {
        String sourceFileName = parameters[0];
        String destinationFileName = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        Result res = transform(sourceFileName,destinationFileName,-key);
        return new Result(ResultCode.OK, Consts.DECRYPT_COMPLETED + res.message());
    }
}
