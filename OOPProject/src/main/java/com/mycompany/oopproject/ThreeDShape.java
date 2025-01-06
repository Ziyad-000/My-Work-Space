package com.mycompany.oopproject;

public abstract class ThreeDShape extends Shape{
    public ThreeDShape(){}
    public ThreeDShape(String color) {
        super(color);
    }
    public abstract double getVoulme();
}
