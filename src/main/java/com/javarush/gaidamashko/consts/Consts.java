package com.javarush.gaidamashko.consts;

import java.io.File;

public interface Consts {
    String TXT_DIR = System.getProperty("user.dir") +
            File.separator +
            "text" +
            File.separator;
    String APPLICATION_CLOSED = "application closed";
    String ENCRYPT_COMPLETED = "Encrypt completed.";
    String DECRYPT_COMPLETED = "Decrypt completed.";
    String BRUTE_FORCE_COMPLETED = "BruteForce completed.";
}
