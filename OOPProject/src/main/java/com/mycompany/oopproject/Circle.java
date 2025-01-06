package com.mycompany.oopproject;

public class Circle extends Shape {
    private double raduis;
    public Circle(double r){
        raduis = r;
    }
    public Circle(String c, double r){
        super(c);
        raduis = r;
    }
    //set method
    public void setRaduis(double r){
        raduis = r;
    }
    //getmethod
    public double getRaduis(){
        return raduis;
    }
    @Override
    public double getArea(){
        return Math.PI * (raduis * raduis);
    }
    @Override
    public double getPerimeter(){
        return 2 * Math.PI * raduis;
    }
    @Override
    public String toString(){
         return "Circle[radius=" + raduis + ", " + super.toString() + "]";
    }
    @Override
    public String howToDraw() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
