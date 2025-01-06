package com.mycompany.oopproject;
import java.util.*;

public abstract class Shape implements Drawable {
    private Date dataCreated;
    private String color;
    public Shape(){}
    public Shape(String color){
        this.color = color;
        this.dataCreated = new Date();
    }
    public String getColor(){
        return color;
    }
    public Date getDateCraeted(){
        return dataCreated;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    @Override
    public String toString() {
        return "Shape[color=" + color + ", dateCreated=" + dataCreated + "]";
    }
}
