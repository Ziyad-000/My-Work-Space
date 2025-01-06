package com.mycompany.oopproject;


public class Cube extends ThreeDShape{
    private double side;
    public Cube(double s){
        side = s;
    }
    public Cube(String c, double s){
        super(c);
        side = s;
    }
    public void setSide(double s){
        side = s;
    }
    public double getSide(){
        return side;
    }
    @Override
    public double getArea(){
        return 6 * side * side;
    }
    @Override
    public double getPerimeter(){
        return 12 * side;
    }
    @Override
    public double getVoulme() {
       return side * side * side;
    }
    @Override
    public String howToDraw() {
        return "Draw a cube with side " + side;
    }
    @Override
    public String toString(){
        return "Cube[side=" + side + ", " + super.toString() + "]";
    }

  
}
