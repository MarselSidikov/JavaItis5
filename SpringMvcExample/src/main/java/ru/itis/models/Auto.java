package ru.itis.models;

public class Auto {

    private int id;
    private String model;
    private String color;
    private double carMileage;
    private boolean isUsed;

    public Auto(int id, String model, String color, double carMileage, boolean used) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.carMileage = carMileage;
        this.isUsed = used;
    }

    public static class Builder {
        private int id;
        private String model;
        private String color;
        private double carMileage;
        private boolean used;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setCarMileage(double carMileage) {
            this.carMileage = carMileage;
            return this;
        }

        public Builder setUsed(boolean used) {
            this.used = used;
            return this;
        }

        public Auto build() {
            return new Auto(id, model, color, carMileage, used);
        }
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getCarMileage() {
        return carMileage;
    }

    public boolean getIsUsed() {
        return this.isUsed;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Auto){
            Auto that = (Auto)obj;
            return this.id == that.id
                    && this.model.equals(that.model)
                    && this.color.equals(that.color)
                    && this.carMileage == that.carMileage
                    && this.isUsed == that.isUsed;
        }return false;
    }

}
