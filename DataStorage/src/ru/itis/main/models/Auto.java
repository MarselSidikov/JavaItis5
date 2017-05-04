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
    private User owner;

    public Auto(int id, String model, String color, double carMileage, boolean used, User owner) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.carMileage = carMileage;
        this.used = used;
        this.owner = owner;
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

    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(double carMileage) {
        this.carMileage = carMileage;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
