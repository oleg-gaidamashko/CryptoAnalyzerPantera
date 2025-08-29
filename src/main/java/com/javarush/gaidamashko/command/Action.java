package com.javarush.gaidamashko.command;


import com.javarush.gaidamashko.data.Result;

public interface Action {
    Result execute(String[] parameters);
}
