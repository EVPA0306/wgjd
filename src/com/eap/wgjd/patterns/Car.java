package com.eap.wgjd.patterns;

/**
 * Created by evgenypavlenko on 8/15/16.
 */
public class Car {

    private final String carName;
    private final String modelYear;

    private Car(CarBuilder builder) {
        carName = builder.carName;
        modelYear = builder.modelYear;
    }

    public static class CarBuilder implements Builder<Car> {

        private String carName;
        private String modelYear;
        private String mileage;

        public CarBuilder carName(String carName) {
            this.carName = carName;
            return this;
        }

        public CarBuilder modelYear(String modelYear) {
            this.modelYear = modelYear;
            return this;
        }

        public CarBuilder mileage(String mileage) {
            this.mileage = mileage;
            return this;
        }

        @Override
        public Car build() {
            return new Car(this);
        }
    }

    public String toString() {
        return getClass().getName() + "@" + carName + "_" + modelYear;
    }
}
