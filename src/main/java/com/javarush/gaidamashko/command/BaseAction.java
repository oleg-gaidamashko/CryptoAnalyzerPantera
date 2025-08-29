package com.javarush.gaidamashko.command;

import com.javarush.gaidamashko.consts.Consts;
import com.javarush.gaidamashko.data.Alphabet;
import com.javarush.gaidamashko.data.Result;
import com.javarush.gaidamashko.data.ResultCode;
import com.javarush.gaidamashko.exception.AppException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class BaseAction implements Action {

    public Result transform(String sourceFileName, String destinationFileName, int key) {
        Path source = getPath(sourceFileName);
        Path destination = getPath(destinationFileName);
        try (
                BufferedReader reader = Files.newBufferedReader(source);
                BufferedWriter writer = Files.newBufferedWriter(destination)
        ) {
            int current;
            while ((current = reader.read()) > -1) {
                writer.write(getCharacter(current, key));
            }

        } catch (IOException e) {
            throw new AppException(e);
        }
        return new Result(ResultCode.OK, ".");
    }

    protected char getCharacter(int current, int key) {

        char res = (char) current;
        int length = Alphabet.chars.length;
        if (Alphabet.index.containsKey(res)) {
            Integer index = Alphabet.index.get(res);
            if (key >= 0) {
                index = (index + key + length) % length;
            } else {
                index = (index + key + length * (1-key/length) ) % length;
            }
            res = Alphabet.chars[index];
        }
        return res;
    }

    protected Path getPath(String fileName) {
        Path res = Path.of(fileName);
        return res.isAbsolute() ? res : Path.of(Consts.TXT_DIR + fileName);
    }
}
