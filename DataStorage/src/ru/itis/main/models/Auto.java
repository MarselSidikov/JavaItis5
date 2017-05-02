package ru.itis.main.models;

/**
 * Created by Аюпов Аяз on 28.04.2017.
 */
public class Auto implements Model{
    private int id;
    private String model;
    private String color;
    private double carMileage;
    private boolean used;
    private int idOwner;

    public Auto(int id, String model, String color, double carMileage, boolean used, int idOwner) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.carMileage = carMileage;
        this.used = used;
        this.idOwner = idOwner;
    }

    public Auto(int id, String model, String color, double carMileage, boolean used, User user) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.carMileage = carMileage;
        this.used = used;
        this.idOwner = user.getId();
    }

    public Auto(String model, String color, double carMileage, boolean used, User user) {
        this.model = model;
        this.color = color;
        this.carMileage = carMileage;
        this.used = used;
        this.idOwner = user.getId();
    }

    public int getIdOwner() {
        return idOwner;
    }

    public boolean isUsed() {
        return used;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return id+" "+model+" "+color+" "+carMileage+" "+used+" "+idOwner;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof Auto){
            Auto that = (Auto)obj;
            return this.id == that.id
                    && this.model.equals(that.model)
                    && this.color.equals(that.color)
                    && this.carMileage == that.carMileage
                    && this.used == that.used;
        }return false;
    }
}
