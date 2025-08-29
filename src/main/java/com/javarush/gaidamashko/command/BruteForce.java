package com.javarush.gaidamashko.command;

import com.javarush.gaidamashko.consts.Consts;
import com.javarush.gaidamashko.data.Alphabet;
import com.javarush.gaidamashko.data.Result;
import com.javarush.gaidamashko.data.ResultCode;
import com.javarush.gaidamashko.exception.AppException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce extends BaseAction {

    @Override
    public Result execute(String[] parameters) {
        String sourceFileName = parameters[0];
        String destinationFileName = parameters[1];
        int maxCount = 0;
        int bestKey = 0;
        char checkChar = ' ';
        for (int i = 1; i < Alphabet.chars.length; i++) {
            int curCount = getCharCount(sourceFileName, i, checkChar);
            maxCount = Math.max(maxCount, curCount);
            bestKey = (maxCount == curCount) ? i : bestKey;
        }
        Result res = transform(sourceFileName,destinationFileName,bestKey);
        return new Result(ResultCode.OK, Consts.BRUTE_FORCE_COMPLETED + res.message());
    }

    public int getCharCount(String sourceFileName, int key, char character) {
        Path source = getPath(sourceFileName);
        int count = 0;
        try (
                BufferedReader reader = Files.newBufferedReader(source)
        ) {
            int current;
            while ((current = reader.read()) > -1) {
                if (getCharacter(current, key) == character) {
                    count++;
                }
            }
        } catch (IOException e) {
            throw new AppException(e);
        }
        return count;
    }
}
