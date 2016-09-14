package com.eap.wgjd.microblog;

import java.util.Arrays;

/**
 * Created by evgenypavlenko on 2/2/16.
 */
public class TestStrings {
    public static void main(String...args) {
        System.out.println(replace("a happy",'a','i'));
        String text = "Hello    world!    ";
        String[] words = text.split(" +");
        System.out.println(Arrays.toString(words));
    }

    private static String replace(String word, char gone, char here) {
        char[] cArray = word.toCharArray();
        char[] cArrayMod = new char[word.length()];

        int i = 0;
        for (char c : cArray) {
            if (c == gone) {
                cArrayMod[i] = here;
            } else {
                cArrayMod[i] = c;
            }
            i++;
        }
        //return word;
        return new String(cArrayMod);
    }
}
