// thinkinjavaex/chapter14/Ex5.java

import java.util.*;

abstract class Shape{
    void drow() { System.out.println(this + ".drow()"); }
    abstract public String toString();
}

class Circle extends Shape {
    public String toString() { return "Circle"; }
}

class Square extends Shape {
    public String toString() { return "Square"; }
}

class Triangle extends Shape {
    public String toString() { return "Triangle"; }
}

class Rhomboid extends Shape {
    public String toString() { return "Rhomboid"; }
}


public class Ex5 {
    public static void rotate(Shape s){
        if(!(s instanceof Circle)){
            System.out.println(s + " rotate");
        }
    }
    public static void main(String[] args){
        List<Shape> shapeList = Arrays.asList(
            new Circle(), new Square(), new Triangle(), new Rhomboid());
        for(Shape s: shapeList){
            s.drow();
            rotate(s);
        }
    }
}
