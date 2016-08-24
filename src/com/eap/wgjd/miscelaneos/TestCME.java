package com.eap.wgjd.miscelaneos;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by evgenypavlenko on 8/18/16.
 * It tests ConcurentModificationException
 */
public class TestCME {
    List<Integer> list = new ArrayList<>();


    public TestCME() {
        for (int i = 0; i <= 10000; i++) {
            list.add(23 * i);
        }
    }

    public static void main(String... args)  {

        TestCME testCME = new TestCME();
        Iterator<Integer> iter = testCME.list.iterator();
        //ListIterator<Integer> iter = testCME.list.listIterator();


        new Thread(new Runnable() {
            public void run() {
                while (iter.hasNext()) {
                    Integer it = iter.next();
                    //System.out.println("Thread one method: " +  it);
                    iter.remove();
                }
            }
        }).start();


        new Thread(new Runnable() {
            public void run() {
                while (iter.hasNext()) {
                    Integer it = iter.next();
                    //System.out.println("Thread second method: " +  it);
                    iter.remove();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                while (iter.hasNext()) {
                    Integer it = iter.next();
                    //System.out.println("Thread third method: " +  it);
                    iter.remove();
                }
            }
        }).start();
    }
}