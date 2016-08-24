package com.eap.wgjd.chapterfive;

/**
 * Created by evgenypavlenko on 8/24/16.
 */
public class ScratchImpl {
    private static ScratchImpl instance = null;

    public ScratchImpl() {

    }

    public void run(String[] args) {
        String str = "foo";
        if (args.length > 0)
            str = args[0];
        System.out.println("this is my string: " + str);
    }

    public static void main(String...args) {
        instance = new ScratchImpl();
        instance.run(args);
    }
}
