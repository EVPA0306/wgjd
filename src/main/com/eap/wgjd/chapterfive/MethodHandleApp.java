package com.eap.wgjd.chapterfive;

import com.eap.wgjd.vet.Appointment;
import com.eap.wgjd.vet.Dog;
import com.eap.wgjd.vet.Pet;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by evgenypavlenko on 8/24/16.
 */
public class MethodHandleApp {

    public MethodHandle getMH() throws Throwable {
        MethodHandle mh;
        MethodType mt = MethodType.methodType(void.class);
        MethodHandles.Lookup mhlk = MethodHandles.lookup();

        try {
            Pet dog = new Dog("Star");
            mh = mhlk.findVirtual(dog.getClass(),"examine", mt);
        } catch (NoSuchMethodException | IllegalAccessException ex) {
            throw new AssertionError().initCause(ex);
        }
        return mh;
    }

    public static void main(String...args) throws Throwable {
        MethodHandleApp methodHandleApp = new MethodHandleApp();
        System.out.println(methodHandleApp.getMH());
        MethodHandle methodHandle = methodHandleApp.getMH();
        //methodHandle.invoke()
    }
}
