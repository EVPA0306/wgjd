package com.eap.wgjd.miscelaneos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by evgenypavlenko on 8/17/16.
 */
public class WorkWithProperties {
    public WorkWithProperties() throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("/Users/evgenypavlenko/Projects/wgjd/data/test.txt")) {
            Properties properties = new Properties();
            properties.setProperty("username", "EVPA");
            properties.setProperty("password", "12345");
            properties.store(fileOutputStream, null);
            fileOutputStream.flush();
            fileOutputStream.close();
        }
        try(FileInputStream fileInputStream = new FileInputStream("/Users/evgenypavlenko/Projects/wgjd/data/test.txt")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            System.out.println(properties);
            fileInputStream.close();
        }
    }

    public static void main(String...args) {
        try {
            WorkWithProperties workWithProperties = new WorkWithProperties();
        } catch (final IOException ex) {
            System.out.println(ex.getStackTrace());
        }
    }
}
