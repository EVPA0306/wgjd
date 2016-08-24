package com.eap.wgjd.patterns;

/**
 * Created by evgenypavlenko on 8/18/16.
 */
public class WorkUnit<T> {
    private final T workUnit;

    public WorkUnit(T workUnit) {
        this.workUnit = workUnit;
    }

    public T getWork() {
        return workUnit;
    }
}
